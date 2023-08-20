import domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Repo repository = new Repo();
    Manager manager = new Manager(repository);

    Product product1 = new Product(1,230,"Where is my cheese&");
    Product product2 = new Product(2,250,"Iphone");
    Product product3 = new Product(3,130,"Where are they?");

    @BeforeEach

    public void setup(){
        manager.save(product1);
        manager.save(product2);
        manager.save(product3);
    }

    @Test

    public void shouldFindAll(){

        Product[] expected = {product1, product2, product3};
        Product[] actual = repository.findAll();
    }

    @Test

    public void shouldSearchFewProducts(){
        Product[] actual = manager.searchByName("Where");
        Product[] expected = {product1, product3};
    }

    @Test

    public void shouldSearchOneProduct(){
        Product[] actual = manager.searchByName("Iphone");
        Product[] expected = {product2};
    }

    @Test

    public void shouldSearchNull(){
        Product[] actual = manager.searchByName("smth");
        Product[] expected = {};
    }
}
