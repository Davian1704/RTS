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
            FileWriter writer = new FileWriter("results.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Fir extends Thread{
    CyclicBarrier barrier;
    FileWriter writer;
    BufferedWriter bufferedWriter;
    static int result=0;
    int iterations;
    public Fir(CyclicBarrier barrier, FileWriter writer){
        this.barrier=barrier;
        this.writer=writer;
        this.iterations=0;
        this.bufferedWriter=new BufferedWriter(writer);
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
            if(result==0){

            }

        }
    }
}
