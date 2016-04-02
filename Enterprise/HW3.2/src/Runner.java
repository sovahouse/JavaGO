public class Runner {



    public static void main(String[] args) throws InterruptedException {

        while (true) {
            SquareSum squareSum = new SquareSumImpl();
            int[] i = {1, 2, 3, 1};
            long result = squareSum.getSquareSum(i, 3);
            System.out.println("result = " + result);
        }
    }

}
