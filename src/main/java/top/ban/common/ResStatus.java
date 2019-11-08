package top.ban.common;

public enum ResStatus {
    FAILED(-1, "failed"),
    SUCCEEDED(0, "success"),
    AUTH_FAILED(1, "auth failed"),
    INVALID_PARAM(2, "invalid param")
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