package Lab4.App1;

public class ExecutionThread extends Thread {
    Integer monitor1,monitor2;
    int sleepvalue, activity_max,activity_min;

    public ExecutionThread(Integer monitor1, Integer monitor2, int sleepvalue,int activity_min,int activity_max){
        this.monitor1=monitor1;
        this.monitor2=monitor2;
        this.sleepvalue=sleepvalue;
        this.activity_min=activity_min;
        this.activity_max=activity_max;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        if (monitor1 != null) {
            synchronized (monitor1) {
                if (monitor2 != null) {
                    synchronized (monitor2) {
                        System.out.println(this.getName() + " - STATE 2");
                        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                        for (int i = 0; i < k * 100000; i++) {
                            i++;
                            i--;
                        }

                    }
                    try {
                        Thread.sleep(Math.round((Math.random() * sleepvalue)) * 500);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(this.getName() + " - STATE 3");
                } else {
                    System.out.println(this.getName() + " - STATE 2");
                    int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                    for (int i = 0; i < k * 100000; i++) {
                        i++;
                        i--;
                    }
                    try {
                        Thread.sleep(Math.round((Math.random() * sleepvalue)) * 500);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(this.getName() + " - STATE 3");
                }
            }
        } else {
            if (monitor2 != null) {
                synchronized (monitor2) {
                    if (monitor1 != null) {
                        synchronized (monitor1) {
                            System.out.println(this.getName() + " - STATE 2");
                            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                            for (int i = 0; i < k * 100000; i++) {
                                i++;
                                i--;
                            }

                        }
                        try {
                            Thread.sleep(Math.round((Math.random() * sleepvalue)) * 500);

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println(this.getName() + " - STATE 3");
                    } else {
                        System.out.println(this.getName() + " - STATE 2");
                        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                        for (int i = 0; i < k * 100000; i++) {
                            i++;
                            i--;
                        }
                        try {
                            Thread.sleep(Math.round((Math.random() * sleepvalue)) * 500);

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.out.println(this.getName() + " - STATE 3");
                    }
                }
            }

        }
    }
}
