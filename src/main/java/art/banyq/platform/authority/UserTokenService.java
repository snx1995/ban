package art.banyq.platform.authority;

import art.banyq.common.AuthorityLevel;

public interface UserTokenService {
    UserToken encode(String userId, AuthorityLevel authLevel, int version) throws UserToken.UserTokenEncodeException;

    UserToken encode(String userId, AuthorityLevel authLevel, int version, long expireTime) throws UserToken.UserTokenEncodeException;

    UserToken decode(String token) throws UserToken.UserTokenVerifyException, UserToken.UserTokenExpireException;

}
