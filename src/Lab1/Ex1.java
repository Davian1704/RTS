package Lab1;

public class Ex1 {
    private final float num1Re,num1Im,num2Re,num2Im;
    public Ex1(){
        this.num1Re=2;
        this.num1Im=5;
        this.num2Re=4;
        this.num2Im=-1;
    }
    public void sum(){
        System.out.println((num1Re+num2Re) + "+" + (num1Im+num2Im) + "i");
    }

    public void prod(){
        System.out.println((num1Re*num2Re - num1Im*num2Im) + "+" + (num1Re*num2Im + num1Im*num2Re) + "i");
    }
    static public void main(String[] args){
        Ex1 ex1 = new Ex1();
        ex1.sum();
        ex1.prod();
    }
}
