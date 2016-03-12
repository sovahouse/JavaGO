public class FirstUniqueCharacter {

    public Character find(String s) {

        char c;
        char output = '0';
        boolean find = false;

        for (int i = 0; i < s.length(); i++) {

            c = s.charAt(i);

            if(find) {

                break;

            }
            output = c;

            for (int j = 0; j < s.length(); j++) {

                if(i == j) {

                    find = true;
                    continue;

                }

                if(c != s.charAt(j)) {

                    find = true;

                } else {

                    find = false;
                    break;

                }

            }

        }

        if(find) {

            return output;

        }


        return null;

    }
}