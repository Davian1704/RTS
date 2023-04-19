package Quiz1.Subiect2;

public class LoopThread extends Thread{
    int sleepVal,sleepMin,sleepMax,activityMax,activityMin;

    public LoopThread(int sleepVal,int sleepMin, int sleepMax,int activityMax,int activityMin){
        this.sleepVal=sleepVal;
        this.sleepMin = sleepMin;
        this.sleepMax=sleepMax;
        this.activityMax=activityMax;
        this.activityMin=activityMin;
    }

    public void run(){
        System.out.println(this.getName() + " - State 1");
        try {
            Thread.sleep(Math.round(Math.random() * sleepVal * 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(true) {
            System.out.println(this.getName() + " - State 2");
            try {
                Thread.sleep(Math.round(Math.random() * (sleepMax - sleepMin) + sleepMin));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - State 3");
            int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
    }
}
