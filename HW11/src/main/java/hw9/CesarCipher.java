package hw9;

import java.util.ArrayList;
import java.util.List;

public class CesarCipher {

    private List<Character> alphabet = new ArrayList<Character>();

    CesarCipher() {

        for (char i = 'a'; i <= 'z'; i++) {
            alphabet.add(i);
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            alphabet.add(i);
        }

        for (char i = '0'; i <= '9'; i++) {
            alphabet.add(i);
        }

    }

    String encode(String baseString) {

        return encodeDecode(baseString, true);

    }

    String decode(String baseString) {

        return encodeDecode(baseString, false);

    }

    private String encodeDecode(String baseString, boolean b) {

        int sizeOfAlphabet = alphabet.size();
        char ch;
        int index;
        StringBuilder encodedString = new StringBuilder();

        for (int i = 0; i < baseString.length(); i++) {

            ch = baseString.charAt(i);
            index = alphabet.indexOf(ch);

            if (index == -1) {                                                                                           //if symbol not found in alphabet don't change it.

                encodedString.append(ch);
                continue;

            }

            if (b == true) {

                index = (index + 11) % sizeOfAlphabet;

            } else {
                index = (index - 11) % sizeOfAlphabet;
            }

            encodedString.append(alphabet.get(index));

        }

        return encodedString.toString();

    }

}




