package art.banyq.controller;

import art.banyq.common.ReqResult;
import art.banyq.common.ResStatus;
import art.banyq.common.entity.po.ResourcePO;
import art.banyq.common.entity.vo.ResourceVO;
import art.banyq.common.exception.ReqHandleException;
import art.banyq.persistent.dao.ResourceDAO;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@Controller
@RequestMapping("/resource")
public class ResourceController {
    private ResourceDAO resourceDAO;

    public ResourceController(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    @PostMapping("/upload")
    public ResourcePO upload(MultipartFile file) {
        ResourcePO resource = new ResourcePO();

        File dir = new File("resource");
        dir.mkdirs();
        String filename = file.getOriginalFilename();
        if (filename != null) filename = filename.replaceAll(".*\\.(\\w*)", Long.toHexString(System.currentTimeMillis()) + "$1");
        else throw new ReqHandleException(ResStatus.INVALID_PARAM, "filename is invalid");
        File localFile = new File(dir.getAbsolutePath(), filename);
        resource.setName(file.getOriginalFilename());
        resource.setPath(localFile.getAbsolutePath());
        resource.setUpload_user(1);
        resourceDAO.insert(resource);
        try {
            file.transferTo(localFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resource;
    }

    @GetMapping("/get")
    public void img(Integer id, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding(request.getCharacterEncoding());
        ResourcePO resource = resourceDAO.select(id);
        File file = new File(resource.getPath());
        if (!file.exists()) throw new ReqHandleException(ResStatus.NOT_FOUND, "resource does not exists");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment; filename=" + resource.getName());
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            throw new ReqHandleException(ResStatus.FAILED, e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
