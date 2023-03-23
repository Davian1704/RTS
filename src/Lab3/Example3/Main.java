package Lab3.Example3;

class JoinTestThread extends Thread{

    Thread t;
    int number;
    static int result;

    JoinTestThread(String n, Thread t, int number){

        this.setName(n);
        this.number=number;
        this.t=t;

    }

    public void run() {

        System.out.println("Thread "+this.getName()+" has entered the run() method");

        try {

            if (t != null) t.join();

            System.out.println("Thread "+this.getName()+" executing operation.");

            for(int i=1;i<=number;i++){
                if(number % i ==0)
                    result+=i;
            }

            Thread.sleep(3000);

            System.out.println("Thread "+this.getName()+" has terminated operation.");
            if(t!=null) System.out.println(result);
        }

        catch(Exception e){e.printStackTrace();}

    }

}

public class Main {

    public static void main(String[] args){

        JoinTestThread w1 = new JoinTestThread("Thread 1",null,2);

        JoinTestThread w2 = new JoinTestThread("Thread 2",w1,4);

        w1.start();

        w2.start();

    }

}
