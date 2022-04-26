package game;

import java.util.*;

public class Menace {

    private Map<String, List<Integer>> botBoards = new HashMap<>();
    private List<String> curStrings = new ArrayList<>();
    private List<Integer> curPlaces = new ArrayList<>();

    public void outputs() {
        System.out.println(botBoards.size());
    }

    public void createKey (String s) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> places = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='0') {
                pos.add(i);
            }
        }
        int l = pos.size();
        if (l==0) {
            for (int i=0; i<2520; i++) {
                places.add(-1);
            }
            botBoards.put(s, places);
            return;
        }
        for (int i=0; i<(2520/l); i++) {
            int j=0;
            while (j<l) {
                places.add(pos.get(j));
                j++;
            }
        }
        botBoards.put(s, places);
    }

    public int turn(String s) {
        Random rand = new Random();
        if (botBoards.containsKey(s)) {
            if (botBoards.get(s).size()<=1) {
                return botBoards.get(s).get(0);
            }
            int pos = botBoards.get(s).remove(rand.nextInt(botBoards.get(s).size()));
            curStrings.add(s);
            curPlaces.add(pos);
            return pos;
        }
        else {
            createKey(s);
            int pos = botBoards.get(s).remove(rand.nextInt(botBoards.get(s).size()));
            curStrings.add(s);
            curPlaces.add(pos);
            return pos;
        }
    }

    public void updateMap(int res, int a, int b, int d) {
        if (res == 0) {int l = curPlaces.size();
            for (int i=0; i<l; i++) {
                int j = 0;
                while (j<d) {
                    botBoards.get(curStrings.get(0)).add(curPlaces.get(0));
                    j++;
                }
                curPlaces.remove(0);
                curStrings.remove(0);
            }
        } else if (res == 1) {
            int l = curPlaces.size();
            for (int i=0; i<l; i++) {
                int j = 0;
                while (j<b) {
                    botBoards.get(curStrings.get(0)).add(curPlaces.get(0));
                    j++;
                }
                curPlaces.remove(0);
                curStrings.remove(0);
            }
        } else {
            int l = curPlaces.size();
            for (int i=0; i<l; i++) {
                int j = 0;
                while (j<a) {
                    botBoards.get(curStrings.get(0)).add(curPlaces.get(0));
                    j++;
                }
                curPlaces.remove(0);
                curStrings.remove(0);
            }
        }
    }
}
