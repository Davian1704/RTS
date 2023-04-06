package Lab4.App4;

public class ExecutionThread extends Thread{
    int activity_max,activity_min;
    Thread t;
    public ExecutionThread(int activity_min, int activity_max,Thread t){
        this.activity_min=activity_min;
        this.activity_max=activity_max;
        this.t=t;
    }


    public void run() {
        System.out.println(this.getName() + " - State 1");
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - State 2");
        System.out.println(this.getName() + " - State 3");

        
        System.out.println(this.getName() + " - State 0");
    }
}