package game;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Session {

    private Menace m;
    private Human h;

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
            res = r.start((int) p*100);
            if (res==0) {
                dc++;
//                draw.add(i);
            } else if (res==1) {
                mc++;
//                mlist.add(i);
            } else  {
                hc++;
//                hlist.add(i);
            }
            m.updateMap(res, beta, gamma, delta);
//            if (i%10000==0) {
                logger.info("M: "+mc+" H: "+hc+" D: "+dc);
//            }
        }
        return m;
    }

    public void run(Menace m, Human h, int alpha, int beta, int gamma, int delta, double p) {

    }

    public static void main(String[] args) {
        int alpha = 10;
        int beta = 4;
        int gamma = 1;
        int delta = 0;
        double p = 0.1;
        int matches = 10000;
        Session s = new Session();
        s.m = s.train(alpha, beta, gamma, delta, p, matches);
//        m.outputs();
//        for (int i = 0; i<300000; i++) {
//            Round r = new Round(s.m, h);
//            j = r.start((int) p*100);
//            if (j==0) {
//                dc++;
//                draw.add(i);
//            } else if (j==1) {
//                mc++;
//                mlist.add(i);
//            } else  {
//                hc++;
//                hlist.add(i);
//            }
//            m.updateMap(j, beta, gamma, delta);
//            if (i%10000==0) {
//                logger.info("M: "+mc+" H: "+hc+" D: "+dc);
//            }
//        }
//        System.out.println("M: "+mc+" H: "+hc+" D: "+dc);
//        m.outputs();

    }

}


