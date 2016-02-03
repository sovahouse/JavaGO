package task1;


import task2.FileNameComparator;

import java.util.Set;
import java.util.TreeSet;

public class Runner {
    public static void main(String[] args) {

        Set<File> files = new TreeSet<File>(new FileNameComparator());

        files.add(new Audio("Music"));
        files.add(new Image("Photo"));
        files.add(new Text("Doc"));

        Printer.print(files);


    }

}
