package wait_and_notify;

import java.util.Scanner;

public class Processor {
    public void produce() throws InterruptedException
    {
        synchronized (this){
            System.out.println("Producer thread running...");
            wait(); 
            //jumps to line no.17
            System.out.println("Resumed...");
        }
    }
    public void consume() throws InterruptedException
    {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this) {
            System.out.println("Waiting for the return key...");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            //return the control to line no.11
            Thread.sleep(5000);
            scanner.close();
        } 
    }
}