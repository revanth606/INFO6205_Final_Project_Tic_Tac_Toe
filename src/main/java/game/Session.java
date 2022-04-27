package game;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Session {

    private Menace m;
    private Human h;

    private static final Logger logger = LogManager.getLogger(Session.class);

    public void train(Menace m, Human h) {

    }

    public static void main(String[] args) {
        int alpha = 10;
        int beta = 4;
        int gamma = 1;
        int delta = 0;
        double p = 0.1;
        Menace m = new Menace(alpha);
        Human h = new Human();
        List<Integer> mlist = new ArrayList<>();
        List<Integer> hlist = new ArrayList<>();
        List<Integer> draw = new ArrayList<>();
        int mc = 0;
        int hc = 0;
        int dc = 0;
        int j;
        m.outputs();
        for (int i = 0; i<300000; i++) {
            Round r = new Round(m, h);
            j = r.start((int) p*100);
            if (j==0) {
                dc++;
                draw.add(i);
            } else if (j==1) {
                mc++;
                mlist.add(i);
            } else  {
                hc++;
                hlist.add(i);
            }
            m.updateMap(j, beta, gamma, delta);
            if (i%10000==0) {
                logger.info("M: "+mc+" H: "+hc+" D: "+dc);
            }
        }
        System.out.println("M: "+mc+" H: "+hc+" D: "+dc);
        m.outputs();
    }

}


