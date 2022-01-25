import java.util.Scanner;

public class Withdrawal extends Transaction {
    private Scanner input=new Scanner(System.in);
    private double withdrawAmount;
    private final static int CANCELED = 0;
    public Withdrawal(int accountNumber,Bank bank){
        super(accountNumber,bank);
    }

    private double displayAmounts() {
        System.out.println("[?] Please enter a withdrawal amount \n" +
                "    (or 0 to cancel): ");
        System.out.println("Enter amount : ");
        int c=input.nextInt(); // receive input of deposit amount
        if (c == CANCELED) {
            return CANCELED;
        } else {
            return (double) c;
        }
    }
    @Override
    public void perform(){
        boolean cashDispensed = false;
        double availableBalance;
        do {
            // obtain a chosen withdrawal amount from the user
            withdrawAmount = displayAmounts();
            // check whether user chose a withdrawal amount or canceled
            if (withdrawAmount != CANCELED) {
                availableBalance = getBank().getBalance(getAccountNumber());
                if(withdrawAmount<10000)
                    if (withdrawAmount <= availableBalance) {
                        if (getDispenser().isSufficientCashAvailable(withdrawAmount)) {
                            getBank().setBalance(getAccountNumber(), availableBalance - withdrawAmount);
                            getDispenser().dispenseCash(withdrawAmount);
                            cashDispensed = true;
                            System.out.println("Your cash has been dispensed.\n" +
                                    "    Please take your cash now.");
                            getDispenser().dispenseCash(withdrawAmount);
                            Receipt withdrawReceipt = new WithdrawReceipt(getAccountNumber());
                            withdrawReceipt.receipt(withdrawAmount, getBank());
                            getDispenser().display();
                        }
                        else { // cash dispenser does not have enough cash
                            System.out.println("Insufficient cash available in the ATM.\n" +
                                    "    Please choose a smaller amount.\n");
                        }
                    }
                    else { // not enough money available in user's account
                        System.out.println("[!] Insufficient funds in your account!\n" +
                                "    Please choose a smaller amount.\n");
                    }
                else{
                    System.out.println("Sorry, you cannot withdraw greater than 10000 at a time\n"+"  " +
                            "Please choose a smaller amount\n");
                }
                //
            }
            else { // user chose cancel menu option
                System.out.println("[~] Canceling transaction...");
                return;
            }
        } while (!cashDispensed);
    }
    @Override
    public String getName() {
        return "Withdrawal";
    }
}

