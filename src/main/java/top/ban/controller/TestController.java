package top.ban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ban.common.AuthorityLevel;
import top.ban.common.annotation.AuthLV;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/test")
@AuthLV(AuthorityLevel.USER)
public class TestController {

    @GetMapping("/testAuthLv")
    @AuthLV(AuthorityLevel.ADMIN)
    public Object test() {
        return new HashMap<String, Object>();
    }
}
