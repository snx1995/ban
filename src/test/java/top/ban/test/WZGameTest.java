package top.ban.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class WZGameTest {
    private int[][] chessboard = {{2, 2, 2, 2, 2}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}};
    private GameState state = GameState.WAIT_P1_MOVE;
    private int[] cpp = {0, 10, 20, 30, 40, 4, 14, 24, 34, 44};
    private Map<Integer, Integer> pcm = new HashMap<>();

    private void printChessboard() {
        System.out.println("\t0\t1\t2\t3\t4");
        System.out.println("\t#\t#\t#\t#\t#\n");
        for (int i = 0;i < 5;i ++) {
            System.out.printf("%d#\t", i);
            for (int j = 0;j < 5;j ++) {
                System.out.printf("%d\t", chessboard[i][j]);
            }
            System.out.println('\n');
        }
    }

    void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cmd;
        while (true) {
            printChessboard();
            try {
                switch (state) {
                case WAIT_P1_MOVE:
                    System.out.print("p1: ");
                    cmd = reader.readLine();
                    handleCmd(cmd, 1);
                    break;
                case WAIT_P2_MOVE:
                    System.out.println("p2: ");
                    cmd = reader.readLine();
                    handleCmd(cmd, 2);
                    break;
                default:
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void handleCmd(String cmd, int player) {
        String[] axis = cmd.split(" ");
        int from = Integer.valueOf(axis[0]);
        int to = Integer.valueOf(axis[1]);
        System.out.printf("p%d move from %d, to %d\n", player, from, to);
        int x1 = from / 10;
        int y1 = from % 10;
        int x2 = to / 10;
        int y2 = to % 10;
        if (!validPos(x1) || !validPos(x2) || !validPos(y1) || !validPos(y2)) {
            System.out.println("invalid position");
            return;
        }
        if ((x1 == x2 && Math.abs(y1 - y2) == 1) || (y1 == y2 && Math.abs(x1 - x2) == 1)) {
            if (chessboard[x1][y1] == player) {
                if (chessboard[x2][y2] == 0) {
                    chessboard[x1][y1] = 0;
                    chessboard[x2][y2] = player;
                    state = state.nextState();
                } else System.out.println("invalid move position");
            } else System.out.printf("There is no p%d's chess at %d\n", player, from);
        } else {
            System.out.println("invalid move position");
        }
    }

    boolean validPos(int x) {
        return x >=0 && x <=4;
    }

    void calcMoveResult(int x, int y) {

    }

    public static void main(String[] args) {
        WZGameTest test = new WZGameTest();
        test.start();
    }

    static enum GameState {
        WAIT_P1_MOVE, WAIT_P2_MOVE, END;

        GameState nextState() {
            switch (this) {
                case WAIT_P1_MOVE:
                    return WAIT_P2_MOVE;
                case WAIT_P2_MOVE:
                    return WAIT_P1_MOVE;
                default:
                    return END;
            }
        }
    }
}