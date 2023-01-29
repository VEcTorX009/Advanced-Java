package re_entrant_locks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    private int count = 0;

    private Lock lock = new ReentrantLock(); /*
                                              * ReentrantLock allows threads to enter
                                              * into the lock on a resource more than once
                                              */
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();

        System.out.println("waiting..");

        cond.await(); // just like lock but right now in this condition itunlocksthelock
        // now control moves to line no.41
        System.out.println("Woken up!");

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("Press the return key..");
        new Scanner(System.in).nextLine();
        System.out.println("Got it!");

        cond.signalAll(); // this wakes up all waiting threads.
        // this will move control to that thread in line no.23
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finished() {
        System.out.println("Count is: " + count);
    }
}
// IM STRESSED OUT MAN! @spiderlliot