package Lab2.App2;

public class Controller extends Thread{
    private Fir model;
    private Window view;

    public Controller(Fir model, Window view,int priority){
        this.model=model;
        this.view=view;
        this.setPriority(priority);
    }


}
