public class JointAccount {
 private int balance = 50000;

    synchronized void withdraw(String user, int amount) {
        System.out.println(user + " is trying to withdraw " + amount + "...");
        if (balance < amount) {
            System.out.println("Insufficient balance for " + user + ". Waiting for deposit...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println(user + " successfully withdrew " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println("Transaction failed for " + user + ". Insufficient balance.");
        }
    }

    synchronized void deposit(String user, int amount) {
        System.out.println(user + " is depositing " + amount + "...");
        balance += amount;
        System.out.println(user + " successfully deposited " + amount + ". Current balance: " + balance);
        notifyAll();
    }
}   

