package Lab6.L7App1A;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) throws BrokenBarrierException, InterruptedException {
        Lock lock1 =new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        CyclicBarrier barrier = new CyclicBarrier(3);
        while(true) {
            new ExecThread(barrier, lock1, lock2, 2, 4, 4, 6, 4).start();
            new ExecThread(barrier, lock1, lock2, 3, 5, 5, 7, 5).start();
            barrier.await();
            barrier.reset();
            Thread.sleep(5000);
        }
    }
}

class ExecThread extends Thread{
    Lock lock1,lock2;
    int activityMin1, activityMin2, activityMax1, activityMax2;
    int sleepVal;

    CyclicBarrier barrier;

    public ExecThread(CyclicBarrier barrier,Lock lock1, Lock lock2, int activityMin1, int activityMin2, int activityMax1, int activityMax2, int sleepVal){
        this.barrier=barrier;
        this.lock1=lock1;
        this.lock2=lock2;
        this.activityMin1=activityMin1;
        this.activityMin2=activityMin2;
        this.activityMax1=activityMax1;
        this.activityMax2=activityMax2;
        this.sleepVal=sleepVal;
    }

    public void run(){

            System.out.println(this.getName() + " State 1");
            int k = (int) Math.round(Math.random() * (activityMax1 - activityMin1) + activityMin1);
            int i;
            for (i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }

            lock1.lock();
            System.out.println(this.getName() + " State 2");
            lock1.unlock();
            lock2.lock();
            System.out.println(this.getName() + " State 3");
            k = (int) Math.round(Math.random() * (activityMax2 - activityMin2) + activityMin2);
            for (i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            lock2.unlock();
            try {
                Thread.sleep(500 * sleepVal);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " State 4");
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " has ended");
    }
}
