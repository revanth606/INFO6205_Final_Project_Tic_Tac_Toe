package game;

import java.util.*;

public class Menace {

    private Map<String, List<Integer>> botBoards = new HashMap<>();
    private List<String> curStrings = new ArrayList<>();
    private List<Integer> curPlaces = new ArrayList<>();

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
            for (int i=0; i<50; i++) {
                places.add(-1);
            }
            botBoards.put(s, places);
            return;
        }
        for (int i=0; i<50; i++) {
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
            int pos = rand.nextInt(botBoards.get(s).size());
            return botBoards.get(s).remove(pos);
        }
        else {
            createKey(s);
            int pos = rand.nextInt(botBoards.get(s).size());
            return botBoards.get(s).remove(pos);
        }
    }

    public void updateMap(int res) {
        if (res == 0) {
            return;
        } else if (res == 1) {
            int l = curPlaces.size();
            for (int i=0; i<l; i++) {
                botBoards.get(curStrings.get(0)).add(curPlaces.get(0));
                curPlaces.remove(0);
                curStrings.remove(0);
            }
        } else {
            int l = curPlaces.size();
            for (int i=0; i<l; i++) {
                botBoards.get(curStrings.get(0)).add(curPlaces.get(0));
                botBoards.get(curStrings.get(0)).add(curPlaces.get(0));
                botBoards.get(curStrings.get(0)).add(curPlaces.get(0));
                curPlaces.remove(0);
                curStrings.remove(0);
            }
        }
    }
}
