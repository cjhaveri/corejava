package test.cjhaveri.corejava.concurrency;

/**
 * Created by chetanjhaveri on 6/5/17.
 */
public class Job {


    int start = 0;

    public void doJob(int sleepAmount) {
        try {
            Thread.sleep(sleepAmount * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
