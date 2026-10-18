
import java.util.Random;

public class Customer{
    public Order orderItem(MenuItem[] menu, int itemsOrdered ){
        MenuItem[] itemList = new MenuItem[itemsOrdered];
        int orderID;
        Random r = new Random();
        for (int i = 0; i < itemsOrdered; i ++){
            orderID = r.nextInt(menu.length);
            itemList[i] = menu[orderID];
        }

        Order currOrder = new Order(itemList);
        return currOrder;
    }

    public void decay(){}

    public void payBill(){}

    public void nextTurn(){}
}