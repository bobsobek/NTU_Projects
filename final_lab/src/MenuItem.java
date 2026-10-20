public class MenuItem{
    int prepTime;
    double price;
    String name;

    public MenuItem(int prepTime, double price, String name){
        this.prepTime = prepTime;
        this.price = price;
        this.name = name;
    }

    public MenuItem(MenuItem copy) {
        this.name = copy.name;
        this.price = copy.price;
        this.prepTime = copy.prepTime;
    }

    public int getPrep(){
        return this.prepTime;
    }

    public double getPrice(){
        return this.price;
    }

    public String getName(){
        return this.name;
    }

    public void prepare(){
        this.prepTime -= 1;
    }

    @Override
    public String toString(){
        return this.name + '|' +this.price + '|' + this.prepTime + '\n';
    }

}