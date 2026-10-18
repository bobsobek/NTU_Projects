
import java.util.Random;

public class Customer{
    Order currOrder;
    boolean served = false;
    boolean finished = false;

    public Customer(){}
    
    public void orderItem(MenuItem[] menu, int itemsOrdered ){
        MenuItem[] itemList = new MenuItem[itemsOrdered];
        int orderID;
        Random r = new Random();
        for (int i = 0; i < itemsOrdered; i ++){
            orderID = r.nextInt(menu.length);
            itemList[i] = new MenuItem(menu[orderID]);
        }

        this.currOrder = new Order(itemList);
    }

    public void decay(){}

    public void payBill(){}

    public void nextTurn(){}

    public void setServed(){
        this.served = true;
    }
}