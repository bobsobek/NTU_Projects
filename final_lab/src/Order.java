public class Order{
    MenuItem[] ItemList;
    boolean completed  = false;

    public Order(MenuItem[] currOrder){
        this.ItemList = currOrder;
        this.completed = false;
    }

    public boolean getCompleted(){ return this.completed;}

    public void prepare(){}

    public double  getTotalBill(){
        double total = 0;
        for (MenuItem item: this.ItemList){
            total += item.getPrice();
        }
        return total;
    }

    public void printOrder(){
        for (MenuItem item: this.ItemList){
            System.out.print(item.toString());
        }
    }
}