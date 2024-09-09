package AtmInterface;
public class ATMInterfaceMain {
    public static void main(String[] args) {
        BankAccountInterface userAccount = new BankAccount(100000);
        ATMInterface atm = new ATM(userAccount);
        atm.start();
    }
}