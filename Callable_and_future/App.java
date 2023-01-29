package Callable_and_future;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        // Executor- An object that executes submitted Runnable tasks.
        /*
         * The Java ExecutorService is the interface which allows us
         * to execute tasks on threads asynchronously
         */
        /*
         * Runnable is an interface that is to be implemented by a
         * class whose instances are intended to be executed by a thread.
         */
        /*
         * Callable , represents an asynchronous task which can be
         * executed by a separate thread. For instance, it is possible
         * to submit a Callable object to a Java ExecutorService which will
         * then execute it asynchronously.
         */

        Future<?> future = executor.submit(new Callable<Void>() {

            /*
             * A Java Future, java. ... Future , represents the result of an asynchronous
             * computation.
             * When the asynchronous task is created, a Java Future object is returned. This
             * Future
             * object functions as a handle to the result of the asynchronous task.
             */

            /*
             * The Callable object returns a Future object which
             * provides methods to monitor the progress of a task being
             * executed by a thread. ... The future object can be used
             * to check the status of a Callable and then retrieve
             * the result from the Callable once the thread is done.
             */

            @Override
            public Void call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt(4000);

                if (duration > 2000) {
                    throw new IOException("Sleeping for too long..");
                    // this is io exception so itll look for the catch block which is in line no.65
                }

                System.out.println("Starting ....");

                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Finished...");

                return null;
            }

        });

        executor.shutdown();

        try {
            System.out.println("Result is : " + future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            IOException ex = (IOException) e.getCause();

            System.out.println(ex.getMessage());
        }
    }
}
