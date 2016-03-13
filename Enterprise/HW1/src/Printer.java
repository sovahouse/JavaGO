import java.io.*;

public class Printer {

    public static void print(long[][][] input) {

        String[] colomsName = {"add", "get", "remove", "contains", "populate", "iterator.add", "iterator.remove"};
        String colomsLabel = "            add    get   remove  contains populate  iterator.add  iterator.remove";
        String[] rowName = {"ArrayList", "LinkedList", "HashSet", "TreeSet"};
        StringBuilder[] rows = new StringBuilder[4];
        int sets = 10;

        try(FileWriter writer = new FileWriter("output.txt")) {

            for (long[][] tables : input) {

                for (int z = 0; z < rows.length; z++) {

                    StringBuilder tmp = new StringBuilder("                                                                           ");
                    rows[z] = tmp;

                }

                writer.write("\nFor " + sets + "K elements:\n" + colomsLabel + "\n");
                sets *= 10;

                for (int j = 0; j < tables.length; j++) {

                    rows[j].insert(0, rowName[j] + ": ");

                    for (int x = 0; x < tables[j].length; x++) {

                        rows[j].insert(colomsLabel.indexOf(colomsName[x]), tables[j][x] + " ");


                    }
                }

                for (StringBuilder s : rows) {
                    writer.write(s.toString() + '\n');
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }


    }


}
