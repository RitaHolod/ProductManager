import domain.Product;
public class Repo {
    private Product[] products = new Product[0];

    public Product[] findAll(){
        return products;
    }

    public void save(Product product){
        Product[] tmp = new Product[products.length + 1];
        for (int i; i<products.length; i++) {
            tmp[i] = products[i];
        }

        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void deleteById(int id){

        Product[] tmp = new Product[products.length - 1];

        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }

        products = tmp;
    }

}
