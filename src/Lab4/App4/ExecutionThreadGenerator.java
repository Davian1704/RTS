package Lab4.App4;

public class ExecutionThreadGenerator extends Thread{
    int sleepvalue, activity_max,activity_min;
    Integer monitor1,monitor2;
    public ExecutionThreadGenerator(Integer monitor1, Integer monitor2,int sleepvalue,int activity_min, int activity_max){
        this.monitor1=monitor1;
        this.monitor2=monitor2;
        this.sleepvalue=sleepvalue;
        this.activity_min=activity_min;
        this.activity_max=activity_max;

    }


    public void run() {
        System.out.println(this.getName() + " - State 1");
        try {
            Thread.sleep(Math.round(Math.random() * sleepvalue * 500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        System.out.println(this.getName() + " - State 2");
        synchronized (monitor1){
            monitor1.notify();
        }

        synchronized (monitor2){
            monitor2.notify();
        }
        System.out.println(this.getName() + " - State 3");

    }
}

