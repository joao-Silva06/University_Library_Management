package Controller;

import Domain.Book;
import Domain.Loan;
import Domain.User;
import Repository.BookRepo;

public class LoanController {
    private final BookRepo bookRepo;
    public LoanController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }
    public Loan makeLoan (String loanId, User user, Book book, String loanDate, String returnDate){
        if(book.isAvailable()){
            Loan loan = new Loan(loanId, user, book, loanDate, returnDate);
        }
        return null;
    }
}
