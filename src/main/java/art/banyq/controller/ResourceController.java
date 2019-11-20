package art.banyq.controller;

import art.banyq.common.entity.vo.ResourceVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/resource")
public class ResourceController {
    @PostMapping("/upload")
    public ResourceVO upload(MultipartFile file) {
        ResourceVO resource = new ResourceVO();
        File dir = new File("/resource");
        dir.mkdirs();
        File localFile = new File(dir, "test.txt");
        try {
            file.transferTo(localFile);
            resource.setPath(localFile.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resource;
    }
}
