package game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoundTest {

    @Test
    void testConvertBoardtoString() {
        Human h = new Human();
        Menace m = new Menace(3);
        Round r = new Round(m, h);
        int[][] b = {{0, 1, 1}, {2, 1, 0}, {2, 2, 0}};
        String s = "011210220";
        assertEquals(s, r.convertBoardtoString(b));
    }

    @Test
    void testCheckwin() {
        Human h = new Human();
        Menace m = new Menace(3);
        Round r = new Round(m, h);
        assertEquals(r.checkwin(-1, 2), 0);
        r.board[0][0] = 2;
        r.board[0][1] = 1;
        r.board[0][2] = 0;
        r.board[1][0] = 1;
        r.board[1][1] = 2;
        r.board[1][2] = 0;
        r.board[2][0] = 0;
        r.board[2][1] = 0;
        r.board[2][2] = 2;
        assertEquals(2, r.checkwin(8, 2));
        r.board[1][0] = 2;
        r.board[1][1] = 1;
        r.board[2][0] = 2;
        r.board[2][2] = 0;
        assertEquals(2, r.checkwin(6, 2));
        r.board[0][1] = 2;
        r.board[0][2] = 2;
        r.board[1][0] = 1;
        r.board[2][0] = 0;
        assertEquals(2, r.checkwin(2, 2));
        r.board[0][1] = 1;
        r.board[1][1] = 2;
        r.board[2][0] = 2;
        r.board[0][0] = 1;
        assertEquals(2, r.checkwin(2, 2));
        r.board[1][0] = 2;
        r.board[2][0] = 1;
        assertEquals(0, r.checkwin(6, 1));
    }
}
