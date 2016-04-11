import Implementation.SemaphoreImpl;
import Interface.Semaphore;

import java.util.stream.IntStream;

public class Runner {

    private final Semaphore semaphore = new SemaphoreImpl(2);

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.test();
    }


    private void test() {

        //for (int i=0; i < 10; i++) new Thread(new Worker()).start();
        IntStream.range(0, 10).forEach((i) -> new Thread(new Worker()).start());
    }

    private class Worker implements Runnable {


        @Override
        public void run() {

            try {

                semaphore.acquire(2);

                System.out.println("Start " + Thread.currentThread().getName());
                Thread.sleep(3000);

                System.out.println("Finish " + Thread.currentThread().getName());
                semaphore.release(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }

}
