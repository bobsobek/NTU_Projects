public class MenuItem{
    int prep_time;
    double price;
    String name;

    public MenuItem(int prep_time, double price, String name){
        this.prep_time  =prep_time;
        this.price = price;
        this.name = name;
    }

    public void prepare(){
        this.prep_time -= 1;
    }

    public double getPrice(){
        return this.price;
    }
}