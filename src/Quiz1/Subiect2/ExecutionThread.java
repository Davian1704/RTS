package Quiz1.Subiect2;

public class ExecutionThread extends Thread{
    Integer monitor;
    Thread t;
    int activityMin, activityMax;

    public ExecutionThread(Thread t,Integer monitor, int activityMin, int activityMax){
        this.monitor=monitor;
        this.activityMax=activityMax;
        this.activityMin=activityMin;
        this.t=t;
    }

    public void run(){
        System.out.println(this.getName() +  " - STATE 1");
        if(t==null)
            new LoopThread(6,3,8,6,3).start();
        synchronized (monitor){
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activityMax - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
        System.out.println(this.getName() + " - STATE 3");
        if(t!=null)
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        System.out.println(this.getName() + " - Terminated");
    }
}
