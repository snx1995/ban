package top.ban.common.exception;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Object data;

    public BaseException(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}