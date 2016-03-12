
public class MatrixSnakeTraversal {

    public int[] print(int[][] input) {

        int h = input.length;
        int w = input[0].length;
        int top = 0, bottom = h - 1;
        int[] output = new int[w*h];
        int x = 0;

        int circle = input[0].length;
        boolean upOrDown = true;

        for (int c = 0; c < circle; c++) {

            if (upOrDown) {

                for(int i = top; i <= bottom; i++) {

                    output[x] = input[i][c];
                    upOrDown = false;
                    x++;

                }
            } else {

                for(int i = bottom; i >= top; i--) {

                    output[x] = input[i][c];
                    upOrDown = true;
                    x++;

                }

            }

        }

        return output;
    }


}
