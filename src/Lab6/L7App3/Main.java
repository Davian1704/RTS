package Lab6.L7App3;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String args[]){
        CountDownLatch latch = new CountDownLatch(3);
        Integer monitor1=new Integer(1);
        Integer monitor2=new Integer(2);
        GeneratorThread generatorThread = new GeneratorThread(latch,monitor1,monitor2,7,2,3,"Generator");
        ExecutionThread ex1 = new ExecutionThread(latch,monitor1,null,5,3,6,"Thread 1");
        ExecutionThread ex2 = new ExecutionThread(latch,null,monitor2,3,4,6,"Thread 2");
        generatorThread.start();
        ex1.start();
        ex2.start();
    }
}

class GeneratorThread extends Thread{
    Integer monitor1, monitor2;
    int sleepVal, actMin, actMax;

    CountDownLatch latch;
    public GeneratorThread(CountDownLatch latch,Integer monitor1, Integer monitor2, int sleepVal, int actMin, int actMax, String name){
        this.latch = latch;
        this.monitor1=monitor1;
        this.monitor2=monitor2;
        this.sleepVal=sleepVal;
        this.actMin=actMin;
        this.actMax=actMax;
        this.setName(name);
    }

    public void run(){
        System.out.println(this.getName() + " STATE 1");
        try {
            Thread.sleep(sleepVal*500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " STATE 2");
        int k= (int) Math.round(Math.random()*(actMin-actMax)-actMin);
        for(int i=0;i<k;i++){
            i++;i--;
        }
        synchronized (monitor1) {
            monitor1.notify();
        }
        synchronized (monitor2){

        }
        System.out.println(this.getName() + " STATE 3");

            latch.countDown();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + " Terminated");
    }
}

class ExecutionThread extends Thread{
    CountDownLatch latch;
    Integer monitor1, monitor2;
    int sleepVal, actMin, actMax;

    public ExecutionThread(CountDownLatch latch,Integer monitor1, Integer monitor2, int sleepVal, int actMin, int actMax, String name){
        this.latch=latch;
        this.monitor1=monitor1;
        this.monitor2=monitor2;
        this.sleepVal=sleepVal;
        this.actMin=actMin;
        this.actMax=actMax;
        this.setName(name);
    }

    public void run(){
        System.out.println(this.getName() + " STATE 1");
        if(monitor1!=null) {
            try {
                synchronized (monitor1) {
                    monitor1.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " STATE 2");
            int k= (int) Math.round(Math.random()*(actMin-actMax)-actMin);
            for(int i=0;i<k;i++){
                i++;i--;
            }
        }
        if(monitor2!=null){
            synchronized (monitor2){
                System.out.println(this.getName() + " STATE 2");
                int k= (int) Math.round(Math.random()*(actMin-actMax)-actMin);
                for(int i=0;i<k;i++){
                    i++;i--;
                }
            }
        }
        System.out.println(this.getName() + " STATE 3");

            latch.countDown();

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getName() + " Terminated");

    }
}