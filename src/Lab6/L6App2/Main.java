package Lab6.L6App2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String args[]){
        try {
            FileWriter writer = new FileWriter("results.txt",true);
            CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
                @Override
                public void run() {
                    System.out.print('\n');
                }
            });
            writer.write("Something");
            Integer monitor1 = new Integer(1);
            Fir fir1 = new Fir(barrier,writer,monitor1);
            Fir fir2 = new Fir(barrier,writer,monitor1);
            Fir fir3 = new Fir(barrier,writer,monitor1);
            fir1.start();
            fir2.start();
            fir3.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Fir extends Thread{
    CyclicBarrier barrier;
    Integer monitor1;
    volatile FileWriter fileWriter;
    static int result=0;
    int iterations;
    public Fir(CyclicBarrier barrier,FileWriter fileWriter,Integer monitor1){
        this.barrier=barrier;
        this.iterations=0;
        this.fileWriter=fileWriter;
        this.monitor1=monitor1;
    }

    public void run(){
        System.out.println(this.getName() + ">activate");
        while(true){
            try {
                Random random=new Random();
                result+= random.nextInt(-10,10);
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(result);
            if(result==0){
                ///try with locks
                synchronized (monitor1) {
                    try {
                        fileWriter.write(this.getName() + iterations + '\n');
                        System.out.println(this.getName() + " : " + iterations + '\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            iterations++;
        }
    }
}
