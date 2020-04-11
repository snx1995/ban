package art.banyq.common.entity.param.dao;

import art.banyq.common.entity.param.PageParam;

public class MsgDaoParam {
    private Integer start;
    private Integer size;

    public MsgDaoParam(PageParam pageParam) {
        this.start = (pageParam.getPage() - 1) * pageParam.getSize();
        this.size = pageParam.getSize();
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}