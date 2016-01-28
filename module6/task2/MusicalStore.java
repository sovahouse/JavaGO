package task2;


import java.util.ArrayList;
import java.util.Scanner;

public class MusicalStore {

    public static void main(String[] args) {

        ArrayList<MusicalInstrument> instruments = new ArrayList<MusicalInstrument>();
        instruments.add(new Guitar());
        instruments.add(new Piano());
        instruments.add(new Trumpet());

        System.out.println("Please enter a number of musical instruments that you want to buy:");
        final Scanner scanner = new Scanner(System.in);
        final int userInput = scanner.nextInt();

        try {
            if (userInput > instruments.size()) {
                throw new InstrumentsAreEndedException(userInput);
            }

            buyInstruments(userInput);

        } catch (InstrumentsAreEndedException e) {
            System.out.println("The store doesn't have " + e.getUserQuantity() + " musical instruments! Sorry!");
        }




    }

    public static void buyInstruments(final int quantity) {

        System.out.println("Congratulations! You have bought " + quantity + " musical instruments.");

    }
}
