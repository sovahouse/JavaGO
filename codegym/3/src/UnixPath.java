

public class UnixPath {



    public String simplify(String input) {

        String output = new String();

        input = input.replace("/home/", "");

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == '/') {

                output = foldersFinder(input, i);

            } else { continue;}

        }

        return output;

    }

    private String foldersFinder(String input, int position) {

        StringBuilder output = new StringBuilder();
        output.append(input.charAt(position));

        for (int i = position + 1; i < input.length() && input.charAt(i) != '/'; i++) {

            if (Character.isAlphabetic(input.charAt(i))) {

                output.append(input.charAt(i));

            }

        }

        return output.toString();

    }

}





























