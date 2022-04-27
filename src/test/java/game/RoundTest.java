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
}
