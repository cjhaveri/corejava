package test.cjhaveri.experiments;


import java.sql.Timestamp;

/**
 * Created by chetanjhaveri on 10/13/16.
 */
public class NanoTime {

    public static void main(String[] args) {

        for (int i=0; i < 100000; i++) {

            long currentTime = System.nanoTime();
            Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
            ts.setNanos((int) (currentTime % 1000000000));
            System.out.println(ts.toString());
        }
    }
}
