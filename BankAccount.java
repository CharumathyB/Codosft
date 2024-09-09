package AtmInterface;
public class BankAccount implements BankAccountInterface {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
