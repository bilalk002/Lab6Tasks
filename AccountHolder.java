public class AccountHolder extends Thread {
     private JointAccount account;
    private String user;
    private int amount;

    AccountHolder(JointAccount account, String user, int amount) {
        this.account = account;
        this.user = user;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(user, amount);
    }
}



