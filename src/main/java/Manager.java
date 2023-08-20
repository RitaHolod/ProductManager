import domain.Product;

public class Manager {

    private Repo repository;

    public Manager(Repo repository){
        this.repository = repository;
    }

    public void save(Product product){
        repository.save(product);
    }

    public Product[] searchByName(String text){
        Product[] result = new Product[0];

        for (Product product: repository.findAll()) {
            if (matches(product, text)){

                Product[] tmp = new Product[result.length +1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length -1]= product;
                result = tmp;
            }
        }

        return result;
    }

    public boolean matches(Product product, String search){
        return product.getName().contains(search);
    }
}
