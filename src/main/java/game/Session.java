package game;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Session {

    public Menace m;
    public Human h;

    private static final Logger logger = LogManager.getLogger(Session.class);

    public Session() {
        h = new Human();
    }

    public Menace train(int alpha, int beta, int gamma, int delta, double p, int matches) {
        m = new Menace(alpha);
        int res;
        int mc = 0; // Count of mathces won by Menace
        int hc = 0; // Count of mathces won by Human
        int dc = 0; // Count of mathces that are draw
        for (int i = 0; i<matches; i++) {
            Round r = new Round(m, h);
            res = r.start((int) p*100, false);
            if (res==0) {
                dc++;
            } else if (res==1) {
                mc++;
            } else  {
                hc++;
            }
            m.updateMap(res, beta, gamma, delta);
                logger.info("Win: "+mc+" Loss: "+hc+" Draw: "+dc+" Alpha: "+alpha+" Beta: "+beta+" Gamma: "+gamma+" Delta: "+delta+" p*: "+p);
        }
        return m;
    }

    public void play(Menace m, Human h, int alpha, int beta, int gamma, int delta, double p, int matches) {
        int res;
        int mc = 0; // Count of mathces won by Menace
        int hc = 0; // Count of mathces won by Human
        int dc = 0; // Count of mathces that are draw
        for (int i = 0; i<matches; i++) {
            Round r = new Round(m, h);
            res = r.start((int) p * 100, true);
            if (res == 0) {
                dc++;
            } else if (res == 1) {
                mc++;
            } else {
                hc++;
            }
            logger.info("Win: " + mc + " Loss: " + hc + " Draw: " + dc + " Alpha: " + alpha + " Beta: " + beta + " Gamma: " + gamma + " Delta: " + delta + " p*: " + p);
        }
    }

    public static void main(String[] args) {
        int alpha = 10;
        int beta = 16;
        int gamma = 1;
        int delta = 16;
        double p = 0.1;
        int matches = 10000;
        Session s = new Session();
        s.m = s.train(alpha, beta, gamma, delta, p, matches);
        matches = 1000;
        p = 0.9;
        s.play(s.m, s.h, alpha, beta, gamma, delta, p, matches);
    }

}


