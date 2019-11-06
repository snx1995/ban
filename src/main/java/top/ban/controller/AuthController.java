package top.ban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ban.business.dao.UserMapper;
import top.ban.common.AuthorityLevel;
import top.ban.common.entity.vo.user.LoginParam;
import top.ban.common.entity.vo.user.RegisterParam;
import top.ban.common.entity.vo.user.UserVO;
import top.ban.common.exception.AuthorizationException;
import top.ban.platform.authority.UserTokenService;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private UserTokenService tokenService;
    private UserMapper userMapper;

    public AuthController(UserTokenService tokenService, UserMapper userMapper) {
        this.tokenService = tokenService;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public UserVO login(@RequestBody LoginParam param) {
        if ("exception".equals(param.getAccount())) throw new AuthorizationException();
        UserVO user = new UserVO();
        user.setAuthLv(AuthorityLevel.SUPER_ADMIN);
        user.setName(param.getAccount());
        user.setVersion(0);
        user.setId("banyq");
        user.setToken(tokenService.encode("banyq", AuthorityLevel.SUPER_ADMIN, 0).toString());
        return user;
    }

    @Transactional
    @PostMapping("/register")
    public RegisterParam register(@RequestBody RegisterParam param) {
        int count = userMapper.insertUser(param);
        if (count != 1) throw new Error();
        return param;
    }

    @PostMapping("/test")
    public Object test(@RequestBody UserVO user) {
        return user;
    }
}
