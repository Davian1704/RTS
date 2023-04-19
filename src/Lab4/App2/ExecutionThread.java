package Lab4.App2;

public class ExecutionThread extends Thread{
    Integer monitor1,monitor2;
    int sleepvalue, activity_max1,activity_min1, activity_max2,activity_min2;

    public ExecutionThread(Integer monitor1, Integer monitor2, int sleepvalue,int activity_min1,int activity_max1,int activity_min2,int activity_max2){
        this.monitor1=monitor1;
        this.monitor2=monitor1;
        this.sleepvalue=sleepvalue;
        this.activity_min1=activity_min1;
        this.activity_max1=activity_max1;
        this.activity_min2=activity_min2;
        this.activity_max2=activity_max2;
    }


    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max1-activity_min1) + activity_min1);
        for(int i = 0; i < k * 100000; i++){
            i++;i--;
        }
        synchronized (monitor1){
            System.out.println(this.getName() + " - STATE 2");
            k = (int) Math.round(Math.random() * (activity_max2-activity_min2) + activity_min2);
            for(int i = 0; i < k * 100000; i++){
                i++;i--;
            }
        }
        synchronized (monitor2){
        System.out.println(this.getName() + " - STATE 3");
        try {
            Thread.sleep(Math.round(Math.random() * sleepvalue * 500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
            }
        }
        System.out.println(this.getName() + " - STATE 4");
    }
}
