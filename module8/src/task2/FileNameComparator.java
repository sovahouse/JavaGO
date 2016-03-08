package task2;


import task1.File;

import java.util.Comparator;

public class FileNameComparator implements Comparator<File> {

    @Override
    public int compare(File f1, File f2) {
        return f1.getName().compareToIgnoreCase(f2.getName());
    }
}
