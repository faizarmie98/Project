package faiz.assessment.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "book_title", nullable = false)
    private String bookTitle;
    @Column(name = "book_author", nullable = false)
    private String bookAuthor;
    @Column(name = "book_genre", nullable = false)
    private String bookGenre;
    @Column(name = "book_price", nullable = false)
    private int bookPrice;
    @Column(name = "book_quantity", nullable = false)
    private int bookQuantity;

    public Products() {

    }

    public Products(String bookTitle, String bookAuthor, String bookGenre, int bookPrice, int bookQuantity) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.bookPrice = bookPrice;
        this.bookQuantity = bookQuantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    @Override
    public String toString() {
        return "Product [id= " + id + 
            ", bookTitle= " + bookTitle + 
            ", bookAuthor= " + bookAuthor + 
            ", bookGenre= " + bookGenre + 
            ", bookPrice= " + bookPrice +
            ", bookQuantity= " + bookQuantity + 
            "]";
    }

}