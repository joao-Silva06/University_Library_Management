package Repository;

import Domain.Book;

import java.util.List;

public class BookRepo {
    private List<Book> books;
    public BookRepo(List<Book> books) {
        this.books = books;
    }
    public List<Book> getBooks() {
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
}
