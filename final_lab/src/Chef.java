
import java.util.Scanner;

public class Chef{
    Scanner chefSC = new Scanner(System.in);
    DinningArea dinningArea;

    public Chef(DinningArea dinningArea){
        this.dinningArea = dinningArea;
    }

    boolean printOrders(){
        int customers = dinningArea.getNumCustomers();
        if (customers == 0){
            System.out.println("<!> There are currently no customers");
            return false;
        }

        Customer[] occupiedSeats = dinningArea.getSeats();
        Order currOrder;
        System.out.printf("The are currently %d customer(s) \n", customers);
        System.out.println("--------------------------");
        for (int i = 0; i <  occupiedSeats.length; i++) {
            if (occupiedSeats[i] != null){
                currOrder = occupiedSeats[i].currOrder;
                if (currOrder != null){

                    if ( !currOrder.getCompleted()){
                        System.out.printf("Order at table number %d \n",i);
                        System.out.println("Name | Price | Prep Time");
                        currOrder.printOrder();
                        System.out.println("--------------------------");
                    }
                }

            }
        }
        return true;

    }

    boolean prepareFood(){
        if(!printOrders())
            return false;

        Customer[] occupiedSeats = dinningArea.getSeats();
        
        
        // there are orders and we have printed them
        Order currOrder;
        while (true){
            System.out.println("Which table would you like prepare: ");
            int option = chefSC.nextInt();

            if (option > 6){
                System.out.println("<!> Invalid seat number");
            }

            else if (option < 0){
                System.out.println("Exiting...");
                return false;
            }

            else{
                currOrder = occupiedSeats[option].currOrder;
                if (currOrder != null){
                    if (!currOrder.getCompleted()){
                        currOrder.prepare();
                        return true;
                    }

                }
                System.out.println("<!> Invalid seat number");
            }
            System.out.println();
        }
    }

    boolean doNothing() {return true;}

    public void chefOptions(){
        boolean valid = false;
        int chefOption;

        while (!valid){
            System.out.println("""
                    Chef's Turn:
                    1: Do nothing
                    2: Prepare Order
                    """);
            chefOption= chefSC.nextInt();
            switch (chefOption) {
            case 1 ->   valid = this.doNothing();
            case 2 ->   valid = this.prepareFood();
            default -> System.out.println("Please input a valid option");
        }
        System.out.println();
        }
    }
}