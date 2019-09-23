package top.ban.common.exception;

public class InvalidParamException extends BaseException {

    private static final long serialVersionUID = 1L;

    public InvalidParamException(Object data) {
        super(data);
    }
}
