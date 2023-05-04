package Lab5.App4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExecutionThread extends Thread{
    Semaphore s1;
    int activityMin,activityMax,sleepVal;
    Thread t;
    public ExecutionThread(Semaphore s1,int activityMin, int activityMax, int sleepVal){
        this.s1=s1;
        this.activityMin=activityMin;
        this.activityMax=activityMax;
        this.sleepVal=sleepVal;
        this.t=t;
    }

    public void run() {
        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                s1.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
            for (int i = 1; i < k; i++) {
                i++;
                i--;
            }
            s1.release();
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep(sleepVal * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 4");

        }
    }

}


public class Main {
    public static void main(String args[]){
        Semaphore s1 = new Semaphore(2);
        ExecutionThread t1 = new ExecutionThread(s1,4,7,4);
        ExecutionThread t2 = new ExecutionThread(s1,5,7,5);
        ExecutionThread t3 = new ExecutionThread(s1,3,6,5);
        t1.start();
        t2.start();
        t3.start();
    }
}

