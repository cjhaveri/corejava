package test.cjhaveri.corejava.concurrency;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by chetanjhaveri on 6/5/17.
 */
public class Producer extends Thread{

    private LinkedBlockingDeque<Job> queue;

    Producer(LinkedBlockingDeque<Job> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i=0; i < 10; i++) {
            Job producing = new Job();
            try {

                queue.put(producing);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
