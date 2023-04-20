package Lab5.App2;

import java.util.concurrent.Semaphore;

class Fir extends Thread {
    int name, delay, k, permit;
    Semaphore s;

    Fir(int n, Semaphore sa, int delay, int k, int permit) {
        this.name = n;
        this.s = sa;
        this.delay = delay;
        this.k = k;
        this.permit = permit;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Fir " + name +" State 1");
                Thread.sleep(this.delay * 500);
                System.out.println("Fir " + name +" State 2");
                this.s.acquire(this.permit); // critical region
                System.out.println("Fir " + name + " took a token from the semaphore");
                System.out.println("Fir " + name +" State 3");
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                this.s.release(); // end of critical region
                System.out.println("Fir " + name + " released a token from the semaphore");
                System.out.println("Fir " + name +" State 4");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Semaphore s = new Semaphore(4);
        Fir f1, f2;
        f1 = new Fir(1, s, 2, (int) Math.round(Math.random() * 3 + 2), 2);
        f2 = new Fir(2, s, 4, (int) Math.round(Math.random() * 3 + 3), 1);
        f1.start();
        f2.start();
    }
}

