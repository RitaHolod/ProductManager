package domain;
public class Smartphone extends Product{
    private String manufacture;

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Smartphone(int id, double price, String name, String manufacture){
        super(id, price, name);
    }
}
