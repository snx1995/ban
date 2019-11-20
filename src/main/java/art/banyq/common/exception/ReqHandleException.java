package art.banyq.common.exception;

import art.banyq.common.ResStatus;

public class ReqHandleException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private ResStatus status;
    private Object data;

    public ReqHandleException(ResStatus status, Object data) {
        super(status.getMsg());
        this.data = data;
        this.status = status;
    }

    public ReqHandleException(ResStatus status) {
        super(status.getMsg());
        this.data = null;
        this.status = status;
    }

    public ReqHandleException(String msg) {
        super(msg);
    }

    public Object getData() {
        return data;
    }

    public ResStatus getStatus() {
        return status;
    }

    public int getResCode() {
        return status.getCode();
    }

    public String getResMsg() {
        return status.getMsg();
    }
}