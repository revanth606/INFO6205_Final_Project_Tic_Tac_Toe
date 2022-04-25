package game;

import java.util.*;

public class Human {

    int[][] board;

    public int[][] convertStringtoBoard(String s) {
        int[][] b = new int[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                b[i][j] = Character.getNumericValue(s.charAt(i*3+j));
            }
        }
        return b;
    }

    public int checkwin(int pos, int player) {
        if (pos == -1) {
            return 0;
        }
        int i = pos/3;
        int j = pos%3;
        for (int k=0; k<3; k++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return player;
            }
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return player;
            }
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

    public int turn(String s) {

        board = convertStringtoBoard(s);
        // Rule 1
        for(int i=0; i<9; i++){
            if (s.charAt(i)=='0') {
                board[i/3][i%3] = 2;
                if (checkwin(i, 2) == 2) {
                    board[i/3][i%3] = 0;
                    return i;
                }
            }
        }

        // Rule 2
        for(int i=0; i<9; i++){
            if (s.charAt(i)=='0') {
                board[i/3][i%3] = 1;
                if (checkwin(i, 1) == 1) {
                    return i;
                }
            }
        }

        // Rule 5
        if (s.charAt(4) == '0') {
            return 4;
        }

        // Rule 6
        if (s.charAt(0) == '2' && s.charAt(8) == '0') {
            return 8;
        }
        if (s.charAt(2) == '2' && s.charAt(6) == '0') {
            return 6;
        }
        if (s.charAt(6) == '2' && s.charAt(2) == '0') {
            return 2;
        }
        if (s.charAt(8) == '2' && s.charAt(0) == '0') {
            return 0;
        }

        // Rule 7
        for (int i=0; i<9; i+=2) {
            if (s.charAt(i)=='0') {
                return i;
            }
        }

        // Rule 8
        for (int i=1; i<9; i+=2) {
            if (s.charAt(i)=='0') {
                return i;
            }
        }
        return -1;
    }

}