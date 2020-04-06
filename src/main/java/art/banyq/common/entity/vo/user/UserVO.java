package art.banyq.common.entity.vo.user;

import art.banyq.common.AuthorityLevel;

public class UserVO {
    private String id;
    private String name;
    private String token;
    private Integer lv;
    private AuthorityLevel auth;

    public AuthorityLevel getAuth() {
        return auth;
    }

    public void setAuth(AuthorityLevel auth) {
        this.auth = auth;
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

    public Integer getLv() {
        return lv;
    }

    public void setLv(Integer lv) {
        this.lv = lv;
    }
}
