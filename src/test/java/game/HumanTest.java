package game;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    @Test
    void testConvertStringtoBoard() {
        int[][] b = {
                {1, 2, 0},
                {2, 1, 0},
                {0, 0, 0}
        };
        Human h = new Human();
        String s = "120210000";
        int[][] a = h.convertStringtoBoard(s);
        assertTrue(Arrays.deepEquals(b, a));
    }

    @Test
    void testCheckwin() {
        Human h = new Human();
        assertEquals(h.checkwin(-1, 2), 0);
        h.board[0][0] = 2;
        h.board[0][1] = 1;
        h.board[0][2] = 0;
        h.board[1][0] = 1;
        h.board[1][1] = 2;
        h.board[1][2] = 0;
        h.board[2][0] = 0;
        h.board[2][1] = 0;
        h.board[2][2] = 2;
        assertEquals(2, h.checkwin(8, 2));
        h.board[1][0] = 2;
        h.board[1][1] = 1;
        h.board[2][0] = 2;
        h.board[2][2] = 0;
        assertEquals(2, h.checkwin(6, 2));
        h.board[0][1] = 2;
        h.board[0][2] = 2;
        h.board[1][0] = 1;
        h.board[2][0] = 0;
        assertEquals(2, h.checkwin(2, 2));
        h.board[0][1] = 1;
        h.board[1][1] = 2;
        h.board[2][0] = 2;
        h.board[0][0] = 1;
        assertEquals(2, h.checkwin(2, 2));
        h.board[1][0] = 2;
        h.board[2][0] = 1;
        assertEquals(0, h.checkwin(6, 2));
    }
}
