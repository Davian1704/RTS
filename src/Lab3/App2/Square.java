package Lab3.App2;
import java.util.Observable;
import java.util.Random;
public class Square extends Observable implements Runnable{
    static boolean start;
    private String name;
    private Thread t;
    private int processorLoad;
    private int speed;

    public Square(String name, Thread t,int processorLoad){
        this.name=name;
        this.t=t;
        this.processorLoad=processorLoad;
        Random random=new Random();
        speed=random.nextInt(90-20)+20;
    }
    @Override
    public void run() {
        try {
            if (t != null) t.join();
            while(Main.isStart()){
                for(int j=0;j<this.processorLoad;j+=1){
                    j--;j++;
                }
                Thread.sleep(speed);
            }
        }
        catch(Exception e){e.printStackTrace();}
    }
}
