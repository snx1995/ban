package top.ban.common;

public class ReqResult {
    private int code;
    private String msg;
    private Object data;

    public ReqResult succeeded(Object data) {
        this.code = ResStatus.SUCCEEDED.getCode();
        this.msg = ResStatus.SUCCEEDED.getMsg();
        this.data = data;
        return this;
    }

    public ReqResult failed(Object data) {
        this.code = ResStatus.FAILED.getCode();
        this.msg = ResStatus.FAILED.getMsg();
        this.data = data;
        return this;
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
