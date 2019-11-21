package art.banyq.test;

public class CodeTest {
    public static void main(String[] args) {
        String filename = "a.sda.sd.as.da.txt";
        System.out.println(filename.replaceAll(".*(\\.\\w*)$", "banyq" + "$1"));
    }
}
