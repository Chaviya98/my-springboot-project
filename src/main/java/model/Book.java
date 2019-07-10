package model;

public class Book {
    private String bookID;
    private String bookTitle;
    private String bookPrice;

    public Book(String bookID, String bookTitle, String bookPrice) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
    }
    public Book(String bookID) {
        this.bookID = bookID;

    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }
}
