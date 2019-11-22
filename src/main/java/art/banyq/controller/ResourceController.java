package art.banyq.controller;

import art.banyq.common.AuthorityLevel;
import art.banyq.common.ResStatus;
import art.banyq.common.annotation.AuthLV;
import art.banyq.common.entity.po.ResourcePO;
import art.banyq.common.exception.ReqHandleException;
import art.banyq.persistent.dao.ResourceDAO;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/resource")
public class ResourceController {
    private ResourceDAO resourceDAO;

    public ResourceController(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    @PostMapping("/upload")
    // @AuthLV(AuthorityLevel.ADMIN)
    public List<ResourcePO> upload(MultipartFile[] files) {
        List<ResourcePO> result = new ArrayList<>(files.length);
        for (MultipartFile file : files) {
            ResourcePO resource = new ResourcePO();
            File dir = new File("resource_files");
            dir.mkdirs();
            String filename = file.getOriginalFilename();
            if (filename != null) filename = filename.replaceAll(".*(\\.\\w*)", Long.toHexString(System.currentTimeMillis()) + "$1");
            else throw new ReqHandleException(ResStatus.INVALID_PARAM, "filename is invalid");
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

    @GetMapping("/get")
    public void img(Integer id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding(request.getCharacterEncoding());
        ResourcePO resource = resourceDAO.select(id);
        File file = new File(resource.getPath());
        if (!file.exists()) {
            response.sendError(404);
            return;
        }
        FileInputStream fis = new FileInputStream(file);
        response.setHeader("Content-Disposition", "attachment; filename=" + resource.getName());
        IOUtils.copy(fis, response.getOutputStream());
        response.flushBuffer();
        if (fis != null) {
            try {
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
