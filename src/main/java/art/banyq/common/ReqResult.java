package art.banyq.common;

public class ReqResult {
    private Integer code;
    private String msg;
    private Object data;

    private ReqResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ReqResult(ResStatus status, Object data) {
        this.code = status.code;
        this.msg = status.msg;
        this.data = data;
    }

    public static ReqResult succeeded(Object data) {
        return new ReqResult(ResStatus.SUCCEEDED, data);
    }

    public static ReqResult failed(Object data) {
        return new ReqResult(ResStatus.FAILED, data);
    }

    public static ReqResult error(Object data) {
        return new ReqResult(ResStatus.ERROR, data);
    }

    /**
     * @return int return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return String return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return Object return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }
}
