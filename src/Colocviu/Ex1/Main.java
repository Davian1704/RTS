package Colocviu.Ex1;

public class Main {
    public static void main(String args[]){
        Controller c = new Controller();
        Process p = new Process();
        c.p=p;
        p.c=c;
        c.start();
        p.start();
    }
}
