package Lab3.Example3;

class JoinTestThread extends Thread{

    Thread t;

    JoinTestThread(String n, Thread t){

        this.setName(n);

        this.t=t;

    }

    public void run() {

        System.out.println("Thread "+this.getName()+" has entered the run() method");

        try {

            if (t != null) t.join();

            System.out.println("Thread "+this.getName()+" executing operation.");

            Thread.sleep(3000);

            System.out.println("Thread "+this.getName()+" has terminated operation.");

        }

        catch(Exception e){e.printStackTrace();}

    }

}

public class Main {

    public static void main(String[] args){

        JoinTestThread w1 = new JoinTestThread("Thread 1",null);

        JoinTestThread w2 = new JoinTestThread("Thread 2",w1);

        w1.start();

        w2.start();

    }

}
