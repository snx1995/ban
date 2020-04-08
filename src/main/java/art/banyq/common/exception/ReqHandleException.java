package art.banyq.common.exception;

import art.banyq.common.ResStatus;

public class ReqHandleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Object data;

    public ReqHandleException(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}