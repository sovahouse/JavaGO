public class CountBits {


    public int count(int num) {

        int mask = 1;
        int counter = 0;

        for (int i = 0; i < 32; i++) {

            if((mask & num) == mask) {
                counter++;
            }
            mask = mask << 1;

        }

        return counter;

    }
}