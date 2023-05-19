package Lab6.L7App2A;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        while (true) {
            CountDownLatch latch = new CountDownLatch(4);
            new ExecThread(latch, lock1, null, 2, 4, 4).start();
            new ExecThread(latch, lock1, lock2, 3, 6, 3).start();
            new ExecThread(latch, null, lock2, 2, 5, 5).start();
            latch.await();
        }
    }
}



class ExecThread extends Thread{
    Lock lock1,lock2;

    int activityMin, activityMax, sleepVal;

    CountDownLatch latch;

    public ExecThread(CountDownLatch latch,Lock lock1, Lock lock2, int activityMin, int activityMax, int sleepVal){
        this.latch = latch;
        this.lock1=lock1;
        this.lock2=lock2;
        this.activityMin=activityMin;
        this.activityMax=activityMax;
        this.sleepVal=sleepVal;
    }

    public void run(){
        while(true){
            System.out.println(this.getName() + " State 1");
            if(lock1 != null)
                lock1.lock();
            if(lock2 !=null)
                lock2.lock();
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
            if(lock1 != null)
                lock1.unlock();
            if(lock2 !=null)
                lock2.unlock();
            System.out.println(this.getName() + " State 3");
            latch.countDown();
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}