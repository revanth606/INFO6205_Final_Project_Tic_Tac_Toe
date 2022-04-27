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
    @Test
    void testTurn() {
        Human h = new Human();
        String s = "112220100";
        assertEquals(5, h.turn(s));
        s = "112210200";
        assertEquals(7, h.turn(s));
        s = "020211000";
        assertEquals(0, h.turn(s));
        s = "020021010";
        assertEquals(0, h.turn(s));
        s = "200120001";
        assertEquals(1, h.turn(s));
        s = "020112000";
        assertEquals(2, h.turn(s));
        s = "010122000";
        assertEquals(2, h.turn(s));
        s = "210020001";
        assertEquals(3, h.turn(s));
        s = "212100000";
        assertEquals(4, h.turn(s));
        s = "121200000";
        assertEquals(4, h.turn(s));
        s = "012020100";
        assertEquals(5, h.turn(s));
        s = "010210020";
        assertEquals(6, h.turn(s));
        s = "010021020";
        assertEquals(6, h.turn(s));
        s = "001120200";
        assertEquals(7, h.turn(s));
        s = "000112020";
        assertEquals(8, h.turn(s));
        s = "201100200";
        assertEquals(8, h.turn(s));
        s = "010020120";
        assertEquals(0, h.turn(s));
        s = "010000221";
        assertEquals(0, h.turn(s));
        s = "100210002";
        assertEquals(1, h.turn(s));
        s = "010020021";
        assertEquals(2, h.turn(s));
        s = "100201102";
        assertEquals(2, h.turn(s));
        s = "120010002";
        assertEquals(3, h.turn(s));
        s = "210100000";
        assertEquals(4, h.turn(s));
        s = "121000000";
        assertEquals(4, h.turn(s));
        s = "021010200";
        assertEquals(5, h.turn(s));
        s = "000120010";
        assertEquals(6, h.turn(s));
        s = "021000010";
        assertEquals(6, h.turn(s));
        s = "002210100";
        assertEquals(7, h.turn(s));
        s = "000021010";
        assertEquals(8, h.turn(s));
        s = "120200010";
        assertEquals(8, h.turn(s));
        s = "000000000";
        assertEquals(4, h.turn(s));
        s = "100020000";
        assertEquals(8, h.turn(s));
        s = "001020000";
        assertEquals(6, h.turn(s));
        s = "000020100";
        assertEquals(2, h.turn(s));
        s = "000020001";
        assertEquals(0, h.turn(s));
        s = "000010000";
        assertEquals(0, h.turn(s));
        s = "121120212";
        assertEquals(5, h.turn(s));
        s = "121121212";
        assertEquals(-1, h.turn(s));
    }
}
