package art.banyq.common;

import art.banyq.common.exception.ReqHandleException;

public class ReqErrorResult extends ReqResult {
    public ReqErrorResult(String msg) {
        setCode(ResStatus.FAILED.getCode());
        setMsg(msg);
    }

    public ReqErrorResult(ReqHandleException ex) {
        setCode(ex.getResCode());
        setMsg(ex.getResMsg());
        setData(ex.getData());
    }
}
