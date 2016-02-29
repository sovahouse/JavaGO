

public class UnixPath {




    public String simplify(String input) {

        String output;


        input = input.replace("/home/", "");
        input = input.replace("//", "/");
        output = buildFoldersPath(input);

        return output;

    }

    private String buildFoldersPath(String pathIn) {

        StringBuilder pathOut = new StringBuilder();

        int folderNameStartPosition = 0;
        int folderNameEndPosition = 0;
        boolean isStartPosition = true;
        boolean isFolderFind = false;

        for (int i = 0; i < pathIn.length(); i++) {

            if (isFolderFind) {

                pathOut.append(pathIn.substring(folderNameStartPosition,
                                                  folderNameEndPosition));
                isFolderFind = false;
            }


            if (pathIn.charAt(i) == '/' && isStartPosition) {

                folderNameStartPosition = i;
                isStartPosition = false;
                isFolderFind = false;

            } else if (pathIn.charAt(i) == '/' && !isStartPosition) {

                folderNameEndPosition = i + 1;
                isStartPosition = true;
                isFolderFind = true;

            }

        }

        pathOut.append(fileName(pathIn));

        return pathOut.toString().replace("//", "/");
    }

    private String fileName(String pathIn) {

        int StartPosition = pathIn.lastIndexOf("/");

        if(StartPosition + 1 < pathIn.length() && Character.isAlphabetic(pathIn.charAt(StartPosition + 1))) {

            return pathIn.substring(StartPosition);

        }

        return "";

    }

}





























