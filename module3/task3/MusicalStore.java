package module3.task3;


import java.util.ArrayList;

public class MusicalStore {

    public static void main(String[] args) {

        ArrayList<MusicalInstrument> instruments = new ArrayList<MusicalInstrument>();

        instruments.add(new Guitar());
        instruments.add(new Piano());
        instruments.add(new Trumpet());
    }
}
