
public class JoinCharacters {

    public static int join(char[] input) {

        int output = 0;

        for(int i = input.length - 1, x = 1; i >= 0; i--) {

            output += (input[i] - 48) * x;
            x *= 10;

        }

        return output;

    }

}
