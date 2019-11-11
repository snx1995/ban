package top.ban.common;

public enum AuthorityLevel {
    DEVELOPER(-1), SUPER_ADMIN(0), ADMIN(1), USER(10), USELESS(1000);

    private int lv;

    AuthorityLevel(int lv) {
        this.lv = lv;
    }

    public boolean higherThan(AuthorityLevel another) {
        return another.lv > this.lv;
    }

    public int getLv() {
        return this.lv;
    }

    public static AuthorityLevel getAuthorityLevel(int lv) {
        switch (lv) {
            case -1:
                return DEVELOPER;
            case 0:
                return SUPER_ADMIN;
            case 1:
                return ADMIN;
            case 10:
                return USER;
            default:
                return USELESS;
        }
    }

}
