package art.banyq.platform;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import art.banyq.common.ReqErrorResult;
import art.banyq.common.exception.ReqHandleException;

@RestController
@ControllerAdvice
public class CenterExceptionHandler {
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ReqErrorResult handleMethodNotAllowedException(HttpRequestMethodNotSupportedException ex) {
//        return new ReqErrorResult(ex.getMessage());
//    }

    @ExceptionHandler(Exception.class)
    public ReqErrorResult handleException(Exception ex) {
        return new ReqErrorResult(ex.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ReqErrorResult handleDuplicateKeyException(DuplicateKeyException ex) {
        return new ReqErrorResult("sd");
    }

    @ExceptionHandler(ReqHandleException.class)
    public ReqErrorResult handleAuthorizationException(ReqHandleException ex) {
        return new ReqErrorResult(ex);
    }
}
