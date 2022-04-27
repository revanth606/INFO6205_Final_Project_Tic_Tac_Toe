package game;

import java.util.ArrayList;
import java.util.*;

public class Round {

    public int[][] board;
    public Menace m;
    public Human h;

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
            System.out.println(board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
            System.out.println("-----------");
        }
        System.out.println("+++++++++++++++");
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

    public int start(int prob) {
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
                    return 0;
                }
                board[c / 3][c % 3] = 1;
                s = convertBoardtoString(board);
                if(checkwin(c, p)!=0) {
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
                    return 0;
                }
                board[c / 3][c % 3] = 2;
                s = convertBoardtoString(board);
                if(checkwin(c, p)!=0) {
                    return checkwin(c, p);
                }
                p = 1;
            }
        }
    }

}
