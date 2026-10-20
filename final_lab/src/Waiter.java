import java.util.Scanner;

public class Waiter{
    DinningArea dinningArea;

    public Waiter(DinningArea dinningArea){
        this.dinningArea = dinningArea;
    }

    private final Scanner waiterSC = new Scanner(System.in);

    boolean do_nothing(){
        System.out.println("The waiter is doing nothing \n");
        return true;
    }

    boolean seat_customer(){
        int queueLength = dinningArea.getQueueLength();
        System.out.printf("There are currently %d customers in queue \n \n", queueLength);
        if (queueLength == 0){
            return false;
        }

        int numFreeSeats = dinningArea.getNumFreeSeats();
        if (numFreeSeats == 0){
            System.out.println("<!> There are no free seats available");
            return false;
        }


        Customer[] occupiedSeats = dinningArea.getSeats();
        System.out.printf("The are currently %d available seats \n", numFreeSeats);
        for (int i = 0; i <  occupiedSeats.length; i++) {
            if (occupiedSeats[i] == null){
                System.out.printf("Table number %d \n",i);
            }
        }

        System.out.print("Where would you want to seat the customer: ");
        int option = waiterSC.nextInt();

        while (true){
            if (option > 6){
                System.out.println("<!> Invalid seat number");
            }

            else if (option < 0){
                System.out.println("Exiting...");
            }

            else{
                if (occupiedSeats[option] != null){
                    System.out.println("Seat is occupied");
                }

                else{
                    dinningArea.seatCustomer(option);
                    System.out.printf("Customer has been seated at seat %d \n \n", option);
                    return true;
                }
            }
        }
        
    }

    boolean take_order(){
        int customers = dinningArea.getNumCustomers();
        if (customers == 0){
            System.out.println("<!> There are currently no customers \n");
            return false;
        }

        Customer[] occupiedSeats = dinningArea.getSeats();
        System.out.printf("The are currently %d customers \n", customers);
        for (int i = 0; i <  occupiedSeats.length; i++) {
            if (occupiedSeats[i] != null){
                if (occupiedSeats[i].currOrder == null){
                    System.out.printf("Cusomter at table number %d \n",i);
                }
            }
        }


        while (true){
            System.out.print("Which table would you like to take the order of: ");
            int option = waiterSC.nextInt();
            if (option > 6){
                System.out.println("<!> Invalid seat number");
            }

            else if (option < 0){
                System.out.println("Exiting...");
            }

            else{
                if (occupiedSeats[option] == null){
                    System.out.println("<!> Seat is empty");
                }

                else if (occupiedSeats[option].currOrder != null){
                    System.out.println(" <!> Seat customer ordered already");
                }

                else{
                    occupiedSeats[option].orderItem(dinningArea.menu,1); // orders one item from the menu
                    System.out.println("Customer has placed their order");
                    return true;
                }
            }
        }
    }

    boolean serve_order(){
        int customers = dinningArea.getNumCustomers();
        if (customers == 0){
            System.out.println("<!> There are currently no customers");
            return false;
        }

        Customer[] occupiedSeats = dinningArea.getSeats();
        boolean completedOrder = false;
        for (int i = 0; i <  occupiedSeats.length; i++) {
            if (occupiedSeats[i] != null){
                if (occupiedSeats[i].currOrder.completed == true){
                    System.out.printf("Customer at table number %d ready to serve! \n",i);
                    completedOrder = true;
                }
            }
        }

        if (!completedOrder){
            System.out.println("<!> There are no complete orders");
            return false;
        }

        System.out.println("Which table would you like to take the order of");
        int option = waiterSC.nextInt();

        while (true){
            if (option > 6){
                System.out.println("<!> Invalid seat number");
            }

            else if (option < 0){
                System.out.println("Exiting...");
            }

            else{
                if (occupiedSeats[option] != null){
                    System.out.println("Seat is occupied");
                }

                else if (occupiedSeats[option].served != true){
                    System.out.println("Seat customer has been served");
                }

                
                else if (occupiedSeats[option].currOrder == null){
                    System.out.println("Customer has not ordered anything");
                }

                else if (!occupiedSeats[option].currOrder.getCompleted()){
                    System.out.println("Customer's order has not been completed");
                }

                else{
                    occupiedSeats[option].setServed();
                    System.out.println("Customer has been served \n");
                    return true;
                }
            }
            System.out.println();
        }
    }

    public void WaiterOptions(){
        boolean valid = false;
        int waiterOption;

        while (!valid){
            System.out.println("""
                               Waiter's Turn: 
                               1: Do nothing 
                               2: Seat Customer 
                               3: Take Order 
                               4: Serve Order
                               """);

            waiterOption = waiterSC.nextInt();
            
            switch (waiterOption) {
            case 1 ->   valid = this.do_nothing();
            case 2 ->   valid = this.seat_customer();
            case 3 ->   valid = this.take_order();
            case 4 ->   valid = this.serve_order();
            default -> System.out.println("<!> Please input a valid option");
        }
        System.out.println("");

        }

    }

}