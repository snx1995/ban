package top.ban.common.entity.vo.user;

import top.ban.common.AuthorityLevel;

public class UserVO {
    private String id;
    private String name;
    private String token;
    private Integer version;
    private AuthorityLevel authorityLevel;

    public AuthorityLevel getAuthorityLevel() {
        return authorityLevel;
    }

    public void setAuthorityLevel(AuthorityLevel authorityLevel) {
        this.authorityLevel = authorityLevel;
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
