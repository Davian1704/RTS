package Lab4.App4;

public class ExecutionThread extends Thread{
    int activity_max,activity_min;
    Thread t;
    Integer monitor;
    public ExecutionThread(Integer monitor,int activity_min, int activity_max,Thread t){
        this.monitor=monitor;
        this.activity_min=activity_min;
        this.activity_max=activity_max;
        this.t=t;
    }


    public void run() {
        System.out.println(this.getName() + " - State 1");
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - State 2");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
        System.out.println(this.getName() + " - State 3");


        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}