import java.util.ArrayList;
import java.util.List;

public class AbcNumber {

    private List<Character> alphabet = new ArrayList<Character>();

    public AbcNumber() {

        for (char i = 'a'; i < 'k'; i++) {

            alphabet.add(i);

        }

    }

    public int convert(String num) {

        int output = 0;
        char[] numChar = num.toCharArray();
        int numLength = (int) Math.pow(10, numChar.length - 1);
        int itter = 0;

        if(isAllA(numChar)) {
            return 0;
        }

        for(int i = 0; numChar[i] == 'a' && i < numChar.length; i++) {

            numLength /= 10;
            itter++;

        }

        for(; itter < numChar.length; itter++, numLength /=10) {

            output += alphabet.indexOf(numChar[itter]) * numLength;


        }

        return output;

    }

    private boolean isAllA(char[] numChar) {

        for(int i = 0; i < numChar.length; i++) {

            if(numChar[i] != 'a') {

                return false;

            }

        }

        return true;
    }

}
