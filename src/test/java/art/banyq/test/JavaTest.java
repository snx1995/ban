package art.banyq.test;

import java.lang.reflect.Array;

public class JavaTest {

    public static void main(String[] args) {
        String[] names = "test".split("\\.");
        for (String name : names) {
            System.out.println(name);
        }
    }

}