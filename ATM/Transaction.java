public abstract class Transaction {
    private int accountNumber;
    private Bank bank;
    private CashDispenser dispenser=new CashDispenser();
    public Transaction(int accountNumber,Bank bank){
        this.accountNumber=accountNumber;
        this.bank=bank;

    }
    protected int getAccountNumber() {
        return accountNumber;
    }

    protected Bank getBank() {
        return bank;
    }

    public CashDispenser getDispenser() {
        return dispenser;
    }

    public abstract void perform();
    public abstract String getName();
}
