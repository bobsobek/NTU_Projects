public class DinningArea{
    Customer[] seats;
    int seatsAvailable;

    Customer[] queue;
    int queueLength = 0;

    MenuItem[] menu;

    public DinningArea(int maxCustomers, int sizeOfResturaunt, MenuItem[] menu) {
        this.queue = new Customer[maxCustomers];
        this.seats = new Customer[sizeOfResturaunt];
        this.menu = menu;
        this.seatsAvailable = sizeOfResturaunt;
        }


    public void enqueue(Customer newCustomer){
        queue[queueLength] = newCustomer;
        queueLength ++;
    }

    public void seatCustomer(int seatID){
        // get the customer at head of queue and puts them in the ID;
        this.seats[seatID] = queue[0];
        System.arraycopy(queue, 1, queue, 0, queueLength - 1);
        queue[--queueLength] = null;   // clear the last slot
        seatsAvailable -= 1;
    }

    public void nextTurn(){
        for (Customer curCustomer: seats){
            curCustomer.nextTurn();
        }
    }

    public Customer[] getSeats(){
        return this.seats;
    }

    public int getNumCustomers(){
        return this.seats.length - this.seatsAvailable;
    }

    public int getNumFreeSeats(){
        return this.seatsAvailable;
    }

    public int getQueueLength(){
        return  this.queueLength;
    }

}