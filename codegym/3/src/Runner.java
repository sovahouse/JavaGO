
public class Runner {

    public static void main(String[] args) {

        String s = "one,two\nthree,";

        CSVParser csvParser = new CSVParser();
        System.out.println(csvParser.parse(s));

    }

}
