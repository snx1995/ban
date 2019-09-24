package top.ban.platform.authority;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import top.ban.common.AuthorityLevel;
import top.ban.common.exception.BaseException;
import top.ban.common.util.DateUtil;

import java.util.Date;

public class UserToken {
    private static final String VERIFY_ERROR_MSG = "token验证失败，请重新获取";
    private static final String EXPIRE_ERROR_MSG = "token已过期：";
    private static final String ENCODE_ERROR_MSG = "token加密失败";

    private static final long MS_7_DAYS = 604800000L;

    private String userId;
    private AuthorityLevel authLevel;
    private Long expireTime;
    private Integer version;
    private String tokenPasswd;

    public String getUserId() {
        return userId;
    }

    public AuthorityLevel getAuthLevel() {
        return authLevel;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public Integer getVersion() {
        return version;
    }

    private String encodedStr;

    public UserToken(String userId, AuthorityLevel authLevel, int version, String tokenPasswd) throws UserTokenEncodeException {
        this(userId, authLevel, version, System.currentTimeMillis() + MS_7_DAYS, tokenPasswd);
    }

    public UserToken(String userId, AuthorityLevel authLevel, int version, long expireTime, String tokenPasswd) throws UserTokenEncodeException {
        this.userId = userId;
        this.authLevel = authLevel;
        this.expireTime = expireTime;
        this.version = version;
        this.tokenPasswd = tokenPasswd;
        this.encodedStr = this.encode();
    }

    public UserToken(String encodedStr, String tokenPasswd) throws UserTokenExpireException, UserTokenVerifyException {
        this.encodedStr = encodedStr;
        this.tokenPasswd = tokenPasswd;
        this.decode(encodedStr);
    }

    private String encode() throws UserTokenEncodeException {
        String originStr = this.version + "," + this.userId + "," + authLevel.getLv() + "," + this.expireTime;
        String base64Str = Base64.getEncoder().encodeToString(originStr.getBytes(StandardCharsets.UTF_8));
        return  base64Str + "." + md5Encode(base64Str);
    }

    private String md5Encode(String originStr) throws UserTokenEncodeException {
        String md5Str;
        try {
            MessageDigest ds = MessageDigest.getInstance("MD5");
            ds.update((originStr + "__" + this.tokenPasswd).getBytes(StandardCharsets.UTF_8));
            byte[] result = ds.digest();
            StringBuilder builder = new StringBuilder();
            for (byte b : result) {
                int bt = b & 0xff;
                if (bt < 16) builder.append(0);
                builder.append(Integer.toHexString(bt));
            }
            md5Str = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new UserTokenEncodeException();
        }
        return md5Str;
    }

    private void decode(String encodedStr) throws UserTokenExpireException, UserTokenVerifyException {
        if (encodedStr == null || !encodedStr.contains(".")) throw new UserTokenVerifyException();
        String[] spiltStr = encodedStr.split("\\.");
        String base64Str = spiltStr[0];
        String md5Str = spiltStr[1];
        if (!md5Encode(base64Str).equals(md5Str)) throw new UserTokenVerifyException();
        String originStr = new String(Base64.getDecoder().decode(base64Str));
        try {
            String[] items = originStr.split(",");
            // TODO 获取最新version，判断token是否失效
            this.version = Integer.parseInt(items[0]);
            this.userId = items[1];
            this.authLevel = AuthorityLevel.getAuthorityLevel(Integer.parseInt(items[2]));
            this.expireTime = Long.parseLong(items[3]);
        } catch (Exception e) {
            throw new UserTokenVerifyException();
        }
        if (this.expireTime < System.currentTimeMillis()) throw new UserTokenExpireException(this.expireTime);
    }

    @Override
    public String toString() {
        return this.encodedStr;
    }

    public static class UserTokenVerifyException extends BaseException {
        private static final long serialVersionUID = 1L;

        public UserTokenVerifyException() {
            super(VERIFY_ERROR_MSG);
        }
    }

    public static class UserTokenExpireException extends BaseException {
        private static final long serialVersionUID = 1L;

        public UserTokenExpireException(Long expireDate) {
            super(EXPIRE_ERROR_MSG + DateUtil.format(new Date(expireDate), "yyyy-MM-dd HH:mm:ss"));
        }
    }

    public static class UserTokenEncodeException extends BaseException {
        private static final long serialVersionUID = 1L;

        public UserTokenEncodeException() {
            super(ENCODE_ERROR_MSG);
        }
    }
}
