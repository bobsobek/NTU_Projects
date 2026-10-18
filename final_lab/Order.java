public class Order{
    MenuItem[] ItemList;
    boolean completed;

    public Order(MenuItem[] currOrder){
        this.ItemList = currOrder;
        this.completed = false;
    }

    public void checkCleared(){}

    public void prepare(){}

    public double  getTotalBill(){
        double total = 0;
        for (MenuItem item: this.ItemList){
            total += item.getPrice();
        }
        return total;
    }
}