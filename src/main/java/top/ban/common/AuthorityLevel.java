package top.ban.common;

public enum AuthorityLevel {
    SUPER_ADMIN(0), ADMIN(1), USER(10), USELESS(1000);

    private int lv;

    AuthorityLevel(int lv) {
        this.lv = lv;
    }

    public boolean higherThan(AuthorityLevel another) {
        return this.lv <= another.lv;
    }

    public int getLv() {
        return this.lv;
    }

    public static AuthorityLevel getAuthorityLevel(int lv) {
        switch (lv) {
            case 0:
                return SUPER_ADMIN;
            case 1:
                return ADMIN;
            case 2:
                return USER;
            default:
                return USELESS;
        }
    }

}
