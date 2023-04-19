package Lab4.App2;

public class Main {
    public static void main(String[] args){
        Integer monitor1 = new Integer(1),monitor2 = new Integer(2);
        new ExecutionThread(monitor1,monitor2,4,2,4,4,6).start();
        new ExecutionThread(monitor2,monitor1,5,3,5,5,7).start();
    }
}
