package Lab2.App4;

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
        y=0;
        while(!stopWork){
            for(int j=0;j<this.processorLoad;j+=1){
                j--;j++;
            }
            y++;
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            refresh();
            this.setChanged();
            this.notifyObservers();

        }
    }


    public void refresh(){
        if(this.y>=380) {
            this.x=(id+1)*100;
            this.y=0;
        }

    }

    public void stop(){
        stopWork=true;
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
