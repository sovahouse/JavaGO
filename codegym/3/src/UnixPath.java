

public class UnixPath {




    public String simplify(String input) {

        StringBuilder output = new StringBuilder();
        int stringIndexCounter = 0;

        input = findFinalPath(input);

        for (char c: input.toCharArray()) {

            if (Character.isAlphabetic(c) || c == '/') {

                output.append(c);

            }

            if (stringIndexCounter == input.lastIndexOf('/')) { break; }

            stringIndexCounter++;

        }

        output.append(fileName(input));

        return deleteExtraSlashes(output);

    }

    private String findFinalPath(String input) {

        if (!isPathHaveLetters(input)) { return input;}

        StringBuilder path = new StringBuilder(input);

        for (int i = path.length(); i >= 0; i--) {

            if (path.toString().startsWith("../", i)) {

                while (!Character.isAlphabetic(path.charAt(i))) {
                    i--;
                }


                for (; path.charAt(i) != '/'; i--) {

                    path.deleteCharAt(i);

                }

            }

        }


        return path.toString();

    }
    private boolean isPathHaveLetters(String path) {

        for (char s: path.toCharArray()) {
            if (Character.isAlphabetic(s)) { return true;}
        }

        return false;

    }
    private String fileName(String path) {

        int StartPosition = path.lastIndexOf("/");

        if(StartPosition + 1 < path.length() && Character.isAlphabetic(path.charAt(StartPosition + 1))) {

            return path.substring(StartPosition);

        }

        return "";

    }
    private String deleteExtraSlashes(StringBuilder path) {

        int startPosition;
        int endPosition;
        boolean isExtraSlashesFind = false;

        for (int i = 0; i < path.length(); i++) {

            for (startPosition = endPosition = i; i < path.length() && path.charAt(i) == '/'; i++){
                endPosition++;
                isExtraSlashesFind = true;
            }

            if (isExtraSlashesFind) {

                path.replace(startPosition, endPosition, "/");
                isExtraSlashesFind = false;

            }

        }

        if (path.toString().endsWith("/") && isPathHaveLetters(path.toString())){
            path.deleteCharAt(path.length() - 1);
        }

        return path.toString();

    }


}





























