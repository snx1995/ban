package art.banyq.common;

public enum ResStatus {
    FAILED(-1, "failed"),
    SUCCEEDED(0, "success"),
    AUTH_FAILED(1, "auth failed"),
    INVALID_PARAM(2, "invalid param"),
    NOT_FOUND(3, "data not found"),
    ERROR(4, "server error")
    ;

    public int code;
    public String msg;

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