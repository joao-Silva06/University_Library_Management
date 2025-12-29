package Repository;

import Domain.Loan;

import java.util.List;

public class LoanRepo {
    List<Loan> loans;
    public LoanRepo(List<Loan> loans){
        this.loans = loans;
    }
    public List<Loan> getLoans(){
        return loans;
    }
    public void setLoans(List<Loan> loans){
        this.loans = loans;
    }
    public boolean addLoan (Loan loan){
        loans.add(loan);
        return true;
    }
    public Loan getLoanById(String id){
        for(Loan loan : loans){
            if(loan.getLoanId().equals(id)){
                return loan;
            }
        }
        return null;
    }
    public boolean deleteLoanById(String id){
        for(Loan loan : loans){
            if(loan.getLoanId().equals(id)){
                loans.remove(loan);
                return true;
            }
        }
        return false;
    }
}
