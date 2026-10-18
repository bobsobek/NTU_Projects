
import java.util.Scanner;

public class Player{
    static final Scanner sc = new Scanner(System.in);

    public Player(){}
    public void WaiterOptions(Waiter waiter, DinningArea dinningArea){
        System.out.println("WAITER PLACEHOLDER");

        int waiterOption = sc.nextInt();
        boolean valid = false;

        while (!valid){
            switch (waiterOption) {
            case 0 ->   valid = waiter.do_nothing();
            case 1 ->   valid = waiter.seat_customer(dinningArea);
            case 2 ->   valid = waiter.take_order(dinningArea);
            case 3 ->   valid = waiter.serve_order(dinningArea);
            default -> System.out.println("Please input a valid option");
        }

        }
        


    }

    public void chefOptions(){}
}