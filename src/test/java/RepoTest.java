import domain.Book;
import domain.Product;
import domain.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepoTest {
    Repo repository = new Repo();
    Book book1 = new Book(1,200,"Harry Potter","Rouling");
    Book book2 = new Book(21,400,"Katalina","Moem");
    Book book3 = new Book(3,300,"War and Peace","Tolstoy");

    Smartphone smartphone4 = new Smartphone(4,340,"S43","Huawei");

    @BeforeEach
    public void setup(){
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(smartphone4);
    }

    @Test
    public void shouldDeleteById(){
        repository.deleteById(21);

        Product[] expected = {book1, book3, smartphone4};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected,actual);
    }
}
