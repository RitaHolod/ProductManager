package domain;
public class Product {
    protected int id;
    protected double price;
    protected String name;

    public Product(int id, double price, String name){
        this.id = id;
        this.price = price;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean matches(String search){
        if (getName().contains(search)){
            return true;
        } else {
            return false;
        }
    }
}
