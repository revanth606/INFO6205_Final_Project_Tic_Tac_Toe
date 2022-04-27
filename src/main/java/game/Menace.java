package game;

import java.util.*;

public class Menace {

    private Map<String, List<Integer>> botBoards = new HashMap<>();
    private List<String> curStrings = new ArrayList<>();
    private List<Integer> curPlaces = new ArrayList<>();
    private int a;

    public Menace(int alpha) {
        a = alpha;
    }

    public Map<String, List<Integer>> getBotBoards() {
        return botBoards;
    }

    public void setBotBoards(Map<String, List<Integer>> botBoards) {
        this.botBoards = botBoards;
    }

    public List<String> getCurStrings() {
        return curStrings;
    }

    public void setCurStrings(List<String> curStrings) {
        this.curStrings = curStrings;
    }

    public List<Integer> getCurPlaces() {
        return curPlaces;
    }

    public void setCurPlaces(List<Integer> curPlaces) {
        this.curPlaces = curPlaces;
    }

    public void outputs() {
        System.out.println(botBoards.size());
//        Set keys = botBoards.keySet();
//        Iterator i = keys.iterator();
//        while(i.hasNext()) {
//            System.out.println(botBoards.get(i.next()).size());
//        }
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
            places.add(-1);
            places.add(-1);
            botBoards.put(s, places);
            return;
        }
        for (int i=0; i<a; i++) {
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

    public void updateMap(int res, int b, int g, int d) {
        if (res == 0) {
            int l = curPlaces.size();
            for (int i=0; i<l; i++) {
                int j = 0;
                while (j<d) {
                    botBoards.get(curStrings.get(0)).remove(curPlaces.get(0));
                    j++;
                }
                curPlaces.remove(0);
                curStrings.remove(0);
            }
        } else if (res == 1) {
            int l = curPlaces.size();
            for (int i=0; i<l; i++) {
                int j = 0;
                while (j<d) {
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
                while (j<g) {
                    botBoards.get(curStrings.get(0)).add(curPlaces.get(0));
                    j++;
                }
                curPlaces.remove(0);
                curStrings.remove(0);
            }
        }
    }
}
