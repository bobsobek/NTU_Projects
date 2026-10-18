import java.util.Scanner;

// need to add an exit option for seat_customer and take_order


public class Waiter{
    private final Scanner waiterSC = new Scanner(System.in);

    public boolean do_nothing(){
        System.out.println("The waiter is doing nothing \n");
        return true;
    }

    public boolean seat_customer(DinningArea dinningArea){
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

        System.out.println("Where would you want to seat the customer?");
        int option = waiterSC.nextInt();

        while (true){
            if (option > 6 || option < 0){
                System.out.println("Invalid seat number");
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

    public boolean take_order(DinningArea dinningArea){
        int customers = dinningArea.getNumCustomers();
        if (customers == 0){
            System.out.println("<!> There are currently no customers");
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

        System.out.println("Which table would you like to take the order of");
        int option = waiterSC.nextInt();

        while (true){
            if (option > 6 || option < 0){
                System.out.println("Invalid seat number");
            }

            else{
                if (occupiedSeats[option] != null){
                    System.out.println("Seat is occupied");
                }

                else if (occupiedSeats[option].currOrder != null){
                    System.out.println("Seat customer ordered already");
                }

                else{
                    occupiedSeats[option].orderItem(dinningArea.menu,1); // orders one item from the menu
                    System.out.println("Customer has placed their order \n");
                    return true;
                }
            }
        }
    }

    public boolean serve_order(DinningArea dinningArea){
        Customer[] occupiedSeats = dinningArea.getSeats();
        for (int i = 0; i <  occupiedSeats.length; i++) {
            if (occupiedSeats[i] != null){
                if (occupiedSeats[i].currOrder.completed == true){
                    System.out.printf("Customer at table number %d ready to serve! \n",i);
                }
            }
        }

        System.out.println("Which table would you like to take the order of");
        int option = waiterSC.nextInt();

        while (true){
            if (option > 6 || option < 0){
                System.out.println("Invalid seat number");
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

                else{
                    occupiedSeats[option].setServed();
                    System.out.println("Customer has been served \n");
                    return true;
                }
            }
        }
    }
}