package top.ban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ban.common.AuthorityLevel;
import top.ban.common.ResStatus;
import top.ban.common.annotation.AuthLV;
import top.ban.common.entity.vo.article.IndexPageArticleVO;
import top.ban.common.exception.ReqHandleException;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("/testAuthLv")
    @AuthLV(AuthorityLevel.ADMIN)
    public Object test() {
        return "new ArrayList<Integer>(3)";
    }

    @PostMapping("/uploadArticle")
    public Object uploadArticle(@RequestBody IndexPageArticleVO article) {
        return article;
    }

    @GetMapping("/errorType")
    public Object errorType(String type) {
        switch (type) {
            case "error":
                throw new ReqHandleException(ResStatus.FAILED, "failed");
            case "auth":
                throw new ReqHandleException(ResStatus.AUTH_FAILED);
            case "param":
                throw new ReqHandleException(ResStatus.INVALID_PARAM, "name");
        }
        return "Succeeded";
    }
}
