package top.ban.common.exception;

public class AuthorizationException extends BaseException {
    private static final long serialVersionUID = 1L;

    public AuthorizationException() {
        super("auth failed");
    }
}
