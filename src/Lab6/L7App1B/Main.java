package Lab6.L7App1B;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String args[]){
        Semaphore semaphore = new Semaphore(2);
        while(true) {
            CountDownLatch latch = new CountDownLatch(3);
            new ExecThread(latch, semaphore, 2, 4, 4, 6, 4);
            new ExecThread(latch, semaphore, 3, 5, 5, 7, 5);

        }
    }
}

class ExecThread extends Thread{
    Semaphore semaphore;
    int activityMin1, activityMin2, activityMax1, activityMax2;
    int sleepVal;

    CountDownLatch latch;

    public ExecThread(CountDownLatch latch,Semaphore semaphore, int activityMin1, int activityMin2, int activityMax1, int activityMax2, int sleepVal){
        this.latch=latch;
        this.semaphore=semaphore;
        this.activityMin1=activityMin1;
        this.activityMin2=activityMin2;
        this.activityMax1=activityMax1;
        this.activityMax2=activityMax2;
        this.sleepVal=sleepVal;
    }

    public void run(){
        while(true) {
            System.out.println(this.getName() + " State 1");
            int k = (int) Math.round(Math.random() * (activityMax1 - activityMin1) + activityMin1);
            int i;
            for (i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " State 2");
            semaphore.release();
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " State 3");
            k = (int) Math.round(Math.random() * (activityMax2 - activityMin2) + activityMin2);
            for (i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            semaphore.release();
            try {
                Thread.sleep(500 * sleepVal);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " State 4");
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
