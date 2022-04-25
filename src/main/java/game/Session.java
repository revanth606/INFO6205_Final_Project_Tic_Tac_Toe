package game;

public class Session {

    public static void main(String[] args) {
        Menace m = new Menace();
        Human h = new Human();
        Round r = new Round(m, h);
        m.updateMap(r.start());
    }

}


