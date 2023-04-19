package Quiz1.Subiect1;

public class SecondThread extends Thread{
    Integer monitor;
    int activityMin,activityMax;

    public SecondThread(Integer monitor, int activityMin,int activityMax){
        this.monitor=monitor;
        this.activityMin=activityMin;
        this.activityMax=activityMax;
    }

    public void run(){
        while(true) {
            synchronized (monitor) {
                System.out.println(this.getName() + " - STATE 1");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 3");
        }
    }
}
