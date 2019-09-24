package top.ban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ban.business.dao.UserMapper;
import top.ban.common.AuthorityLevel;
import top.ban.common.entity.vo.user.LoginParam;
import top.ban.common.entity.vo.user.RegisterParam;
import top.ban.common.entity.vo.user.UserVO;
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
//        UserVO user = new UserVO();
//        if ("banyq".equals(param.getAccount())) {
//            user.setAuthorityLevel(AuthorityLevel.SUPER_ADMIN);
//            user.setToken(tokenService.encode("banyq", AuthorityLevel.SUPER_ADMIN, 0).toString());
//            user.setId("banyq");
//            user.setName("banyq");
//            user.setVersion(0);
//        } else if ("admin".equals(param.getAccount())) {
//            user.setAuthorityLevel(AuthorityLevel.ADMIN);
//            user.setToken(tokenService.encode("admin", AuthorityLevel.ADMIN, 0).toString());
//            user.setId("admin");
//            user.setName("admin");
//            user.setVersion(0);
//        } else if ("user".equals(param.getAccount())) {
//            user.setAuthorityLevel(AuthorityLevel.USER);
//            user.setToken(tokenService.encode("user", AuthorityLevel.USER, 0).toString());
//            user.setId("user");
//            user.setName("user");
//            user.setVersion(0);
//        }
        return userMapper.selectIdPassword(param);
    }

    @PostMapping("/register")
    public RegisterParam register(@RequestBody RegisterParam param) {
        int count = userMapper.insertUser(param);
        return param;
    }
}
