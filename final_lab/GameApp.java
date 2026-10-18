

class GameApp{
    static final Waiter waiter;
    static final Chef chef;
    static final MenuItem[] menu;
    static int currTurn = 0;
    static int[] CustomerTurn = {1,4,7,10,13,16};

    static {
        waiter = new Waiter();
        chef = new Chef();
        menu = new MenuItem[3]; 
    }

    public static void nextTurn() {
        if (currTurn == CustomerTurn[0]){

        }

    }

    public static void createMenu() {
        menu[0] = new MenuItem(1, 8.0, "food");
        menu[1] = new MenuItem(1,8.0,"food");
        menu[2] = new MenuItem(1,8.0,"food");
    }

    public static void main(String[] args) {
        createMenu();

    }
}