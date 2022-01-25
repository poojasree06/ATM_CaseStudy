import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private Scanner input=new Scanner(System.in);
    private ArrayList<Customer> customers;
    public Bank(){
        this.customers=new ArrayList<>();
        this.customers.add(new Customer("pooja",123245,2334,12000,8247800018l));
        this.customers.add(new Customer("ravi",678901,1224,50000,9849978540l));
        this.customers.add(new Customer("john",234245,5648,20000,7847807818l));
        this.customers.add(new Customer("danes",456790,8764,30000,9849453540l));

    }

    private Customer getAccount(int accountNumber){
        for(int i=0;i<2;i++){
            if(customers.get(i).getAccountNumber() == accountNumber){
                return customers.get(i);
            }
        }
        return null;
    }

    public boolean verification(int accountNumber,int PIN){
        Customer account = getAccount(accountNumber);
        if(account!=null){
            return account.checkPIN(PIN);
        }
        else{
            return false;
        }
    }
    public double getBalance(int accountNumber){
        return getAccount(accountNumber).getBalance();
    }

    public void setBalance(int accountNumber,double amount){
        getAccount(accountNumber).setBalance(amount);
    }
    public void credit(int userAccountNumber, double amount) {
        getAccount(userAccountNumber).credit(amount);
    }
    public void newCustomer(){
        System.out.print("Enter name: ");
        String name=input.next();
        System.out.print("Enter account number: ");
        int number=input.nextInt();
        System.out.print("Enter PIN: ");
        int pin=input.nextInt();
        System.out.print("Enter mobile number linked to account: ");
        long mobile=input.nextLong();
        System.out.println("Enter amount: ");
        double amount=input.nextDouble();
        Customer c=new Customer(name,number,pin,amount,mobile);
        this.customers.add(c);
    }
    public void PIN(int accountNumber){
        Customer c=getAccount(accountNumber);

        c.changePIN(c);
    }
}
