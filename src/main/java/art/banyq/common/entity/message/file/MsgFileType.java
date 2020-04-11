package art.banyq.common.entity.message.file;

public enum MsgFileType {
    FILE(0), PHOTO(1), VIDEO(2), AUDIO(3);

    private Integer type;

    public Integer getType() {
        return this.type;
    }

    private MsgFileType(Integer type) {
        this.type = type;
    }

    public static MsgFileType toFileType(Integer type) {
        switch (type) {
            case 0:
                return FILE;
            case 1:
                return PHOTO;
            case 2:
                return VIDEO;
            case 3:
                return AUDIO;
            default:
                return null;
        }
    }
}