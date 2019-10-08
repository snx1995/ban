package top.ban.common;

import top.ban.common.exception.BaseException;

public class ReqErrorResult extends ReqResult {
    public ReqErrorResult(String msg) {
        setCode(ResStatus.FAILED.getCode());
        setMsg(ResStatus.FAILED.getMsg());
        setData(msg);
    }

    public ReqErrorResult(BaseException ex) {
        setCode(ResStatus.FAILED.getCode());
        setMsg(ResStatus.FAILED.getMsg());
        setData(ex.getData());
    }
}
