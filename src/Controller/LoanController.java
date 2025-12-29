package Controller;

import Domain.Book;
import Domain.Loan;
import Domain.User;
import Repository.BookRepo;
import Repository.LoanRepo;
import Repository.UserRepo;

public class LoanController {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;
    private final LoanRepo loanRepo;
    public LoanController(BookRepo bookRepo, UserRepo userRepo, LoanRepo loanRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
        this.loanRepo = loanRepo;
    }
    public Loan makeLoan (String loanId, User user, Book book, String loanDate, String returnDate){
        if(book.isAvailable() && userRepo.getUserById(user.getId()) != null){
            Loan loan = new Loan(loanId, user, book, loanDate, null);
            loanRepo.addLoan(loan);
            loan.toString();
        }
        return null;
    }
    public Loan registerReturn (String returnDate, Loan loan){
        Loan mod = loanRepo.getLoanById(loan.getLoanId());
        mod.setReturnDate(returnDate);
        loanRepo.addLoan(mod);
        return mod;
    }

    public BookRepo getBookRepo() {
        return bookRepo;
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public LoanRepo getLoanRepo() {
        return loanRepo;
    }
}
