public class WordNumber {
    public int count(String input) {

        int counter = 0;
        int characterAmount = 0;
        int i = 0;
        for (char ch : input.toCharArray()) {

            i++;
            if (Character.isAlphabetic(ch)) {

                characterAmount++;

            }

            if ((characterAmount != 0 && !Character.isAlphabetic(ch)) || (i == input.length() && characterAmount != 0)) {

                counter++;
                characterAmount = 0;

            }

        }

        return counter;

    }
}