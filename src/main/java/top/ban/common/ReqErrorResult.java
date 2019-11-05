package top.ban.common;

import top.ban.common.exception.BaseException;

public class ReqErrorResult extends ReqResult {
    public ReqErrorResult(String msg) {
        setCode(ResStatus.FAILED.getCode());
        setMsg(msg);
    }

    public ReqErrorResult(BaseException ex) {
        setCode(ResStatus.FAILED.getCode());
        setMsg(ex.getMessage());
        setData(ex.getData());
    }
}
