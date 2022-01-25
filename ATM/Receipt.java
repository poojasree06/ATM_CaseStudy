import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Receipt {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    LocalTime t = LocalTime.now();
    DateTimeFormatter f_time = DateTimeFormatter.ofPattern("HH:mm:ss");
    String date = simpleDateFormat.format(new Date());
    String time = t.format(f_time);
    private static int id=0;
    private int accountNumber;
    public Receipt(int accountNumber){
        id++;
        this.accountNumber=accountNumber;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    public int getId(){
        return id;
    }
    public void balance(Bank bank){
        double balance=bank.getBalance(getAccountNumber());
        System.out.println("********************************");
        System.out.println("Balance Information: ");
        System.out.println("Date: "+date+" Time: "+time);
        System.out.println("Transaction ID: T##"+getId());
        System.out.println("Account No: ACxxx"+getAccountNumber()%1000);
        System.out.println("Available Balance - $"+balance);
        System.out.println("********************************");
    }
    public abstract void receipt(double depositAmount, Bank bank);

}
