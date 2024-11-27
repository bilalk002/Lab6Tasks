public class JointAccountTest {
    public static void main(String[] args) {
        JointAccount account = new JointAccount();
        AccountHolder userA = new AccountHolder(account, "User A", 45000);
        AccountHolder userB = new AccountHolder(account, "User B", 20000);

        userA.start();
        userB.start();
    }
}
