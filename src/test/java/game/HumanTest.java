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


}
