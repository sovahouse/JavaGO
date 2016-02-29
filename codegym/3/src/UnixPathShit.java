

public class UnixPathShit {



    public String simplify(String input) {

        StringBuilder output = new StringBuilder(input.replace("/home/", ""));


        do {

            for (int i = 0; i < output.length(); i++) {

                if (output.lastIndexOf(".") == i && isStringHaveFileType(output)) {

                    break;

                } else if (output.lastIndexOf(".") == i && !isStringHaveFileType(output)) {

                    output.deleteCharAt(i);
                    break;

                }

                if (output.charAt(i) == '.') {

                    output.deleteCharAt(i);

                }

            }

        } while (isStringHaveMoreOneDots(output));

        for (int i = 0; i < output.length(); i++) {

            if(i + 1 >= output.length()) {
                break;
            }

            if (output.charAt(i) == '/' && output.charAt(i + 1) == '/') {

                output.deleteCharAt(i);

            }

        }



        return output.toString();

    }

    private boolean isStringHaveMoreOneDots(StringBuilder input) {

        short counter = 0;

        for (int i = 0; i < input.length(); i++) {

            if (counter >= 2) {

                return true;

            }

            if (input.charAt(i) == '.') {

                counter++;

            }

        }

        return false;
    }
    private boolean isStringHaveFileType(StringBuilder input) {

        int fileTypeIndex = input.lastIndexOf(".") + 1;

        if(fileTypeIndex < input.length() && Character.isAlphabetic(input.charAt(fileTypeIndex))) {

            return true;

        }

        return false;
    }
}





























