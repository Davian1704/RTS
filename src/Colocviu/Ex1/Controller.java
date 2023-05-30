package Colocviu.Ex1;

import Colocviu.Ex1.Interfaces.PlaceHandlerTemplate;
import Colocviu.Ex1.Interfaces.PlaceTemplate;
import Colocviu.Ex1.Interfaces.TransitionTemplate;

public class Controller extends Thread{
    static boolean stop = false;
    PlaceHandler PH = new PlaceHandler();
    public Process p;

    Float initial = Float.valueOf(1);

    Controller_Transition_t0 t0;
    Controller_Transition_t1 t1;
    Controller_Transition_t2 t2;
    Controller_Transition_t3 t3;
    Controller_Transition_t6 t6;
    Controller_Transition_t4 t4;
    Controller_Transition_t5 t5;
    public void run(){
        PH.AddPlace(new IntPlace("p_0",initial));
        PH.AddPlace(new IntPlace("p_1",null));
        PH.AddPlace(new IntPlace("p_2",null));
        PH.AddPlace(new IntPlace("p_3",null));
        PH.AddPlace(new IntPlace("p_23",null));
        PH.AddPlace(new IntPlace("p_24",null));
        PH.AddPlace(new IntPlace("p_6",null));
        PH.AddPlace(new IntPlace("p_10",initial));
        PH.AddPlace(new IntPlace("p_4",null));
        PH.AddPlace(new IntPlace("p_5",null));

        t0=new Controller_Transition_t0("t_0",PH,0);
        t1=new Controller_Transition_t1("t_1",PH,0);
        t2=new Controller_Transition_t2("t_2",PH,0);
        t3=new Controller_Transition_t3("t_3",PH,0);
        t4=new Controller_Transition_t4("t_4",PH,0);
        t5=new Controller_Transition_t5("t_5",PH,0);
        t6=new Controller_Transition_t6("t_6",PH,0);



        while(!stop){
            t0.TransitionGuardsMappings();
            t1.TransitionGuardsMappings();
            t2.TransitionGuardsMappings();
            t3.TransitionGuardsMappings();
            t4.TransitionGuardsMappings();
            t5.TransitionGuardsMappings();
            t6.TransitionGuardsMappings();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Controller_Transition_t1 implements TransitionTemplate{

    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Controller_Transition_t1(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Controller_Transition_t1(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH=PH;
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
        String toPrint="--------------Controller-------------------\n";
        if(!PH.GetPlaceByName("p_1").IsNull()){
            PH.GetPlaceByName("p_3").Set((Float) PH.GetPlaceByName("p_1").Get());
            PH.GetPlaceByName("p_1").Set(null);

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

class Controller_Transition_t0 implements TransitionTemplate{

    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Controller_Transition_t0(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Controller_Transition_t0(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH=PH;
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
        String toPrint="--------------Controller-------------------\n";
        if(!PH.GetPlaceByName("p_0").IsNull()){
            PH.GetPlaceByName("p_1").Set((Float) PH.GetPlaceByName("p_0").Get());
            PH.GetPlaceByName("p_2").Set((Float) PH.GetPlaceByName("p_0").Get());
            PH.GetPlaceByName("p_0").Set(null);

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

class Controller_Transition_t2 implements TransitionTemplate{

    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Controller_Transition_t2(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Controller_Transition_t2(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH=PH;
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
        String toPrint="--------------Controller-------------------\n";
        if(!PH.GetPlaceByName("p_2").IsNull() && !PH.GetPlaceByName("p_10").IsNull()){
            PH.GetPlaceByName("p_4").Set((Float) PH.GetPlaceByName("p_2").Get() + (Float) PH.GetPlaceByName("p_10").Get());
            PH.GetPlaceByName("p_2").Set(null);

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

class Controller_Transition_t3 implements TransitionTemplate{

    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Controller_Transition_t3(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Controller_Transition_t3(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH=PH;
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
        String toPrint="--------------Controller-------------------\n";
        if(!PH.GetPlaceByName("p_3").IsNull() && !PH.GetPlaceByName("p_23").IsNull()){
            PH.GetPlaceByName("p_6").Set((Float) PH.GetPlaceByName("p_3").Get() + (Float) PH.GetPlaceByName("p_23").Get());
            PH.GetPlaceByName("p_24").Set((Float) PH.GetPlaceByName("p_3").Get() + (Float) PH.GetPlaceByName("p_23").Get());
            PH.GetPlaceByName("p_3").Set(null);
            PH.GetPlaceByName("p_23").Set(null);

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

class Controller_Transition_t6 implements TransitionTemplate{

    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Controller_Transition_t6(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Controller_Transition_t6(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH=PH;
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
        String toPrint="--------------Controller-------------------\n";
        if(!PH.GetPlaceByName("p_6").IsNull()){
            PH.GetPlaceByName("p_1").Set((Float) PH.GetPlaceByName("p_6").Get());
            PH.GetPlaceByName("p_6").Set(null);

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

class Controller_Transition_t4 implements TransitionTemplate{

    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Controller_Transition_t4(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Controller_Transition_t4(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH=PH;
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
        String toPrint="--------------Controller-------------------\n";
        if(!PH.GetPlaceByName("p_4").IsNull()){
            PH.GetPlaceByName("p_5").Set((Float) PH.GetPlaceByName("p_4").Get());
            PH.GetPlaceByName("p_6").Set(null);

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

class Controller_Transition_t5 implements TransitionTemplate{

    String Name;
    PlaceHandlerTemplate PH;

    Integer sleepValue, eet, let;

    public Controller_Transition_t5(String Name, PlaceHandlerTemplate PH, int sleepValue){
        this.Init(Name,PH);
        this.SetDelay(sleepValue);
    }

    public Controller_Transition_t5(String Name, PlaceHandlerTemplate PH, int eet, int let){
        this.Init(Name,PH);
        this.SetDelayInRange(eet,let);
    }

    @Override
    public void Init(String Name, PlaceHandlerTemplate PH) {
        this.Name=Name;
        this.PH=PH;
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
        String toPrint="--------------Controller-------------------\n";
        if(!PH.GetPlaceByName("p_5").IsNull()){
            PH.GetPlaceByName("p_2").Set((Float) PH.GetPlaceByName("p_5").Get());
            PH.GetPlaceByName("p_5").Set(null);

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