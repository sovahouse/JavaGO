import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public List<List<String>> parse(String input) {
        List<List<String>> output = new ArrayList<>();
        List<String> line = new ArrayList<>();

        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {

            char ch = input.charAt(i);

            for (;i < input.length() && ch != '\n'; i++) {

                ch = input.charAt(i);

                if(Character.isAlphabetic(ch)) tmp.append(ch);

                if (ch == ',' || i == input.length() - 1 || ch == '\n') {

                    line.add(tmp.toString());
                    tmp.delete(0, tmp.length());

                }
            }

            output.add(line);
            line.clear();




        }


        return output;
    }
}