package top.ban.platform;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import top.ban.common.ReqErrorResult;
import top.ban.common.exception.AuthorizationException;
import top.ban.common.exception.InvalidParamException;

@RestController
@ControllerAdvice
public class CenterExceptionHandler {
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ReqErrorResult handleMethodNotAllowedException(HttpRequestMethodNotSupportedException ex) {
        return new ReqErrorResult(ex.getMessage());
    }

    @ExceptionHandler(InvalidParamException.class)
    public ReqErrorResult handleInvalidParamException(InvalidParamException ex) {
        return new ReqErrorResult(ex.getMessage());
    }

    @ExceptionHandler(AuthorizationException.class)
    public ReqErrorResult handleAuthorizationException(AuthorizationException ex) {
        return new ReqErrorResult(ex);
    }
}
