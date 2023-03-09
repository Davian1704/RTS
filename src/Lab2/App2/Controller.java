package Lab2.App2;

public class Controller extends Thread{
    private Fir model;
    private Window view;

    public Controller(Fir model, Window view,int priority){
        this.model=model;
        this.view=view;
        this.setPriority(priority);
    }

    public void run(){

        int c=0;

        while(c<1000){

            for(int j=0;j<this.model.processorLoad;j++){

                j++;j--;

            }
            c++; this.view.setProgressValue(model.id, c);
        }
    }
}
