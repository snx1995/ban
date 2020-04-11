package art.banyq.common.entity.message;

import java.util.Date;

import art.banyq.common.entity.message.file.MsgFiles;

public class Msg {
    private Integer id;
    private String content;
    private Integer userId;
    private MsgFiles files;
    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public MsgFiles getFiles() {
        return files;
    }

    public void setFiles(MsgFiles files) {
        this.files = files;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}