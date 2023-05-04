package Lab5.App2Lab4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExecutionThread extends Thread{
    Lock l1,l2;
    int activityMin1,activityMax1,activityMin2,activityMax2,sleepVal;
    public ExecutionThread(Lock l1,Lock l2,int activityMin1, int activityMax1, int activityMin2, int activityMax2, int sleepVal){
        this.l1=l1;
        this.l2=l2;
        this.activityMin1=activityMin1;
        this.activityMax1=activityMax1;
        this.activityMin2=activityMin2;
        this.activityMax2=activityMax2;
        this.sleepVal=sleepVal;
    }

    public void run(){
        System.out.println(this.getName() + " - STATE 1");
        int k=(int)Math.round(Math.random() * (activityMax2-activityMin2)+activityMin2);
        for(int i=1;i<k;i++){
            i++;i--;
        }
        if(this.l1.tryLock()){
            try {
                System.out.println(this.getName() + " - STATE 2");
                k = (int) Math.round(Math.random() * (activityMax2 - activityMin2) + activityMin2);
                for (int i = 1; i < k; i++) {
                    i++;
                    i--;
                }
                if (this.l2.tryLock()) {
                    try {
                        System.out.println(this.getName() + " - STATE 3");
                        Thread.sleep(sleepVal * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        l2.unlock();
                    }
                }
            }
            finally {
                l1.unlock();

            }
            System.out.println(this.getName() + " - STATE 4");

        }
    }
}

public class Main {
    public static void main(String args[]){
        Lock l1 = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        new ExecutionThread(l1,l2,2,4,4,6,4).start();
        new ExecutionThread(l2,l1,3,5,5,7,5).start();
    }
}
