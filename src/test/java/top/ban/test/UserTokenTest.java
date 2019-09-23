package top.ban.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.ban.common.AuthorityLevel;
import top.ban.common.entity.user.User;
import top.ban.platform.authority.UserToken;
import top.ban.platform.authority.UserTokenService;
import top.ban.platform.authority.impl.UserTokenServiceImpl;

public class UserTokenTest {
    private UserTokenService tokenService = new UserTokenServiceImpl();

    @Test
    public void testToken() {
        UserToken token = tokenService.encode("banyq", AuthorityLevel.SUPER_ADMIN, 0);
        UserToken decoded = tokenService.decode(token.toString());
        System.out.println();
    }
}
