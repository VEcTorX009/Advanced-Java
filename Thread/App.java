package Thread;
class Runner extends Thread {
    public void run()
    {
        for(int i =0; i<=10; i++)
        {
            System.out.println("Hello" + i);
         try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
    
}
public class App 
{
    public static void main(String[] args) {
        Runner runners = new Runner();
        runners.start(); 
        //start tells the computer to look for the main method 
    }
}