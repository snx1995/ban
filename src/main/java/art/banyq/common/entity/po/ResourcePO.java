package art.banyq.common.entity.po;

import java.util.Date;

public class ResourcePO {
    private Integer id;
    private String name;
    private String path;
    private Integer upload_user;
    private Date upload_date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getUpload_user() {
        return upload_user;
    }

    public void setUpload_user(Integer upload_user) {
        this.upload_user = upload_user;
    }

    public Date getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(Date upload_date) {
        this.upload_date = upload_date;
    }
}
