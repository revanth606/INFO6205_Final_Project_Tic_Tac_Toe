package game;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenaceTest {

    @Test
    void testCreateKey() {
        List<Integer> t1 = Arrays.asList(0, 0, 0);
        List<Integer> t2 = Arrays.asList(-1, -1);
        List<Integer> t3 = Arrays.asList(0, 6, 0, 6, 0, 6);
        Menace m = new Menace(3);
        String s = "012212121";
        m.createKey(s);
        assertEquals(m.getBotBoards().get(s), t1);
        s = "212212121";
        m.createKey(s);
        assertEquals(m.getBotBoards().get(s), t2);
        s = "012122012";
        m.createKey(s);
        assertEquals(m.getBotBoards().get(s), t3);
    }

    @Test
    void testTurn() {
        List<Integer> t1 = Arrays.asList(0, 0);
        List<Integer> t2 = Arrays.asList(0);
        Menace m = new Menace(3);
        String s = "012212121";
        m.turn(s);
        assertEquals(m.getBotBoards().get(s), t1);
        m.turn(s);
        assertEquals(m.getBotBoards().get(s), t2);
        m.turn(s);
        assertEquals(m.getBotBoards().get(s), t2);
    }

}
