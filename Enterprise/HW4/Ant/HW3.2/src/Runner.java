import Implementation.SquareSumImpl;
import Interface.SquareSum;

public class Runner {



    public static void main(String[] args) throws InterruptedException {

        SquareSum squareSum = new SquareSumImpl();
        int[] i = {0, 0, 0, 2};
        long result = squareSum.getSquareSum(i, 3);
        System.out.println("result = " + result);

    }

}
