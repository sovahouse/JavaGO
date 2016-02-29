public class AddBinary {
    String add(String a, String b) {

        int[] tmpA = convertToInt(a);
        int[] tmpB = convertToInt(b);
        int[] intA;
        int[] intB;
        int diff;
        int tmp = 0;

        StringBuilder output = new StringBuilder();

        if (tmpA.length > tmpB.length) {                                                                                // making arrays of equal length

            diff = tmpA.length - tmpB.length;
            intB = addZeros(tmpB, diff);
            intA = tmpA;

        } else if (tmpA.length < tmpB.length) {

            diff = tmpB.length - tmpA.length;
            intA = addZeros(tmpA, diff);
            intB = tmpB;

        } else {

            intA = tmpA;
            intB = tmpB;
        }


        for (int i = intA.length - 1; i >= 0; i--) {                                                                    // array addition

            if (intA[i] == 1 && intB[i] == 1 && tmp == 1) {

                tmp = 1;
                output.append('1');
                continue;

            } else if ((intA[i] == 1 && intB[i] == 1) || ((intA[i] == 1 || intB[i] == 1) && tmp == 1)) {

                tmp = 1;
                output.append('0');
                continue;

            } else {

                output.append(intA[i] ^ intB[i] ^ tmp);
                tmp = 0;

            }
        }

        if (tmp == 1) {
            output.append(tmp);
        }


        return output.reverse().toString();
    }

    private int[] convertToInt(String input) {

        int[] output = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {

            output[i] = Character.getNumericValue(input.charAt(i));

        }

        return output;
    }

    private int[] addZeros(int a[], int diff) {                                                                         //add zeros in the begin of array

        int[] output = new int[a.length + diff];

        for (int i = 0; i < diff; i++) {

            output[i] = 0;

        }

        for (int i = 0; i < a.length; i++) {

            output[diff + i] = a[i];

        }

        return output;

    }
}

















