public class DepositReceipt extends Receipt{

    public DepositReceipt(int accountNumber){
        super(accountNumber);
    }
    public void receipt(double amount,Bank bank){
        System.out.println("********************************");
        System.out.println("    ATM DEPOSIT TRANSACTION");
        System.out.println("********************************");
        System.out.println("Date: "+date+" Time: "+time);
        System.out.println("Transaction ID: T##"+getId());
        System.out.println("Acc No: ACxxx"+getAccountNumber()%1000);
        System.out.println("--------------------------------");
        System.out.println("Available Balance: $"+(bank.getBalance(getAccountNumber())-amount));
        System.out.println("Deposited Amount : $"+amount);
        System.out.println("--------------------------------");
        System.out.println("Net Balance      : $"+bank.getBalance(getAccountNumber()));
        System.out.println("--------------------------------");
        System.out.println("       <--THANK YOU-->");
        System.out.println("********************************");

    }
}