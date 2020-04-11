package art.banyq.common.entity.message.file;

import java.util.List;

public class MsgFiles {
    private List<MsgFile> file;
    private List<MsgFile> image;
    private List<MsgFile> video;

    public List<MsgFile> getFile() {
        return file;
    }

    public void setFile(List<MsgFile> file) {
        this.file = file;
    }

    public List<MsgFile> getImage() {
        return image;
    }

    public void setImage(List<MsgFile> image) {
        this.image = image;
    }

    public List<MsgFile> getVideo() {
        return video;
    }

    public void setVideo(List<MsgFile> video) {
        this.video = video;
    }

    
}