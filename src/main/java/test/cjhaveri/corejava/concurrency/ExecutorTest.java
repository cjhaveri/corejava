package test.cjhaveri.corejava.concurrency;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Demo to just give all the java.util.Concurrent package a shot to explore the features
 * Silly service that just prints the states using some skip iterator
 * Uses a thread executor to print the states
 * While printing the states, printout the thread id, invocation number and the actual state (based on the skip)
 *
 */
public class ExecutorTest implements Callable<States> {

    private List<String> toProcess;
    private int skipNumber;
    private int invocationCount;

    private static Semaphore semaphore = new Semaphore(2, true);

    public static void main(String[] args) {

        int MAX_THREADS = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        List<String> states = Arrays.asList("CA", "NV", "DC", "IL", "WA", "NA", "NH", "AK");


        for (int i = 0; i < 10; i++) {
            System.out.println("Submitting invocation: " + i);
            executorService.submit(new ExecutorTest(states, i));
        }
        executorService.shutdown();
    }


    public ExecutorTest(List<String> states, int skipNumber) {
        this.toProcess = states;
        this.skipNumber = skipNumber;
        this.invocationCount = skipNumber;
        System.out.println("Available semaphores: " + semaphore.availablePermits());
    }


    @Override
    public States call() throws Exception {

        System.out.println("Processing thread id: " + Thread.currentThread().getId());
        States a = new States(toProcess, skipNumber);

        System.out.println(Thread.currentThread().getId() + ": Acquring Sempahore") ;
        semaphore.acquire();
        System.out.println(Thread.currentThread().getId() + ": Acquired Semaphore, Available: " + semaphore.availablePermits() );

        Iterator i = a.iterator();
        while (i.hasNext()) {
            System.out.println(Thread.currentThread().getId() +":" + invocationCount +":"+i.next());
        }
        semaphore.release();
        System.out.println(Thread.currentThread().getId() + ": Releasing semaphore");
        return a;

    }
}
