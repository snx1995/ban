package top.ban.common;

public class ReqErrorResult extends ReqResult {
    public ReqErrorResult(String msg) {
        setCode(ResStatus.FAILED.getCode());
        setMsg(ResStatus.FAILED.getMsg());
        setData(msg);
    }
}
