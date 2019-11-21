package art.banyq.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import art.banyq.persistent.dao.UserDAO;
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
    private UserDAO userDAO;

    public AuthController(UserTokenService tokenService, UserDAO userDAO) {
        this.tokenService = tokenService;
        this.userDAO = userDAO;
    }

    @PostMapping("/login")
    public UserVO login(@RequestBody LoginParam param, HttpServletResponse response) {
        if ("exception".equals(param.getAccount())) throw new ReqHandleException(ResStatus.AUTH_FAILED);
        UserVO user = userDAO.selectIdPassword(param);
        response.setHeader("Set-Token", tokenService.encode(user.getId(), user.getAuthLv(), user.getVersion()).toString());
        return user;
    }

    @Transactional
    @PostMapping("/register")
    public RegisterParam register(@RequestBody RegisterParam param) {
        int count = userDAO.insertUser(param);
        if (count != 1) throw new Error();
        return param;
    }

    @PostMapping("/test")
    public Object test(@RequestBody UserVO user) {
        return user;
    }
}
