package game;

import java.util.*;

public class Session {

    public static void main(String[] args) {
        Menace m = new Menace();
        Human h = new Human();
        List<Integer> mlist = new ArrayList<>();
        List<Integer> hlist = new ArrayList<>();
        List<Integer> draw = new ArrayList<>();
        int mc = 0;
        int hc = 0;
        int dc = 0;
        int j;
        for (int i = 0; i<100000; i++) {
            Round r = new Round(m, h);
            j = r.start();
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
            m.updateMap(j);
        }
        System.out.println("M: "+mc+" H: "+hc+" D: "+dc);
//        System.out.println(mlist);
//        System.out.println(hlist);
//        System.out.println(draw);
    }

}


