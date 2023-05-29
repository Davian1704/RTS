package Colocviu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore P9 = new Semaphore(3);
        Semaphore P11 = new Semaphore(2);
        while(true){
            CountDownLatch T7 = new CountDownLatch(2);
            new Thread1(P9, P11, T7).start();
            new Thread2(P9, P11, T7).start();

                try {
                    T7.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}

class Thread1 extends Thread
{   int id;
    CountDownLatch count;
    Semaphore P9, P11;
    Thread1(Semaphore P9, Semaphore P11, CountDownLatch count)
    {
        this.count = count;
        this.P9 = P9;
        this.P11 = P11;
    }
    public void run()
    {
        Location P1= new Location();
        P1.execute(1);
        try {
            P9.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transition T1 = new Transition();
        T1.execute(2 ,2);
        Location P2 = new Location();
        P2.execute(2, 5, 2);
        try {
            P11.acquire(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transition T2 = new Transition();
        T2.execute(2);
        Location P3 = new Location();
        P3.execute(2,4,3);
        Transition T3 = new Transition();
        T3.execute(3,6,3);
        P9.release(2);
        P11.release(2);
        Location P4 = new Location();
        P4.execute(4);
        count.countDown();
        try
        {
            count.await();
        }catch(Exception e){
            System.out.println("CountDownLatch ERROR");
        }
        System.out.println("END OF THREAD 1");
    }
}


class Thread2 extends Thread
{
    CountDownLatch count;
    Semaphore P9;
    Semaphore P11;
    Thread2(Semaphore P9, Semaphore P11,CountDownLatch count)
    {
        this.count = count;
        this.P9 = P9;
        this.P11 = P11;
    }

    public void run()
    {
        Location P5 = new Location();
        P5.execute(5);
        try {
            P9.acquire(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transition T4 = new Transition();
        T4.execute(3,4);
        Location P6 = new Location();
        P6.execute(3,6,6);
        try {
            P11.acquire(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Transition T5 = new Transition();
        T5.execute(5);
        Location P7 = new Location();
        P7.execute(4,5,7);
        Transition T6 = new Transition();
        T6.execute(2,4,6);
        P9.release(3);
        P11.release(1);
        Location P8= new Location();
        P8.execute(8);
        count.countDown();
        try
        {
            count.await();
        }catch(Exception e){
            System.out.println("CountDownLatch ERROR");
        }

        System.out.println("END OF THREAD 2");
    }
}


class Location
{

    public void execute(int intTmin, int intTmax, int intNrLocation)
    {
        int k = (int)(Math.random()*(intTmax-intTmin)+intTmin);
        System.out.println("Location P"+intNrLocation);
        for(int i=0; i<k*1000000; i++)
        {
            i++;
            i--;
        }
    }
    public void execute(int intNrLocation)
    {
        System.out.println("Location P"+intNrLocation);
    }
    public void execute(int intT, int intNrLocation)
    {
        System.out.println("Location P"+intNrLocation);
        for(int i = 0; i < intT*10000000; i++)
        {
            i++;
            i--;
        }
    }
}

class Transition
{
    public void execute(int intTmin, int intTmax, int intNrTransition)
    {
        System.out.println("Transition T"+intNrTransition);
        int k = (int)(Math.random()*(intTmax-intTmin)+intTmin);
        try
        {
            Thread.sleep(k*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void execute(int intT, int intNrTransition)
    {
        System.out.println("Transition T" +intNrTransition);
        try
        {
            Thread.currentThread().sleep(intT*1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void execute(int intNrTransition)
    {
        System.out.println("Transition T"+intNrTransition);
    }
}
