package art.banyq.test;

import java.io.File;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailatorTest {
    public static void main(String[] args) {
        try {
            for (int i = 0;i < 9;i ++) {
                Thumbnails.of(new File("C:\\Users\\Administrator\\Desktop\\imgs\\" + i + ".JPG"))
                    .scale(0.3)
                    .toFile(new File("C:\\Users\\Administrator\\Desktop\\imgs\\" + i + "_compressed.JPG"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}