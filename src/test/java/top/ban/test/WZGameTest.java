package top.ban.test;

public class WZGameTest {
    private int[][] chessboard = {{2, 2, 2, 2, 2}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}};

    private void printChessboard() {
        for (int i = 0;i < 5;i ++) {
            for (int j = 0;j < 5;j ++) {
                System.out.printf("%d\t", chessboard[i][j]);
            }
            System.out.println('\n');
        }
    }

    public static void main(String[] args) {
        WZGameTest test = new WZGameTest();
        test.printChessboard();
    }
}