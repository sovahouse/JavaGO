
public class SumDigits {

    public static int sum(int number) {

        int sum = 0;
        while (number != 0) {

            sum += number % 10;
            number /= 10;

        }

        return Math.abs(sum);

    }

}
