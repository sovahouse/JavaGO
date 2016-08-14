package com.app;

import java.util.ArrayList;
import java.util.List;

public class DataModule {
    private List<String> masseges = new ArrayList<String>();
    public synchronized void addMasseges(String masseg) {
        masseges.add(masseg);
    }
    public synchronized void deleteMassege(String masseg) {

    }
}
