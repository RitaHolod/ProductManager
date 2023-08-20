package domain;
public class Book extends Product{
    private String author;

    public Book(int id, double price, String name, String author){
        super(id, price, name);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
