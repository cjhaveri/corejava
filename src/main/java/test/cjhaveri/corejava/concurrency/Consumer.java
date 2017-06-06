package test.cjhaveri.corejava.concurrency;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by chetanjhaveri on 6/5/17.
 */
public class Consumer extends Thread {

    private int consumerThreadId;
    
    private LinkedBlockingDeque<Job> queue;

    private boolean canDie = false;
    
    public void setCanDie(boolean canDie) {
        this.canDie = canDie;
    }

    public Consumer(LinkedBlockingDeque<Job> queue, int consumerThreadId) {
        this.queue = queue;
        this.consumerThreadId = consumerThreadId;
    }

    @Override
    public void run() {

        int totalSleeps = 0;
        while (!canDie) {
            try {
                Job taken = queue.poll(4, TimeUnit.SECONDS);
                if (taken != null) {
                    System.out.println("Thread id: " + consumerThreadId + ", got job");
                    taken.doJob(4);

                } else {
                    totalSleeps ++;
                    if (totalSleeps == 4) {
                        canDie = true;
                        System.out.println("Thread id: " + consumerThreadId + " can die");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();

            }

        }
    }
}
