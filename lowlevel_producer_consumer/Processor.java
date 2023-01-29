package lowlevel_producer_consumer;

import java.util.LinkedList;
import java.util.Random;

public class Processor {
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();//sup spider
    
    public void produce() throws InterruptedException
    {
        int value = 0;

        while(true)
        {
            synchronized (lock)
            {
                while(list.size() == LIMIT) {
                    list.wait(); /*threads gonna wait till the size reaches the limit
                    */ 
                }
            list.add(value++);//this will work when the thread's waiting
            lock.notify();
        }
    }
    }
    public void consume() throws InterruptedException
    {
        Random random = new Random();
        
        while(true)
        {
            synchronized(lock)
            {
                while(list.size() == 0)
                {
                    lock.wait();
                }
                
            System.out.println("List size is  " + list.size());
            int value = list.removeFirst(); /*now this will remove the first character
            of the list*/
            System.out.println("; value is " + value);
            lock.notify();//now its going to notify only ONE thread
            }
            Thread.sleep(random.nextInt(1000));
        }
    }
}