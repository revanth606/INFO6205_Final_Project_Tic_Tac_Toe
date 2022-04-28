package game;

import java.util.*;

public class Human {

    int[][] board;

    public Human() {
        board = new int[3][3];
    }

    // takes in current state of the game as string and converts it to 2D array
    public int[][] convertStringtoBoard(String s) {
        int[][] b = new int[3][3];
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                b[i][j] = Character.getNumericValue(s.charAt(i*3+j));
            }
        }
        return b;
    }

    // takes the current game and return a integer value after checking the match win condition
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

    //  takes in current state of the game as string and return a integer based on the optimal human strategy
    public int turn(String s) {

        board = convertStringtoBoard(s);
        // Rule 1
        for(int i=0; i<9; i++){
            if (s.charAt(i)=='0') {
                board[i/3][i%3] = 2;
                if (checkwin(i, 2) == 2) {
                    return i;
                }
                board[i/3][i%3] = 0;
            }
        }

        // Rule 2
        for(int i=0; i<9; i++){
            if (s.charAt(i)=='0') {
                board[i/3][i%3] = 1;
                if (checkwin(i, 1) == 1) {
                    return i;
                }
                board[i/3][i%3] = 0;
            }
        }

        // Rule 3
        char[] c = s.toCharArray();
        for(int i=0; i<9; i++){
            if (c[i]=='0') {
                int count = 0;
                switch(i) {
                    case 0 :
                        if ((c[1] == '2' || c[2] == '2') && (c[1] == '0' || c[2] == '0')) {
                            count++;
                        }
                        if ((c[3] == '2' || c[6] == '2') && (c[3] == '0' || c[6] == '0')) {
                            count++;
                        }
                        if ((c[4] == '2' || c[8] == '2') && (c[4] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 0;
                        }
                        break;
                    case 1 :
                        if ((c[0] == '2' || c[2] == '2') && (c[0] == '0' || c[2] == '0')) {
                            count++;
                        }
                        if ((c[4] == '2' || c[7] == '2') && (c[4] == '0' || c[7] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 1;
                        }
                        break;
                    case 2 :
                        if ((c[1] == '2' || c[0] == '2') && (c[1] == '0' || c[0] == '0')) {
                            count++;
                        }
                        if ((c[5] == '2' || c[8] == '2') && (c[5] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if ((c[4] == '2' || c[6] == '2') && (c[4] == '0' || c[6] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 2;
                        }
                        break;
                    case 3 :
                        if ((c[4] == '2' || c[5] == '2') && (c[4] == '0' || c[5] == '0')) {
                            count++;
                        }
                        if ((c[0] == '2' || c[6] == '2') && (c[0] == '0' || c[6] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 3;
                        }
                        break;
                    case 4 :
                        if ((c[3] == '2' || c[5] == '2') && (c[3] == '0' || c[5] == '0')) {
                            count++;
                        }
                        if ((c[1] == '2' || c[7] == '2') && (c[1] == '0' || c[7] == '0')) {
                            count++;
                        }
                        if ((c[0] == '2' || c[8] == '2') && (c[0] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if ((c[2] == '2' || c[6] == '2') && (c[2] == '0' || c[6] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 4;
                        }
                        break;
                    case 5 :
                        if ((c[3] == '2' || c[4] == '2') && (c[3] == '0' || c[4] == '0')) {
                            count++;
                        }
                        if ((c[2] == '2' || c[8] == '2') && (c[2] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 5;
                        }
                        break;
                    case 6 :
                        if ((c[7] == '2' || c[8] == '2') && (c[7] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if ((c[0] == '2' || c[3] == '2') && (c[0] == '0' || c[3] == '0')) {
                            count++;
                        }
                        if ((c[4] == '2' || c[2] == '2') && (c[4] == '0' || c[2] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 6;
                        }
                        break;
                    case 7 :
                        if ((c[6] == '2' || c[8] == '2') && (c[6] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if ((c[1] == '2' || c[4] == '2') && (c[1] == '0' || c[4] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 7;
                        }
                        break;
                    case 8 :
                        if ((c[6] == '2' || c[7] == '2') && (c[6] == '0' || c[7] == '0')) {
                            count++;
                        }
                        if ((c[2] == '2' || c[5] == '2') && (c[2] == '0' || c[5] == '0')) {
                            count++;
                        }
                        if ((c[0] == '2' || c[4] == '2') && (c[0] == '0' || c[4] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 8;
                        }
                        break;
                }
            }
        }

        // Rule 4
        for(int i=0; i<9; i++){
            if (c[i]=='0') {
                int count = 0;
                switch(i) {
                    case 0 :
                        if ((c[1] == '1' || c[2] == '1') && (c[1] == '0' || c[2] == '0')) {
                            count++;
                        }
                        if ((c[3] == '1' || c[6] == '1') && (c[3] == '0' || c[6] == '0')) {
                            count++;
                        }
                        if ((c[4] == '1' || c[8] == '1') && (c[4] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 0;
                        }
                        break;
                    case 1 :
                        if ((c[0] == '1' || c[2] == '1') && (c[0] == '0' || c[2] == '0')) {
                            count++;
                        }
                        if ((c[4] == '1' || c[7] == '1') && (c[4] == '0' || c[7] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 1;
                        }
                        break;
                    case 2 :
                        if ((c[1] == '1' || c[0] == '1') && (c[1] == '0' || c[0] == '0')) {
                            count++;
                        }
                        if ((c[5] == '1' || c[8] == '1') && (c[5] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if ((c[4] == '1' || c[6] == '1') && (c[4] == '0' || c[6] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 2;
                        }
                        break;
                    case 3 :
                        if ((c[4] == '1' || c[5] == '1') && (c[4] == '0' || c[5] == '0')) {
                            count++;
                        }
                        if ((c[0] == '1' || c[6] == '1') && (c[0] == '0' || c[6] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 3;
                        }
                        break;
                    case 4 :
                        if ((c[3] == '1' || c[5] == '1') && (c[3] == '0' || c[5] == '0')) {
                            count++;
                        }
                        if ((c[1] == '1' || c[7] == '1') && (c[1] == '0' || c[7] == '0')) {
                            count++;
                        }
                        if ((c[0] == '1' || c[8] == '1') && (c[0] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if ((c[2] == '1' || c[6] == '1') && (c[2] == '0' || c[6] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 4;
                        }
                        break;
                    case 5 :
                        if ((c[3] == '1' || c[4] == '1') && (c[3] == '0' || c[4] == '0')) {
                            count++;
                        }
                        if ((c[2] == '1' || c[8] == '1') && (c[2] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 5;
                        }
                        break;
                    case 6 :
                        if ((c[7] == '1' || c[8] == '1') && (c[7] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if ((c[0] == '1' || c[3] == '1') && (c[0] == '0' || c[3] == '0')) {
                            count++;
                        }
                        if ((c[4] == '1' || c[2] == '1') && (c[4] == '0' || c[2] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 6;
                        }
                        break;
                    case 7 :
                        if ((c[6] == '1' || c[8] == '1') && (c[6] == '0' || c[8] == '0')) {
                            count++;
                        }
                        if ((c[1] == '1' || c[4] == '1') && (c[1] == '0' || c[4] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 7;
                        }
                        break;
                    case 8 :
                        if ((c[6] == '1' || c[7] == '1') && (c[6] == '0' || c[7] == '0')) {
                            count++;
                        }
                        if ((c[2] == '1' || c[5] == '1') && (c[2] == '0' || c[5] == '0')) {
                            count++;
                        }
                        if ((c[0] == '1' || c[4] == '1') && (c[0] == '0' || c[4] == '0')) {
                            count++;
                        }
                        if (count>=2) {
                            return 8;
                        }
                        break;
                }
            }
        }

        // Rule 5
        if (s.charAt(4) == '0') {
            return 4;
        }

        // Rule 6
        if (s.charAt(0) == '1' && s.charAt(8) == '0') {
            return 8;
        }
        if (s.charAt(2) == '1' && s.charAt(6) == '0') {
            return 6;
        }
        if (s.charAt(6) == '1' && s.charAt(2) == '0') {
            return 2;
        }
        if (s.charAt(8) == '1' && s.charAt(0) == '0') {
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