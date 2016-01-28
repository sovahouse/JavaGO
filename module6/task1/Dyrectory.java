package task1;


import java.util.ArrayList;
import java.util.List;

public class Dyrectory {

    public static void main(String[] args) {
        ArrayList<File> files = new ArrayList<File>();

        files.add(new Audio());
        files.add(new Image());
        files.add(new Text());

        try {
            files.add(100, new Audio());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wrong index");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }



}
