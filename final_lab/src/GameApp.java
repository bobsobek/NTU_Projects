
class GameApp{
    static final MenuItem[] menu = new MenuItem[3];
    static final DinningArea diningArea = new DinningArea(6,6,menu);

    static final Waiter waiter = new Waiter(diningArea);;
    static final Chef chef = new Chef(diningArea);

    static int currTurn = 1;
    static final int maxTurn = 18;

    static final int[] CustomerTurn = {1,4,7,10,13,16};
    static int customersEntered = 0;

    public static void nextTurn() {
        if (currTurn == CustomerTurn[customersEntered]){
            Customer newCustomer = new Customer();
            diningArea.enqueue(newCustomer);
            customersEntered ++;
        }
        waiter.WaiterOptions();
        chef.chefOptions();
        currTurn ++;
    }

    public static void createMenu() {
        menu[0] = new MenuItem(1, 9.0, "Salad");
        menu[1] = new MenuItem(1,15.0,"Burger");
        menu[2] = new MenuItem(2,18.0,"Pasta");
    }

    public static void main(String[] args) {
        createMenu();
        for (;currTurn < maxTurn; currTurn ++) nextTurn();
    }
}