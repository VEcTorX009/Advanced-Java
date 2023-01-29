package Synchronized_keyword;
public class App {
    private int count = 0;

    public synchronized void increment()
    /* every object in java has an intrinsic log to which
     is stated by a call method at a time. here two threads
     are using the same method at the same time which changes
     the original value of the given parameter at the time their 
     executed (at different times, different value gets changed)
     synchornized keyworc prevents this by revealing intrinsic log
     to a method or thread at a time and allows only one use at the time
     and at that time the other method seem to be waiting for milli seconds
     this doesnt changed the original value of the variable :D*/
    {
        count ++;
    }
    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }
    public void doWork()
    {
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                for(int i =0; i<10000; i++)
                {
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                for(int i =0; i<10000; i++)
                {
                    increment();
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is:" + count);
    }
    
}
