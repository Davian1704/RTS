package Lab2.App2;

public class Main {

    private static final int noOfThreads=6;

    private static final int processorLoad=1000000;

    public static void main(String args[]){

        Window win=new Window(noOfThreads);

        for(int i =0; i<noOfThreads; i++){
            Fir model = new Fir(i,processorLoad);
            new Controller(model,win,i+2).start();

        }

    }

}
