package art.banyq.common.util;

import java.util.UUID;

public final class FileUtil {

    public static String getFileSuffix(String filename) {
        if (filename == null) return "";
        else {
            String[] fileparts = filename.split("\\.");
            if (fileparts.length <= 1) return "";
            String suffix = fileparts[fileparts.length - 1];
            return suffix;
        }
    }

    public static String getUniqueFilename() {
        UUID id = UUID.randomUUID();
        return id.toString();
    }

    public static String toUniqueFilename(String filename) {
        return getUniqueFilename() + "." + getFileSuffix(filename);
    }
}