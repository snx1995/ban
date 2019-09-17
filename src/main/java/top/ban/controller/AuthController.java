package top.ban.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ban.common.AuthorityLevel;
import top.ban.common.annotation.AuthLV;
import top.ban.platform.authority.UserToken;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @AuthLV(AuthorityLevel.SUPER_ADMIN)
    @GetMapping(value = "/testGenToken")
    public Object genToken(String userId) {
        return new UserToken(userId, AuthorityLevel.SUPER_ADMIN, 0).toString();
    }
}
