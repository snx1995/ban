package top.ban.test;

import org.junit.Test;
import top.ban.common.util.JSON;

public class JSONTest {

    @Test
    public void testParse() {
        try {
            String str = JSON.stringify("banyq");
            String array = JSON.stringify(new int[]{1, 2, 3});
            String num = JSON.stringify(1);
            String bool = JSON.stringify(false);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
