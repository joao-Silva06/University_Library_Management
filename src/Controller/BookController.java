package Controller;

import Domain.Book;
import Repository.BookRepo;

public class BookController {
    private final BookRepo bookRepo;
    public BookController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public Book registerNewBook(String title, String author, int isbn) {
        if (title == null || title.length() == 0 || author == null || author.length() == 0) {
            System.out.println("Title or Author is null or empty");
        } else if(isbn < 100000000 || isbn > 999999999 ) {
            System.out.println("ISBN number is invalid");
        } else {
            Book livro = new Book(title,author,isbn,true);
            return livro;
        }
        return null;
    }
    public BookRepo getBookRepo() {
        return bookRepo;
    }
}
