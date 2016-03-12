public class RectangleSquare {



    public int measure(int[] x, int[] h, int[] w) {

        int result = 0;
        int diff = 0;


        for (int i = 0; i < x.length; i++) {
            result += h[i]*w[i];
        }

        for (int i = 0; i < x.length -1; i++) {

            diff += (w[i] - x[i + 1]) * (h[i + 1] - x[i]);

        }

        result -= diff;

        return result;
    }
}