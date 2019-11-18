package top.ban.business.game.wz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class WZGame {
    private Player p1;
    private Player p2;

    private Map<Integer, ChessPieceIds> pc;
    private List<ChessPiece> cp;

    private GameState state = GameState.WAIT_P1_JOIN;

    public static void main(String[] args) {

    }

    public WZGame(Player player) {
        init();
        p1 = player;
        state = state.nextState();
        syncGameState();
    }

    private void init() {
        this.pc = new HashMap<>();
        this.cp = new ArrayList<>(10);
        ChessPieceIds[] ids = ChessPieceIds.values();
        // for (int i = 0;i < 10;i ++) {
        //     this.pc.put(, ids[i]);
        // }
    }

    public void syncGameState() {
        
    }

    public static enum GameState {
        WAIT_P1_JOIN, WAIT_P2_JOIN, WAIT_P1_MOVE, WAIT_P2_MOVE, END;

        GameState nextState() {
            switch (this) {
                case WAIT_P1_JOIN:
                    return WAIT_P2_JOIN;
                case WAIT_P2_JOIN:
                    return WAIT_P1_MOVE;
                case WAIT_P1_MOVE:
                    return WAIT_P2_MOVE;
                case WAIT_P2_MOVE:
                    return WAIT_P1_MOVE;
                default:
                    return END;
            }
        }
    }

    public static class Player {

    }

    static enum ChessPieceIds {
        P1_0, P1_1, P1_2, P1_3, P1_4,
        P2_0, P2_1, P2_2, P2_3, P2_4;
    }

    public static class ChessPiece {
        private ChessPieceIds id;
        private int x;
        private int y;
        private boolean dead = false;

        ChessPiece(ChessPieceIds id, int x, int y) {
            this.id = id;
            if (x >=0 && x <= 4) this.x = x;
            else throw new RuntimeErrorException(new Error("Chess pos x must be between 0 and 4"));
            if (y >= 0 && y <= 4) this.y = y;
            else throw new RuntimeErrorException(new Error("Chess pos y must be between 0 and 4"));
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }

        boolean isDead() {
            return this.dead;
        }

        ChessPieceIds getId() {
            return this.id;
        }

        boolean stepTop() {
            if (this.y < 4) {
                this.y ++;
                return true;
            }
            return false;
        }

        boolean stepDown() {
            if (this.y > 0) {
                this.y --;
                return true;
            }
            return false;
        }

        boolean stepLeft() {
            if (this.x > 0) {
                this.x --;
                return true;
            }
            return false;
        }

        boolean stepRight() {
            if (this.x < 4) {
                this.x ++;
                return true;
            }
            return false;
        }
    }
}