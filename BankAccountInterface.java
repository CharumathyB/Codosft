package AtmInterface;
public interface BankAccountInterface {
    double getBalance();
    void deposit(double amount);
    boolean withdraw(double amount);
}
