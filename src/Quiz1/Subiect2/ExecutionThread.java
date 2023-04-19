package Quiz1.Subiect2;

public class ExecutionThread extends Thread{
    Integer monitor;

    int activityMin, activityMax;

    public ExecutionThread(Integer monitor, int activityMin, int activityMax){
        this.monitor=monitor;
        this.activityMax=activityMax;
        this.activityMin=activityMin;
    }

    public void run(){
        System.out.println(this.getName() +  " STATE 1");
        synchronized (monitor){

        }

        try {
            this.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
