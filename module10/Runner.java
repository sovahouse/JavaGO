
import java.io.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {

        CesarCipher cipher = new CesarCipher();

        try (Scanner scanner = new Scanner(System.in);
             FileWriter writer = new FileWriter("text.txt")) {

            writer.write(cipher.encode(scanner.nextLine()));

        }

        try (FileReader reader = new FileReader("text.txt")) {

            int c;
            StringBuilder decodedString = new StringBuilder();
            while ((c = reader.read()) != -1) {

                decodedString.append((char) c);

            }

            System.out.println(cipher.decode(decodedString.toString()));

        }

    }

}
