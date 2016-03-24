package Implementation;

import Interface.Semaphore;

public class SemaphoreImpl implements Semaphore {

    private volatile int availableThreads;
    private final Object lock = new Object();

    public SemaphoreImpl(int threadsNumber) {
        if(threadsNumber <= 0) throw new IllegalArgumentException();
        this.availableThreads = threadsNumber;
    }

    @Override
    public void acquire() throws InterruptedException {
        synchronized (lock) {
            acquire(1);
        }
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        synchronized (lock) {
            if (permits < 0) throw new IllegalArgumentException();

            if (availableThreads < permits  && availableThreads != 0) { //if requested threads more than available, so give all available
                availableThreads = 0;
            } else if (availableThreads >= permits) {
                availableThreads -= permits;
            } else {
                lock.wait();
            }
        }
    }

    @Override
    public void release() {
        release(1);
    }

    @Override
    public void release(int permits) {
        synchronized (lock) {
            if (permits < 0) throw new IllegalArgumentException();
            for (; permits > 0; permits--) {
                availableThreads++;
                if (availableThreads > 0) {
                    lock.notify();
                }
            }

        }
    }

    @Override
    public int getAvailablePermits() {
        return availableThreads;
    }
}
