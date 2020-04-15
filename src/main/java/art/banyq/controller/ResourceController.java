package art.banyq.controller;

import art.banyq.common.ReqResult;
import art.banyq.common.entity.message.file.MsgFileType;
import art.banyq.common.entity.po.ResourcePO;
import art.banyq.common.entity.resource.ResFile;
import art.banyq.common.exception.ReqHandleException;
import art.banyq.persistent.dao.ResourceDAO;
import net.coobird.thumbnailator.Thumbnails;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/resource")
@PropertySource("classpath:system.properties")
public class ResourceController {
    private static final double IMG_COMPRESS_SCALE = 0.3;

    @Value("${resource.root}")
    private String resRootPath;

    private ResourceDAO resourceDAO;

    public ResourceController(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    @PostMapping("/upload111")
    // @AuthLV(AuthorityLevel.ADMIN)
    public List<ResourcePO> upload111(MultipartFile[] files) {
        List<ResourcePO> result = new ArrayList<>(files.length);
        for (MultipartFile file : files) {
            ResourcePO resource = new ResourcePO();
            File dir = new File("resource_files");
            dir.mkdirs();
            String filename = file.getOriginalFilename();
            if (filename != null) filename = filename.replaceAll(".*(\\.\\w*)", Long.toHexString(System.currentTimeMillis()) + "$1");
            else throw new ReqHandleException("filename is invalid");
            File localFile = new File(dir.getAbsolutePath(), filename);
            resource.setName(file.getOriginalFilename());
            resource.setPath(localFile.getAbsolutePath());
            resource.setUpload_user(1);
            result.add(resource);
            // assert resourceDAO.insert(resource) == 1 : "database insert failed!";
            resourceDAO.insert(resource);
            try {
                file.transferTo(localFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Transactional
    @PostMapping("/upload")
    public ReqResult upload(MultipartFile file, Integer linkId, MsgFileType type) {
        File rootDir = new File(resRootPath);
        if (!rootDir.exists()) {
            rootDir.mkdirs();
        }
        String originalFilePath = resRootPath + '/' + file.getOriginalFilename();
        ResFile f = new ResFile();
        f.setLinkId(linkId);
        f.setType(type);
        if (type == MsgFileType.IMAGE) {
            try {
                String compressedFilePath = compressImage(file);
                f.setCompressed(compressedFilePath);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ReqHandleException("文件压缩失败:" + e.getMessage());
            }
        }
        try {
            file.transferTo(new File(originalFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReqHandleException("保存原始文件失败:" + e.getMessage());
        }
        f.setOriginal(originalFilePath);

        Integer result = resourceDAO.insertOne(f);
        if (result != 1) throw new ReqHandleException("数据库写入失败");
        return ReqResult.succeeded(f);
    }

    private String compressImage(MultipartFile file, double scale) throws IOException {
        String path = resRootPath + "/" + "compressed_" + file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        Thumbnails.of(inputStream).scale(scale).toFile(path);
        return path;
    }

    private String compressImage(MultipartFile file) throws IOException {
        return compressImage(file, IMG_COMPRESS_SCALE);
    }
}
