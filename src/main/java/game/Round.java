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

    public int checkwin() {
        return 0;
    }

    public void start() {
        curboard();
        int i = 0;
        int c;
        String s = convertBoardtoString(board);
        while (checkwin()==0) {
            if (i == 0) {
                c = m.turn(s);
                if (c==-1) {
                    break;
                }
                board[c / 3][c % 3] = 1;
                i = 1;
                s = convertBoardtoString(board);
            } else {
                c = h.turn(s);
                if (c==-1) {
                    break;
                }
                board[c / 3][c % 3] = 2;
                i = 0;
                s = convertBoardtoString(board);
            }
            curboard();
        }
    }

}
