import java.util.ArrayList;
import java.util.List;

public class AddNumberBase36 {

    private List<Character> alphabet = new ArrayList<Character>();

    public AddNumberBase36() {

        for (char i = '0'; i <= '9'; i++) {
            alphabet.add(i);
        }

        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.add(i);
        }


    }

    public String add(String a, String b) {

        char chA;
        char chB;
        char tmp = '0';
        int result = 0;
        StringBuilder output = new StringBuilder();

        if (a.length() > b.length()) {

            b = addZeros(b, a.length() - b.length());

        } else if (b.length() > a.length()) {

            a = addZeros(a, b.length() - a.length());

        }

        for (int i = a.length() - 1; i >= 0; i--) {

            chA = a.toLowerCase().charAt(i);
            chB = b.toLowerCase().charAt(i);

            result = alphabet.indexOf(chA) + alphabet.indexOf(chB) + alphabet.indexOf(tmp);


            if (result >= 36) {

                tmp = '1';
                output.append(alphabet.get(result - 36));
                continue;

            }

            output.append(alphabet.get(result));
            tmp = '0';

        }


        if (tmp > '0') {

            output.append(alphabet.indexOf(tmp));

        }


        return output.reverse().toString();


    }

    private String addZeros(String a, int diff) {                                                                         //add zeros in the begin of array

        StringBuilder output = new StringBuilder();

        output.append(a);

        for (int i = 0; i < diff; i++) {

            output.insert(0, '0');

        }

        return output.toString();

    }


}