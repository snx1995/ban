package top.ban.test;

import org.junit.Test;
import top.ban.common.AuthorityLevel;
import top.ban.platform.authority.UserToken;

import java.util.Date;

public class UserTokenTest {

    @Test
    public void test() {
        UserToken validToken = new UserToken("banyq", AuthorityLevel.SUPER_ADMIN, 0);
        UserToken expiredToken = new UserToken("banyq", AuthorityLevel.SUPER_ADMIN, 0, System.currentTimeMillis() - 1000);
        String invalidToken = "123addfcaada.31244";

        try {
            UserToken decodedToken = new UserToken(validToken.toString());

            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            UserToken decodedToken = new UserToken(expiredToken.toString());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            UserToken decodedToken = new UserToken(invalidToken);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    @Test
    public void genToken() {
        UserToken token = new UserToken("banyq", AuthorityLevel.SUPER_ADMIN, 0);
        Date date = new Date(token.getExpireTime());
        System.out.println();
    }
}
