package game;

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

    public int turn(String s) {
        if (s.charAt(4) == '0') {
            return 4;
        }
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
        for (int i=0; i<9; i+=2) {
            if (s.charAt(i)=='0') {
                return i;
            }
        }
        for (int i=1; i<9; i+=2) {
            if (s.charAt(i)=='0') {
                return i;
            }
        }
        return -1;
    }

}