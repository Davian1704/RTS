package Lab4.App4;


public class Main {
    public static void main(String[] args){
        Integer monitor1 = new Integer(1);
        Integer monitor2= new Integer(2);
        ExecutionThreadGenerator t = new ExecutionThreadGenerator(monitor1,monitor2,7,2,3);
        t.start();
        new ExecutionThread(monitor1,3,5,t).start();
        new ExecutionThread(monitor2,4,6,t).start();
    }
}