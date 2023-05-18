package Lab6.L7App2B;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String args[]) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(4);
        Semaphore semaphore = new Semaphore(2);
        while(true) {
            new ExecThread(barrier, semaphore, 2, 4, 4).start();
            new ExecThread(barrier, semaphore, 3, 6, 3).start();
            new ExecThread(barrier, semaphore, 2, 5, 5).start();
            barrier.await();
            barrier.reset();
        }
    }
}


class ExecThread extends Thread{
    Semaphore semaphore;

    int activityMin, activityMax, sleepVal;

    CyclicBarrier barrier;

    public ExecThread(CyclicBarrier barrier,Semaphore semaphore, int activityMin, int activityMax, int sleepVal){
        this.barrier =barrier;
        this.semaphore=semaphore;
        this.activityMin=activityMin;
        this.activityMax=activityMax;
        this.sleepVal=sleepVal;
    }

    public void run(){

            System.out.println(this.getName() + " State 1");
            if(this.getName() == "Thread-1") {
                try {
                    semaphore.acquire(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else {
                try {
                    this.semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(this.getName() + " State 2");
            int k= (int) Math.round(Math.random() * (activityMax-activityMin) + activityMin);
            for(int i=0; i<k*100000; i++){
                i++;i--;
            }
            try {
                Thread.sleep(500*sleepVal);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.semaphore.release();
            System.out.println(this.getName() + " State 3");
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

    }

}