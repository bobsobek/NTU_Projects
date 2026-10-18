public class DinningArea{
    Customer[] customers;
    int customersPresent = 0;

    public DinningArea(int maxCustomers) {this.customers = new Customer[maxCustomers];}

    public void nextTurn(){
        for (int i = 0; i < customersPresent; i++) {
            customers[i].nextTurn();   
        }
    }

    public void newCustomer(Customer newCustomer){
        customers[customersPresent] = newCustomer;
        customersPresent += 1;
    }
}