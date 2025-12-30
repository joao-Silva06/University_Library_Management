package Repository;

import Domain.Book;

import java.util.List;

public class BookRepo {
    private List<Book> books;
    public BookRepo(List<Book> books) {
        this.books = books;
    }
    public List<Book> getAllBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public Book getBookByName(String bookName) {
        for (Book book : books) {
            if(bookName.equals(book.getTitle())){
                return book;
            }
        }
        return null;
    }
    public Book getBookByISBN(int isbn) {
        for (Book book : books) {
            if(isbn == book.getIsbn()){
                return book;
            }
        }
        return null;
    }
    public Book getBookByAuthor(String author) {
        for (Book book : books) {
            if(author.equals(book.getAuthor())){
                return book;
            }
        }
        return null;
    }
    public void removeBook(int isbn) {
        books.remove(getBookByISBN(isbn));
    }
    public void addBook(Book book) {
        books.add(book);
    }
}
