package hw9;


import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        List<File> files = new ArrayList<File>();

        files.add(new Audio("Music"));
        files.add(new Image("Photo"));
        files.add(new Text("Doc"));

        CesarCipher cipher = new CesarCipher();
        StringBuilder encodedString = new StringBuilder();

        System.out.println("Names:");

        for (File f : files) {

            System.out.println(f.toString());
            encodedString.append(cipher.encode(f.toString()) + "\n");

        }

        System.out.println("\nEncoded names:" + "\n" + encodedString);

        System.out.println("Decoded names:" + "\n" + cipher.decode(encodedString.toString()));



    }

}
