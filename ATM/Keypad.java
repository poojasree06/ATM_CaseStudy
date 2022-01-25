import java.util.Scanner;

public class Keypad {
    Scanner input=new Scanner(System.in);
    public void keypad(){
        System.out.println("-------------------");
        System.out.println("|  1  |  2  |  3  |");
        System.out.println("-------------------");
        System.out.println("|  4  |  5  |  6  |");
        System.out.println("-------------------");
        System.out.println("|  7  |  8  |  9  |");
        System.out.println("-------------------");
        System.out.println("|  0  |    ENTER  |");
        System.out.println("-------------------");
    }

    public int getInt(){
        keypad();
        return input.nextInt();
    }

    public String getString(){
        return input.next();
    }

    public long getMobile(){
        keypad();
        return input.nextLong();
    }
}
