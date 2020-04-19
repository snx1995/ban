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
import java.nio.file.Path;
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

    @Transactional
    @PostMapping("/upload")
    public ReqResult upload(MultipartFile file, Integer linkId, MsgFileType type) {
        String storeName = FileUtil.toUniqueFilename(file.getOriginalFilename());
        String originalFilePath = storeName;
        String compressedFilePath = "compressed_" + storeName;

        ResFile f = new ResFile();
        f.setLinkId(linkId);
        f.setType(type);
        f.setFilename(file.getOriginalFilename());
        f.setOriginal(originalFilePath);
        f.setCompressed(compressedFilePath);
        
        try {
            File originalFile = new File(rootDir, originalFilePath);
            if (!originalFile.exists()) originalFile.mkdirs();
            file.transferTo(originalFile);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ReqHandleException("保存原始文件失败:" + e.getMessage());
        }

        if (type == MsgFileType.IMAGE) {
            try {
                compressImage(file, compressedFilePath);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ReqHandleException("图片压缩失败:" + e.getMessage());
            }
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
