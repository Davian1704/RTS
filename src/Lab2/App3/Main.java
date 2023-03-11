package Lab2.App3;

import Lab2.App2.Fir;
import Lab2.App3.Square;
import Lab2.App3.Window;

public class Main {
    private static final int processorLoad=1000000;

    public static void main(String args[]){

        Window win = new Window();
        Square square;
        for(int i =0; i<3; i++){
            square = new Square(i,processorLoad);
            square.addObserver(win);
            square.thread.start();

        }

    }
}
