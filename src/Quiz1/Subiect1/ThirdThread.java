package Quiz1.Subiect1;

public class ThirdThread extends Thread{
    Integer monitor1,monitor2;
    int activityMin,activityMax;

    public ThirdThread(Integer monitor1,Integer monitor2,int activityMax,int activityMin){
        this.monitor1=monitor1;
        this.monitor2=monitor2;
        this.activityMax=activityMax;
        this.activityMin=activityMin;
    }

    public void run(){
        while(true) {
            System.out.println(this.getName() + " - STATE 1");
            int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            synchronized (monitor1) {
                monitor1.notify();
            }
            synchronized (monitor2) {
                monitor2.notify();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 2");
        }
    }
}
