package Semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {
        Connection.getInstan().connect();

        ExecutorService executor = Executors.newCachedThreadPool();
        /*ExecutorService newCachedThreadPool() Creates a thread pool that creates new 
        threads as needed, but will reuse previously constructed threads when they are 
        available*/
        for(int i =0; i<100; i++)
        {
            executor.submit(new Runnable() {
                public void run ()
                {
                    Connection.getInstan().connect();
                }
            });
       }
       executor.shutdown();

       executor.awaitTermination(1, TimeUnit.DAYS);
    }
}