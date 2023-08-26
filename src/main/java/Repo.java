import domain.NotFoundException;
import domain.Product;

public class Repo {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }

        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public void deleteById(int id) {

        if (findById(id) == null){
            throw new NotFoundException(
                    "Product with id:" + id + "not found");
        }

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

    public Product findById(int id){
        for (Product product: products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

}
