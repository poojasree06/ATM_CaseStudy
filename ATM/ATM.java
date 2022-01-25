import java.util.ArrayList;

public class ATM {
    public Keypad keypad;
    public int accountNumber;
    public Bank bank;  //information about users
    public boolean check;
    private ArrayList<Transaction> t;
    private final static int CANCELED = 6;
    public ATM(){
        this.bank=new Bank();
        this.keypad=new Keypad();
        this.check=false;
        this.accountNumber=0;
        this.t=new ArrayList<>();
    }
    public void menu(){
        while (true){
            System.out.println("Welcome !");
            while (!check){
                accountDetails();
            }
            transactions();
            check=false;
            this.accountNumber=0;
            System.out.println("THANK YOU ! GOODBYE!\n");
        }
    }
    public void accountDetails(){
        System.out.println("Please, Enter your Account Number: ");
        int acc_number=keypad.getInt();
        System.out.println("Enter your PIN: ");
        int pin=keypad.getInt();
        check=bank.verification(acc_number,pin);
        if(check){
            accountNumber=acc_number;
        }
        else{
            System.out.println("Invalid Account Number or PIN, Please try again...");
        }
    }
    private void setPIN(){
        bank.PIN(accountNumber);
    }

    private int displayMenu(){
        System.out.println("\nMainMenu:");
        System.out.println("1-View Balance");
        System.out.println("2-Cash Withdrawal");
        System.out.println("3-Cash Deposit");
        System.out.println("4-changePIN");
        System.out.println("5-Exit\n");
        System.out.println("Enter your Choice: ");
        int c=keypad.getInt();
        if (c == CANCELED) {
            return CANCELED;
        } else{
            return c;
        }
    }
    private void transactions(){
        Transaction transaction=null;
        boolean exit=false;
        while (!exit){
            int choice=displayMenu();
            switch (choice){
                case 1:
                    transaction=new Balance(accountNumber,bank);
                    transaction.perform();
                    t.add(transaction);
                    break;
                case 2:
                    transaction=new Withdrawal(accountNumber,bank);
                    transaction.perform();
                    t.add(transaction);
                    break;
                case 3:
                    transaction=new Deposit(accountNumber,bank);
                    transaction.perform();
                    t.add(transaction);
                    break;
                case 4:
                    setPIN();
                    break;
                case 5:
                    exit=true;
                    break;
                default:
                    System.out.println("Enter a valid choice, Please Try Again...");
                    break;
            }
        }
    }
}
