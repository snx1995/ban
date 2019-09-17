package top.ban.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ban.business.dao.TestDao;
import top.ban.common.AuthorityLevel;
import top.ban.common.annotation.AuthLV;
import top.ban.common.annotation.Required;
import top.ban.common.entity.user.User;
import top.ban.common.entity.vo.TestVO;
import top.ban.common.exception.InvalidParamException;
import top.ban.platform.authority.UserToken;

import java.util.HashMap;

@RestController
@RequestMapping("/learn")
@AuthLV(AuthorityLevel.SUPER_ADMIN)
class FirstController {
    private TestDao testDao;

    public FirstController(TestDao testDao) {
        this.testDao = testDao;
    }

    @AuthLV(AuthorityLevel.ADMIN)
    @GetMapping("/{name}")
    public HashMap<String, Object> name(@PathVariable @Required String name) {
        if ("error".equals(name)) throw new InvalidParamException(name);
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", 11);
        return result;
    }

    @GetMapping("/test/select/{id}")
    public TestVO test(@PathVariable Integer id) {
        TestVO test = testDao.selectById(id);
        return test;
    }

    @GetMapping("/test/token")
    public HashMap<String, Object> testToken() {
        UserToken token = new UserToken("adwrfsxcxasdsd-231-asdd", AuthorityLevel.SUPER_ADMIN, 0);
        String expiredToken = new UserToken("banyq", AuthorityLevel.SUPER_ADMIN, 0, System.currentTimeMillis()).toString();
        String tokenStr = token.toString();

        HashMap<String, Object> result = new HashMap<>();
        try {
            UserToken decToken = new UserToken(tokenStr);
            result.put("user", decToken);
        } catch (UserToken.UserTokenEncodeException | UserToken.UserTokenVerifyException | UserToken.UserTokenExpireException e) {
            result.put("error", e.getMessage());
        }

        try {
            UserToken decToken = new UserToken(expiredToken);
            result.put("user", decToken);
        } catch (UserToken.UserTokenEncodeException | UserToken.UserTokenVerifyException | UserToken.UserTokenExpireException e) {
            result.put("error2", e.getMessage());
        }

        return result;
    }
}
