package game;

import java.util.ArrayList;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Round {

    public int[][] board;
    public Menace m;
    public Human h;

    private static final Logger logger = LogManager.getLogger(Session.class);

    public Round(Menace m, Human h) {
        board = new int[3][3];
        this.m = m;
        this.h = h;
    }


    public String convertBoardtoString(int[][] board) {
        String state = "";
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                state += Integer.toString(board[i][j]);
            }
        }
        return state;
    }

    public int chooseRandom(String s) {
        Random r = new Random();
        List<Integer> l = new ArrayList<>();
        for (int i=0; i<9; i++) {
            if (s.charAt(i)=='0') {
                l.add(i);
            }
        }
        if (l.size()==0) {
            return -1;
        }
        return l.get(r.nextInt(l.size()));
    }

    public void curboard() {
        for (int i=0; i<3; i++) {
            logger.info(board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
            if (i<2) {
                logger.info("-----------");
            }
        }
        logger.info("++++++++++++++++++");
    }

    public int checkwin(int pos, int player) {
        if (pos == -1) {
            return 0;
        }
        int i = pos/3;
        int j = pos%3;
        if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
            return player;
        }
        if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
            return player;
        }
        if (Math.abs(i-j)==2 || i==j) {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1]==player) {
                return player;
            }
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1]==player) {
                return player;
            }
        }
        return 0;
    }

    public int start(int prob, boolean bool) {
        Random r = new Random();
        int t = 100;
        int rand;
        int a = r.nextInt(100);
        int b = r.nextInt(100);
        int p;
        if (a>b) {
            p = 1;
        } else {
            p = 2;
        }
        int c = -1;
        String s = convertBoardtoString(board);
        while (true) {
            if (p == 1) {
                c = m.turn(s);
                if (c==-1) {
                    curboard();
                    return 0;
                }
                board[c / 3][c % 3] = 1;
                s = convertBoardtoString(board);
                if(checkwin(c, p)!=0) {
                    curboard();
                    return checkwin(c, p);
                }
                p = 2;
            } else {
                rand = r.nextInt(100);
                if (rand<100*prob) {
                    c = h.turn(s);
                } else {
                    c = chooseRandom(s);
                }
                if (c==-1) {
                    curboard();
                    return 0;
                }
                board[c / 3][c % 3] = 2;
                s = convertBoardtoString(board);
                if(checkwin(c, p)!=0) {
                    curboard();
                    return checkwin(c, p);
                }
                p = 1;
            }
            if (bool) {
                curboard();
            }
        }
    }

}
