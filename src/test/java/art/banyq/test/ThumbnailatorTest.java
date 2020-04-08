package art.banyq.test;

import java.io.File;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailatorTest {
    public static void main(String[] args) {
        try {
            Thumbnails.of(new File("C:\\Users\\Administrator\\Desktop\\imgs\\0.JPG"))
            .scale(0.3)
            .toFile(new File("C:\\Users\\Administrator\\Desktop\\imgs\\0_compressed.JPG"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}