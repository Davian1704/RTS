package Colocviu.Ex1;

import Colocviu.Ex1.Interfaces.PlaceHandlerTemplate;
import Colocviu.Ex1.Interfaces.TransitionTemplate;

public class Process extends Thread{
    static boolean stop=false;
    PlaceHandler PH = new PlaceHandler();
    public Controller c;

    Float initial = Float.valueOf(1);

    Process_Transition_t11 t11;
    Process_Transition_t12 t12;
    Process_Transition_t13 t13;
    Process_Transition_t14 t14;
    Process_Transition_t10 t10;

    public void run(){
        PH.AddPlace(new IntPlace("p_11",initial));
        PH.AddPlace(new IntPlace("p_12",null));
        PH.AddPlace(new IntPlace("p_13",null));
        PH.AddPlace(new IntPlace("p_14",null));

        t11 = new Process_Transition_t11("t_11",PH,0);
        t12 = new Process_Transition_t12("t_12",PH,0);
        t13 = new Process_Transition_t13("t_13",PH,0);
        t14 = new Process_Transition_t14("t_14",PH,0);
        t10 = new Process_Transition_t10("t_10",PH,0);
        t13.controllerPH=c.PH;
        while(!stop){
            t11.TransitionGuardsMappings();
            t12.TransitionGuardsMappings();
            t13.TransitionGuardsMappings();
            t14.TransitionGuardsMappings();
            t10.TransitionGuardsMappings();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
class Process_Transition_t11 implements TransitionTemplate{
    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Process_Transition_t11(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Process_Transition_t11(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH = PH;
    }

    @Override
    public void SetDelay(int value) {
        this.sleepValue=value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet=eet;
        this.let=let;
    }

    @Override
    public void TransitionDelay() {
        if(this.let==null){
            try {
                Thread.sleep(this.sleepValue*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Thread.sleep(Math.round(Math.random()*(let-eet)+eet)*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Robot-------------------\n";
        if(!PH.GetPlaceByName("p_11").IsNull()){
            PH.GetPlaceByName("p_12").Set((Float) PH.GetPlaceByName("p_11").Get());
            PH.GetPlaceByName("p_11").Set(null);

            toPrint = toPrint.concat('\n' + Print() + '\n');
            toPrint = toPrint.concat("--------------------------------------\n");
            System.out.println(toPrint);
            return true;
        }

        return false;
    }

    @Override
    public String Print() {
        return this.Name + "\n" + this.PH.PrintAllPlaces();
    }
}

class Process_Transition_t12 implements TransitionTemplate{
    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Process_Transition_t12(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Process_Transition_t12(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH = PH;
    }

    @Override
    public void SetDelay(int value) {
        this.sleepValue=value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet=eet;
        this.let=let;
    }

    @Override
    public void TransitionDelay() {
        if(this.let==null){
            try {
                Thread.sleep(this.sleepValue*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Thread.sleep(Math.round(Math.random()*(let-eet)+eet)*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Robot-------------------\n";
        if(!PH.GetPlaceByName("p_12").IsNull()){
            PH.GetPlaceByName("p_13").Set((Float) PH.GetPlaceByName("p_12").Get());
            PH.GetPlaceByName("p_12").Set(null);

            toPrint = toPrint.concat('\n' + Print() + '\n');
            toPrint = toPrint.concat("--------------------------------------\n");
            System.out.println(toPrint);
            return true;
        }

        return false;
    }

    @Override
    public String Print() {
        return this.Name + "\n" + this.PH.PrintAllPlaces();
    }
}

class Process_Transition_t13 implements TransitionTemplate{
    String Name;
    PlaceHandlerTemplate PH;
    PlaceHandler controllerPH;

    Integer sleepValue, eet, let;

    public Process_Transition_t13(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Process_Transition_t13(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH = PH;
    }

    @Override
    public void SetDelay(int value) {
        this.sleepValue=value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet=eet;
        this.let=let;
    }

    @Override
    public void TransitionDelay() {
        if(this.let==null){
            try {
                Thread.sleep(this.sleepValue*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Thread.sleep(Math.round(Math.random()*(let-eet)+eet)*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Robot-------------------\n";
        if(!PH.GetPlaceByName("p_13").IsNull()){
            PH.GetPlaceByName("p_14").Set((Float) PH.GetPlaceByName("p_13").Get()-Float.valueOf((float) 0.01));

            this.controllerPH.GetPlaceByName("p_23").Set((Float) PH.GetPlaceByName("p_13").Get()-Float.valueOf((float) 0.01));
            PH.GetPlaceByName("p_13").Set(null);
            toPrint = toPrint.concat('\n' + Print() + '\n');
            toPrint = toPrint.concat("--------------------------------------\n");
            System.out.println(toPrint);
            return true;
        }

        return false;
    }

    @Override
    public String Print() {
        return this.Name + "\n" + this.PH.PrintAllPlaces();
    }
}

class Process_Transition_t14 implements TransitionTemplate{
    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Process_Transition_t14(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Process_Transition_t14(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH = PH;
    }

    @Override
    public void SetDelay(int value) {
        this.sleepValue=value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet=eet;
        this.let=let;
    }

    @Override
    public void TransitionDelay() {
        if(this.let==null){
            try {
                Thread.sleep(this.sleepValue*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Thread.sleep(Math.round(Math.random()*(let-eet)+eet)*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Robot-------------------\n";
        if(PH.GetPlaceByName("p_13").Get()==Float.valueOf(0)){
            Process.stop=true;
            Controller.stop=true;
            toPrint = toPrint.concat("--------------------------------------\n");
            System.out.println(toPrint);
            return true;
        }

        return false;
    }

    @Override
    public String Print() {
        return this.Name + "\n" + this.PH.PrintAllPlaces();
    }
}

class Process_Transition_t10 implements TransitionTemplate{
    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Process_Transition_t10(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Process_Transition_t10(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH = PH;
    }

    @Override
    public void SetDelay(int value) {
        this.sleepValue=value;
    }

    @Override
    public void SetDelayInRange(int eet, int let) {
        this.eet=eet;
        this.let=let;
    }

    @Override
    public void TransitionDelay() {
        if(this.let==null){
            try {
                Thread.sleep(this.sleepValue*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Thread.sleep(Math.round(Math.random()*(let-eet)+eet)*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Boolean TransitionGuardsMappings() {
        TransitionDelay();
        String toPrint="--------------Robot-------------------\n";
        if(!PH.GetPlaceByName("p_14").IsNull()){
            PH.GetPlaceByName("p_11").Set((Float) PH.GetPlaceByName("p_14").Get());
            PH.GetPlaceByName("p_14").Set(null);
            toPrint = toPrint.concat("--------------------------------------\n");
            System.out.println(toPrint);
            return true;
        }

        return false;
    }

    @Override
    public String Print() {
        return this.Name + "\n" + this.PH.PrintAllPlaces();
    }
}