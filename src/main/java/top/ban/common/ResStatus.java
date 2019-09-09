package top.ban.common;

public enum ResStatus {
    FAILED(-1, "failed"),
    SUCCEEDED(0, "success")
    ;

    private int code;
    private String msg;

    private ResStatus(int code, String defaultMsg) {
        this.code = code;
        this.msg = defaultMsg;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }
}