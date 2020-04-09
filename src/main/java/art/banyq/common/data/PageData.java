package art.banyq.common.data;

public class PageData {
    private Integer total;
    private Integer page;
    private Integer size;
    private Object data;

    public PageData(Integer total, Integer page, Integer size, Object data) {
        this.total = total;
        this.page = page;
        this.size = size;
        this.data = data;
    }


    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return this.page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return this.size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}