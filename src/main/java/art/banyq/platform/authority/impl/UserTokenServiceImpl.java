package art.banyq.platform.authority.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import art.banyq.common.AuthorityLevel;
import art.banyq.platform.authority.UserToken;
import art.banyq.platform.authority.UserTokenService;

@Service
@PropertySource("classpath:system.properties")
public class UserTokenServiceImpl implements UserTokenService {
    @Value("${token.password}")
    private String tokenPasswd;

    @Override
    public UserToken encode(String userId, AuthorityLevel authLevel, int version) throws UserToken.UserTokenEncodeException {
        return new UserToken(userId, authLevel, version, this.tokenPasswd);
    }

    @Override
    public UserToken encode(String userId, AuthorityLevel authLevel, int version, long expireTime) throws UserToken.UserTokenEncodeException {
        return new UserToken(userId, authLevel, version, expireTime, this.tokenPasswd);
    }

    @Override
    public UserToken decode(String token) throws UserToken.UserTokenVerifyException, UserToken.UserTokenExpireException {
        return new UserToken(token, this.tokenPasswd);
    }
}
