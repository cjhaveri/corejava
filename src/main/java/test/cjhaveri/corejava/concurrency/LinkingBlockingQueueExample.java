package test.cjhaveri.corejava.concurrency;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by chetanjhaveri on 6/5/17.
 */
public class LinkingBlockingQueueExample {





    public static void main(String[] args) {

        LinkedBlockingDeque<Job> queue = new LinkedBlockingDeque<>(10);

        Consumer [] consumers = new Consumer[4] ;

        for (int i=0; i < consumers.length; i++) {
            consumers[i] = new Consumer(queue, i);
        }

        Producer producer = new Producer(queue);

        producer.start();
        for (int i=0; i < consumers.length; i++) {
            consumers[i].start();
        }



        
    }
}
