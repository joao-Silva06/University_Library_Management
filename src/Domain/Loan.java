package Domain;

import java.util.Objects;

public class Loan {
    private String loanId;
    private User user;
    private Book book;
    private String loanDate;
    private String returnDate;

    public Loan(String loanId, User user, Book book, String loanDate, String returnDate) {
        this.loanId = loanId;
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(loanId, loan.loanId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(loanId);
    }

    @Override
    public String toString() {
        return String.format(
                """
                📚 Loan Details
                -------------------------
                Loan ID     : %s
                User        : %s
                Book        : %s
                Loan Date   : %s
                Return Date : %s
                """,
                loanId,
                user,
                book,
                loanDate,
                returnDate
        );
    }

}
