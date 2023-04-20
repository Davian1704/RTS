package Lab5.App4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExecutionThread extends Thread{
    Semaphore s1,s2;
    int activityMin1,activityMax1,activityMin2,activityMax2,sleepVal;
    Thread t;
    public ExecutionThread(Semaphore s1, Semaphore s2,int activityMin1, int activityMax1, int activityMin2, int activityMax2, int sleepVal,Thread t){
        this.s1=s1;
        this.s2=s2;
        this.activityMin1=activityMin1;
        this.activityMax1=activityMax1;
        this.activityMin2=activityMin2;
        this.activityMax2=activityMax2;
        this.sleepVal=sleepVal;
        this.t=t;
    }

    public void run() {
        while (true) {
            System.out.println(this.getName() + " - STATE 1");
            int k = (int) Math.round(Math.random() * (activityMax2 - activityMin2) + activityMin2);
            for (int i = 1; i < k; i++) {
                i++;
                i--;
            }
            try {
                s1.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.round(Math.random() * (activityMax2 - activityMin2) + activityMin2);
            for (int i = 1; i < k; i++) {
                i++;
                i--;
            }

            try {
                s2.acquire(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep(sleepVal * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            s1.release();
            s2.release();
            System.out.println(this.getName() + " - STATE 4");
            if(t!=null)
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
    }

}


public class Main {
    public static void main(String args[]){
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(1);
        ExecutionThread t1 = new ExecutionThread(s1,s2,2,4,4,6,4,null);
        ExecutionThread t2 = new ExecutionThread(s2,s1,3,5,5,7,5,t1);
        t1.start();
        t2.start();
    }
}

