
public class MatrixTraversal {

    public int[] print(int[][] input) {

        int h = input.length;
        int w = input[0].length;
        int top = 0, right = w - 1, left = 0, bottom = h - 1;
        int[] output = new int[w*h];
        int x = 0;

        int circle = size(input);

        for (int c = 0; c < circle; c++) {

            top += c;
            right -= c;
            left += c;
            bottom -= c;

            for(int i = left; i <= right && x < w*h; i++) {

                output[x] = input[top][i];
                x++;

            }

            x--;

            for(int i = top; i <= bottom && x < w*h; i++) {

                output[x] = input[i][right];
                x++;

            }

            x--;

            for(int i = right; i >= left && x < w*h; i--) {

                output[x] = input[bottom][i];
                x++;

            }

            x--;

            for(int i = bottom; i >= top + 1 && x < w*h; i--) {

                output[x] = input[i][top];
                x++;

            }

        }


        return output;

    }

    private int size(int[][] input) {

        if(input == null) {
            return -1;
        }

        float size;

        if(input.length < input[0].length) {

            size = input.length;

        } else {

            size = input[0].length;

        }

        size = Math.round(size / 2);

        return (int) size;

    }

}
