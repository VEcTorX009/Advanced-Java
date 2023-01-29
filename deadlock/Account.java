package deadlock;

public class Account {
    private int balance = 1000;

    public void depoit(int amount)
    {
        balance +=amount;
    }
    public void withdraw(int amount)
    {
        balance-=amount;
    }
    public int getBalance()
    {
        return balance;
    }
    public static void transfer(Account acc1, Account acc2, int amount)
    {
        acc1.depoit(amount);
        acc2.depoit(amount);
    }
}