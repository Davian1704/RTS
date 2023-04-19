package Quiz1.Subiect1;

public class FirstThread extends Thread{
    Integer monitor;
    int sleepMin,sleepMax;

    public FirstThread(Integer monitor,int sleepMin,int sleepMax){
        this.monitor=monitor;
        this.sleepMax=sleepMax;
        this.sleepMin=sleepMin;
    }

    public void run(){
        while(true) {
            System.out.println(this.getName() + " - STATE 1");
            try {
                Thread.sleep(Math.round(Math.random() * ((sleepMax - sleepMin) + sleepMin) * 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (monitor){
                System.out.println(this.getName() + " - STATE 2");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(this.getName() + " - STATE 3");
        }
    }
}
