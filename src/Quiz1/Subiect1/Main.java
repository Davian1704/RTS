package Quiz1.Subiect1;

public class Main {
    public static void main(String args[]){
        Integer monitor1,monitor2;
        monitor1=new Integer(1);
        monitor2=new Integer(2);
        FirstThread t1 = new FirstThread(monitor1,2,3);
        SecondThread t2 = new SecondThread(monitor2,4,6);
        ThirdThread t3 = new ThirdThread(monitor1,monitor2,1,5);
        t1.start();
        t2.start();
        t3.start();
    }
}
