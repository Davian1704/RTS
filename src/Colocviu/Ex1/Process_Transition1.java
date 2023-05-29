package Colocviu.Ex1;


import Colocviu.Ex1.Interfaces.PlaceHandlerTemplate;
import Colocviu.Ex1.Interfaces.TransitionTemplate;

public class Process_Transition1 implements TransitionTemplate {

    String name;
    PlaceHandlerTemplate PH;
    Integer delay, eet, let;

    public Process_Transition1(String name, PlaceHandler PH, int delay){
        this.Init(name,PH);
        this.SetDelay(delay);
    }

    public Process_Transition1(String name, PlaceHandler PH, int eet, int let){
        this.Init(name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String name, PlaceHandlerTemplate PH) {
        this.name=name;
        this.PH = PH;
    }

    @Override
    public void SetDelay(int value) {
        this.delay=value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet=eet;
        this.let=let;
    }

    @Override
    public void TransitionDelay() {
        try{
            if(this.let == null)
                Thread.sleep(delay*500);
            else{
                Thread.sleep(Math.round(Math.random()*(let-eet)+eet)*500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Robot-------------------\n";

        return false;
    }

    @Override
    public String Print() {
        return this.name + "\n" + this.PH.PrintAllPlaces();
    }
}
