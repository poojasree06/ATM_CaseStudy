import java.util.Scanner;

public class Deposit extends Transaction {
    private Scanner input=new Scanner(System.in);
    private double depositAmount;
    private final static int CANCELED = 0; // constant for cancel option
    public Deposit(int accountNumber,Bank bank) {
        super(accountNumber,bank);
    }
    private double depositPrompt() {
        System.out.println("[?] Please enter a deposit amount \n" +
                "    (or 0 to cancel): ");
        System.out.println("Enter depositing amount : ");
        int c=input.nextInt(); // receive input of deposit amount
        // check whether the user canceled or entered a valid amount
        if (c == CANCELED) {
            return CANCELED;
        } else {
            return (double) c;
        }
    }
    @Override
    public void perform() {
        Bank bank = getBank();
        depositAmount = depositPrompt(); // get deposit amount from user
        // check whether user entered a deposit amount or canceled
        if (depositAmount != CANCELED) {
            System.out.println("Your deposit is being processed...");
            bank.credit(getAccountNumber(), depositAmount);
            getDispenser().setCash(depositAmount);
            Receipt depositReceipt=new DepositReceipt(getAccountNumber());
            depositReceipt.receipt(depositAmount,getBank());
        } else {
            System.out.println("[~] Canceling transaction...");
        }
    }
    public String getName() {
        return "Deposit";
    }
}
