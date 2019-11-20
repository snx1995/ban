package art.banyq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import art.banyq.service.dao.UserMapper;
import art.banyq.common.AuthorityLevel;
import art.banyq.common.ResStatus;
import art.banyq.common.entity.vo.user.LoginParam;
import art.banyq.common.entity.vo.user.RegisterParam;
import art.banyq.common.entity.vo.user.UserVO;
import art.banyq.common.exception.ReqHandleException;
import art.banyq.platform.authority.UserTokenService;

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
        if ("exception".equals(param.getAccount())) throw new ReqHandleException(ResStatus.AUTH_FAILED);
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
