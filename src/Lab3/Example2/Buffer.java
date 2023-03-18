package Lab3.Example2;

import java.util.ArrayList;

class Buffer {

    ArrayList<Double> content = new ArrayList<Double>();

    synchronized void put(double d) {

        content.add(new Double(d));

        notify();

    }

    synchronized double get() {

        double d = -1;

        try {

            if (content.size() == 0) wait();

            d = (content.get(0)).doubleValue();

            content.remove(0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return d;

    }
}
