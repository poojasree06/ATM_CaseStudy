public class Balance extends Transaction {

    public Balance(int accountNumber,Bank bank) {
        super(accountNumber,bank);
    }

    @Override
    public void perform() {
        System.out.println("********************************");
        System.out.println("Balance Information: ");
        System.out.println("Account No: ACxxx"+getAccountNumber()%1000);
        System.out.println("Available Balance - $"+getBank().getBalance(getAccountNumber()));
        System.out.println("********************************");
    }
    public String getName() {
        return "Balance";
    }
}

