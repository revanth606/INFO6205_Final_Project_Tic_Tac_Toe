package game;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class SessionTest {

    @Test
    void testTrain() {
        Session s = new Session();
        Menace m = s.train(10, 4, 1, 2, 0.1, 100);
        assertTrue(m!=null);
    }

    @Test
    void testPlay() {
        Session s = new Session();
        Menace m = s.train(10, 4, 1, 2, 0.1, 100);
        assertTrue(m!=null);
        s.play(m, s.h,10, 4, 1, 2, 0.9, 100);
        assertTrue(m!=null);
    }
}
