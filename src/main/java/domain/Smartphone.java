package domain;

public class Smartphone extends Product {
    private String manufacture;

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Smartphone(int id, double price, String name, String manufacture) {
        super(id, price, name);
        this.manufacture = manufacture;
    }

    @Override
    public boolean matches(String search) {
        if(super.matches(search)){
            return true;
        } if (getManufacture() == search){
            return true;
        } else {
            return false;
        }
    }
}
