package Lab4.App3;

public class ExecutionThread extends Thread{
    Integer monitor;
    int sleepvalue, activity_max,activity_min;

    public ExecutionThread(Integer monitor, int sleepvalue,int activity_min, int activity_max){
        this.monitor=monitor;
        this.sleepvalue=sleepvalue;
        this.activity_min=activity_min;
        this.activity_max=activity_max;
    }


    public void run() {
        while(true) {
            synchronized (monitor) {
                System.out.println(this.getName() + " - STATE 1");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
            }
            System.out.println(this.getName() + " - STATE 2");
            try {
                Thread.sleep(Math.round(Math.random() * sleepvalue * 500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 3");
            System.out.println(this.getName() + " - STATE 0");
        }
    }
}
