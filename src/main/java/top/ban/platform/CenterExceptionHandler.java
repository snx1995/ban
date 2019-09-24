package top.ban.platform;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import top.ban.common.ReqErrorResult;
import top.ban.common.exception.BaseException;

@RestController
@ControllerAdvice
public class CenterExceptionHandler {
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ReqErrorResult handleMethodNotAllowedException(HttpRequestMethodNotSupportedException ex) {
        return new ReqErrorResult(ex.getMessage());
    }

    @ExceptionHandler(BaseException.class)
    public ReqErrorResult handleAuthorizationException(BaseException ex) {
        return new ReqErrorResult(ex);
    }
}
