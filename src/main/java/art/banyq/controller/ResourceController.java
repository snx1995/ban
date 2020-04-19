package art.banyq.controller;

import art.banyq.common.ReqResult;
import art.banyq.common.entity.message.file.MsgFileType;
import art.banyq.common.entity.po.ResourcePO;
import art.banyq.common.entity.resource.ResFile;
import art.banyq.common.exception.ReqHandleException;
import art.banyq.common.util.FileUtil;
import art.banyq.persistent.dao.ResourceDAO;
import art.banyq.platform.config.SysConfig;
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

    private File rootDir;

    private ResourceDAO resourceDAO;

    public ResourceController(ResourceDAO resourceDAO, SysConfig sysConfig) {
        this.resourceDAO = resourceDAO;
        rootDir = new File(sysConfig.getResourceRoot());
        if (!rootDir.exists()) {
            rootDir.mkdirs();
        }
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
        String storeName = FileUtil.toUniqueFilename(file.getOriginalFilename());

        String originalFilePath = storeName;
        ResFile f = new ResFile();
        f.setLinkId(linkId);
        f.setType(type);
        f.setFilename(file.getOriginalFilename());
        f.setOriginal(originalFilePath);
        if (type == MsgFileType.IMAGE) {
            try {
                String compressedFilePath = "compressed_" + storeName;
                compressImage(file, compressedFilePath);
                f.setCompressed(compressedFilePath);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ReqHandleException("图片压缩失败:" + e.getMessage());
            }
        }
        try {
            file.transferTo(new File(rootDir, originalFilePath));
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReqHandleException("保存原始文件失败:" + e.getMessage());
        }

        Integer result = resourceDAO.insertOne(f);
        if (result != 1) throw new ReqHandleException("数据库写入失败");
        return ReqResult.succeeded(f);
    }

    private void compressImage(MultipartFile file, double scale, String compressedFilePath) throws IOException {
        File compressedFile = new File(rootDir, compressedFilePath);
        InputStream inputStream = file.getInputStream();
        Thumbnails.of(inputStream).scale(scale).toFile(compressedFile.getAbsolutePath());
    }

    private void compressImage(MultipartFile file, String compressedFilePath) throws IOException {
        this.compressImage(file, IMG_COMPRESS_SCALE, compressedFilePath);
    }
}
