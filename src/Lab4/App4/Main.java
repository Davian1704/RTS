package Lab4.App4;


public class Main {
    public static void main(String[] args){

        ExecutionThreadGenerator t = new ExecutionThreadGenerator(7,2,3);
        t.start();
        new ExecutionThread(3,5,t).start();
        new ExecutionThread(4,6,t).start();
    }
}