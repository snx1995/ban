package art.banyq.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import art.banyq.persistent.dao.UserDAO;
import art.banyq.common.ReqResult;
import art.banyq.common.ResStatus;
import art.banyq.common.entity.vo.user.LoginParam;
import art.banyq.common.entity.vo.user.RegisterParam;
import art.banyq.common.entity.vo.user.UserVO;
import art.banyq.common.exception.ReqHandleException;
import art.banyq.platform.authority.UserTokenService;

@Controller
@ResponseBody
@RequestMapping("/auth")
public class AuthController {
    private UserTokenService tokenService;
    private UserDAO userDAO;

    public AuthController(UserTokenService tokenService, UserDAO userDAO) {
        this.tokenService = tokenService;
        this.userDAO = userDAO;
    }

    @PostMapping("/login")
    public ReqResult login(@RequestBody LoginParam param, HttpServletResponse response) {
        if ("exception".equals(param.getAccount())) throw new ReqHandleException(ResStatus.AUTH_FAILED);
        UserVO user = userDAO.loginSelect(param);
        if (user == null) throw new ReqHandleException("账号或密码错误!");
        response.setHeader("Set-Token", tokenService.encode(user.getId(), user.getAuth(), '0').toString());
        return ReqResult.succeeded(user);
    }

    @Transactional
    @PostMapping("/register")
    public ReqResult register(@RequestBody RegisterParam param) {
        int count = userDAO.insertUser(param);
        if (count != 1) throw new Error();
        return ReqResult.succeeded(param);
    }
}
