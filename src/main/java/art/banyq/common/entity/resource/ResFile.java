package art.banyq.common.entity.resource;

import art.banyq.common.entity.message.file.MsgFileType;

public class ResFile {
    private Integer id;
    private String original;
    private String compressed;
    private String filename;
    private MsgFileType type;
    private Integer linkId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getCompressed() {
        return compressed;
    }

    public void setCompressed(String compressed) {
        this.compressed = compressed;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public MsgFileType getType() {
        return type;
    }

    public void setType(MsgFileType type) {
        this.type = type;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }
    
}