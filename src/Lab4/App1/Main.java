package Lab4.App1;

public class Main {
    public static void main(String[] args){
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(2);
        new ExecutionThread(monitor1,null,4,2,4).start();//0
        new ExecutionThread(monitor1,monitor2,5,2,5).start();//1
        new ExecutionThread(null,monitor2,3,3,6).start();//2

    }
}
