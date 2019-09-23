package top.ban.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ban.business.dao.UserMapper;
import top.ban.common.entity.vo.user.LoginParam;
import top.ban.common.entity.vo.user.RegisterParam;
import top.ban.common.entity.vo.user.UserVO;
import top.ban.platform.authority.UserTokenService;
import top.ban.platform.component.SysEventBus;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserTokenService tokenService;
    private UserMapper userMapper;
    private SysEventBus eventBus;

    public AuthController(UserTokenService tokenService, UserMapper userMapper, SysEventBus eventBus) {
        this.tokenService = tokenService;
        this.userMapper = userMapper;
        this.eventBus = eventBus;
    }

    @PostMapping("/login")
    public UserVO login(@RequestBody LoginParam param) {
        UserVO user = userMapper.selectIdPassword(param);
        user.setToken(tokenService.encode(user.getId(), user.getAuthorityLevel(), user.getVersion()).toString());
        return user;
    }

    @PostMapping("/register")
    public RegisterParam register(@RequestBody RegisterParam param) {
        int count = userMapper.insertUser(param);
        return param;
    }
}
