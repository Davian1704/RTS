package Quiz1.Subiect2;

public class Main {

    public static void main(String args[]){
        Integer monitor = new Integer(1);

        ExecutionThread t2 = new ExecutionThread(null,monitor,5,7);
        ExecutionThread t1 = new ExecutionThread(t2,monitor,4,7);
        t1.setName("First Thread");
        t2.setName("Second Thread");
        t1.start();
        t2.start();
    }
}
