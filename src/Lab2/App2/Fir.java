package Lab2.App2;

import java.util.Observable;

public class Fir extends Observable implements Runnable {

    private int id;
    Thread thread;
    private int processorLoad;
    int val;

    Fir(int id, int procLoad,int priority){
        this.id=id;
        this.processorLoad=procLoad;
        this.thread = new Thread(this);
        this.thread.setPriority(priority);
    }

    @Override
    public void run(){
        int c=0;
        while(c<1000){
            for(int j=0;j<this.processorLoad;j++){
                j++;j--;
            }
            c++;
            
            val=c;
            this.setChanged();
            this.notifyObservers();
        }
    }

    public int getId() {
        return id;
    }


    public int getVal(){
        return val;
    }
}
