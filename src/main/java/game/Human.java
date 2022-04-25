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
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '0') {
                return i;
            }
        }
        return -1;
    }

}
