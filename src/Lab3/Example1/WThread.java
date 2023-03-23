package Lab3.Example1;

import java.io.PrintWriter;
import java.util.Date;

public class WThread extends Thread {

    FileService service;
    PrintWriter out;
    public WThread(FileService service,PrintWriter out) {

        this.service = service;
        this.out=out;
    }

    public void run() {

        while (!Main.isStopThreads()) {

            String msg =

                    String.valueOf(Math.round(Math.random() * 100));

            synchronized(this){
                Date date = new Date(System.currentTimeMillis());
                out.println("Date: " + date);
                out.println("Message: " + msg);
                out.flush();
                notifyAll();
            }


            try {

                Thread.sleep(2000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }
}