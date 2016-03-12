public class BreakLine {
    public String format(String input, int width) {

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            output.append(input.charAt(i));

            if (i % width == 0 && i != 0) {

                output.append('\n');

            }

        }

        return output.toString();

    }
}