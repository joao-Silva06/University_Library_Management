package UI;

import Controller.BookController;
import Controller.LoanController;
import Domain.Loan;
import Repository.BookRepo;
import Repository.UserRepo;

import java.util.List;
import java.util.Scanner;

public class LoanUI implements Runnable {
    private final LoanController loanController;
    private final BookController bookController;
    private final UserRepo userRepo;
    public LoanUI(LoanController loanController, UserRepo userRepo, BookController bookController) {
        this.loanController = loanController;
        this.userRepo = userRepo;
        this.bookController = bookController;
    }
    @Override
    public void run() {
        boolean loop = true;
        while (loop) {
            Scanner choice = new Scanner(System.in);
            System.out.println("===Loan Interface===");
            System.out.println("1. Add Loan");
            System.out.println("2. Remove Loan");
            System.out.println("3. Set Return Date");
            System.out.println("4. View all Loans and Details");
            System.out.println("5. Quit");
            int c = choice.nextInt();
            switch (c) {
                case 1:
                    addLoanUI();
                    break;
                case 2:
                    removeLoanUI();
                    break;
                case 3:
                    setReturnDateUI();
                    break;
                case 4:
                    viewAllLoanUI();
                    break;
                case 5:
                    loop = false;
            }
        }

    }
    public void addLoanUI(){
        Scanner number = new Scanner(System.in);
        Scanner name = new Scanner(System.in);
        System.out.println("===Add Loan===");
        System.out.println("User name or id: ");
        String id = name.next();
        System.out.println("Book name: ");
        String bookname = number.next();
        System.out.println("Loan date: ");
        String lDate = number.next();
        long idnumero = (long) (Math.random() * 10000000000L);
        loanController.makeLoan("Ln-"+ Long.toString(idnumero),userRepo.getUserById(id),
                bookController.getBookRepo().getBookByName(bookname),lDate,null);
    }
    public void removeLoanUI(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("===Remove Loan===");
        System.out.println("Loan id: ");
        String loanid = sc.next();
        loanController.getLoanRepo().deleteLoanById(loanid);
        System.out.println("Loan "+loanid + " has been removed");
    }
    public void setReturnDateUI(){
        Scanner sc =  new Scanner(System.in);
        System.out.println("===Set Return Date===");
        System.out.println("Loan id: ");
        String loanid = sc.next();
        System.out.println("Return date: ");
        String lDate = sc.next();
        loanController.getLoanRepo().getLoanById(loanid).setReturnDate(lDate);
        System.out.println("Loan "+loanid + " has been returned at "+lDate);
    }
    public void viewAllLoanUI(){
        for(Loan loan : loanController.getLoanRepo().getLoans()){
            loan.toString();
            System.out.println("----------------");
        }
    }
}
