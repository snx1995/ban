package art.banyq.common.entity.vo.user;

import art.banyq.common.AuthorityLevel;

public class UserVO {
    private String id;
    private String name;
    private String token;
    private Integer version;
    private AuthorityLevel authLv;

    public AuthorityLevel getAuthLv() {
        return authLv;
    }

    public void setAuthLv(AuthorityLevel authLv) {
        this.authLv = authLv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
