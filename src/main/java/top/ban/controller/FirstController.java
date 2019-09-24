package top.ban.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import top.ban.business.dao.TestDao;
import top.ban.common.AuthorityLevel;
import top.ban.common.annotation.AuthLV;
import top.ban.common.annotation.Required;
import top.ban.common.entity.vo.TestVO;
import top.ban.common.exception.InvalidParamException;
import top.ban.platform.authority.UserToken;
import top.ban.platform.authority.UserTokenService;

import java.util.HashMap;

@Controller
@RequestMapping("/learn")
@AuthLV(AuthorityLevel.SUPER_ADMIN)
class FirstController {
    private TestDao testDao;
    private UserTokenService tokenService;

    public FirstController(TestDao testDao, UserTokenService tokenService) {
        this.testDao = testDao;
        this.tokenService = tokenService;
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

    @GetMapping("/token")
    public UserToken testToken() {
        return tokenService.encode("banyq", AuthorityLevel.SUPER_ADMIN, 0);
    }
}
