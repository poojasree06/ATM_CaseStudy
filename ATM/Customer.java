import java.util.Scanner;

public class Customer  {
    private Scanner input=new Scanner(System.in);
    private String name;
    private long mobile;
    private double balance;
    private int accountNumber;
    private int PIN;
    private final static int CANCELED = 0;
    public Customer(String name,int accountNumber,int PIN,double balance,long mobile){
        this.name=name;
        this.mobile=mobile;
        this.accountNumber=accountNumber;
        this.PIN=PIN;
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void credit(double amount) {
        balance += amount;
    }
    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPIN() {
        return PIN;
    }

    public boolean checkPIN(int PIN){
        return getPIN() == PIN;
    }

    public void setPIN(int PIN){
        this.PIN=PIN;
    }

    public void changePIN(Customer c){
        System.out.println("[?] Please enter your old PIN \n" +
                "    (or 0 to cancel): ");
        int op=input.nextInt();
        if(op==CANCELED){
            System.out.println("Back to  MainMenu...");
        }
        else {
            if (checkPIN(c.getPIN())) {
                System.out.print("Enter new PIN: ");
                int np = input.nextInt();
                c.setPIN(np);
                System.out.println("Successfully new PIN was created");
            }
            else
            {
                System.out.println("Wrong PIN,enter correctly...");
            }
        }
    }
}
