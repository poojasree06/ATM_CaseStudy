

public class CashDispenser {

    private final static int NET_CASH = 50000;
    private int cash;
    int[] rupees = { 2000,1000, 500, 100, 50 };
    int[] count = { 0, 0, 0, 0 ,0};
    public CashDispenser(){
        cash=NET_CASH;
    }
    public void dispenseCash(double amount){
        cash-=amount;
        for (int i = 0; i < rupees.length; i++) {
            if (rupees[i] < amount || rupees[i] == amount) {
                count[i] = (int) (amount / rupees[i]);
                amount = amount % rupees[i];
            }
        }
    }
    public void display(){
        System.out.println("\nSummmary ");
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.println(rupees[i] + " * " + count[i] + " = " + (rupees[i] * count[i]));
            }
        }
    }
    public boolean isSufficientCashAvailable(double amount){
        if(amount<=cash)
            return true;
        else
            return false;
    }
    public void setCash(double amount){
        cash+=amount;
    }
}

