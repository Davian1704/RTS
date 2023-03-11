package Lab2.App3;

import java.util.Observable;
import java.util.Random;

public class Square extends Observable implements Runnable{
    private int id;

    private volatile static boolean stopWork;

    private int processorLoad;

    private int speed;

    Thread thread;

    private int x,y;

    public Square(int nr, int processorLoad) {
        this.processorLoad=processorLoad;
        this.x=(nr+1)*100;
        this.y=0;
        this.thread = new Thread(this);
        this.id=nr;
        Random random = new Random();
        speed = random.nextInt(90-20)+20;
    }

    @Override
    public void run() {
        int c=0;
        while(!stopWork){
            for(int j=0;j<this.processorLoad;j+=1){
                j--;j++;
            }
            c++;
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            stop();
            y=c;
            this.setChanged();
            this.notifyObservers();

        }
    }


    public void stop(){
        if(y>=380) {
            this.stopWork = true;
            System.out.println("Id: "+id + " y:" + y);
        }
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
