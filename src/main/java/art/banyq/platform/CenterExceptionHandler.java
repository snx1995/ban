package art.banyq.platform;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import art.banyq.common.ReqResult;
import art.banyq.common.exception.ReqHandleException;

@RestController
@ControllerAdvice
public class CenterExceptionHandler {
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public ReqErrorResult handleMethodNotAllowedException(HttpRequestMethodNotSupportedException ex) {
//        return new ReqErrorResult(ex.getMessage());
//    }

    @ExceptionHandler(Exception.class)
    public ReqResult handleException(Exception ex) {
        return ReqResult.error(ex.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ReqResult handleDuplicateKeyException(DuplicateKeyException ex) {
        return ReqResult.error(ex.getMessage());
    }

    @ExceptionHandler(ReqHandleException.class)
    public ReqResult handleReqHandleException(ReqHandleException ex) {
        return ReqResult.failed(ex.getData());
    }
}
