package top.ban.common.exception;

public class InvalidParamException extends RuntimeException {
    private Object data;

    public InvalidParamException(Object data) {
        super("invalid param");
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
