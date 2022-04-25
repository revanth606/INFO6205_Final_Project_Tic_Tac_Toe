package game;

public class Round {

    private int[][] board;
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

    public void curboard() {
        for (int i=0; i<3; i++) {
            System.out.println(board[i][0]+" | "+board[i][1]+" | "+board[i][2]);
            System.out.println("-----------");
        }
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

    public int start() {
        curboard();
        int p = 1;
        int c = -1;
        String s = convertBoardtoString(board);
        while (checkwin(c, p)==0) {
            if (p == 1) {
                c = m.turn(s);
                if (c==-1) {
                    return 0;
                }
                board[c / 3][c % 3] = 1;
                p = 2;
                s = convertBoardtoString(board);
            } else {
                c = h.turn(s);
                if (c==-1) {
                    return 0;
                }
                board[c / 3][c % 3] = 2;
                p = 1;
                s = convertBoardtoString(board);
            }
            curboard();
        }
        return checkwin(c, p);
    }

}
