import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {

    Repo repository = new Repo();
    Manager manager = new Manager(repository);


    Product product1 = new Product(1,230,"Where is my cheese&");
    Product product2 = new Product(2,250,"Iphone");
    Product product3 = new Product(3,130,"Where are they?");

    Book book1 = new Book(4,456.8,"Harry Potter 1","Rouling");
    Book book2 = new Book(5,466.8,"Harry Potter 2","Rouling");
    Product book3 = new Book(6,468.8,"War and peace","Tolstoy");
    Smartphone phone1 = new Smartphone(5,466.8,"Iphone","Apple");

    @BeforeEach

    public void setup(){
        manager.save(product1);
        manager.save(product2);
        manager.save(product3);
        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(phone1);
    }

    @Test

    public void shouldFindAll(){

        Product[] expected = {product1, product2, product3,book1,book2,book3,phone1};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchFewProducts(){
        Product[] actual = manager.searchByName("Where");
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchOneProduct(){
        Product[] actual = manager.searchByName("Iphone");
        Product[] expected = {product2, phone1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldSearchNull(){
        Product[] actual = manager.searchByName("smth");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor(){
        Product[] actual = manager.searchByName("Tolstoy");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByManufacture(){
        Product[] actual = manager.searchByName("Apple");
        Product[] expected = {phone1};

        Assertions.assertArrayEquals(expected, actual);
    }
}
