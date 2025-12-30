package Main;

import Controller.BookController;
import Controller.LoanController;
import Controller.LoginController;
import Controller.RegistUserController;
import Domain.Book;
import Repository.BookRepo;
import Repository.LoanRepo;
import Repository.UserRepo;
import UI.LoanUI;
import UI.Login;
import UI.UserUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //repos
        BookRepo bookRepo = new BookRepo(new ArrayList<>());
        UserRepo userRepo = new UserRepo(new HashSet<>());
        LoanRepo loanRepo = new LoanRepo(new ArrayList<>());
        //controller
        LoginController controller = new LoginController();
        LoanController loanController = new LoanController(bookRepo, userRepo, loanRepo);
        BookController bookController = new BookController(bookRepo);
        RegistUserController  registUserController = new RegistUserController(userRepo);
        //ui
        Login login = new Login(controller);
        LoanUI loanUI = new LoanUI(loanController, userRepo, bookController);
        UserUI userUI = new UserUI(registUserController);


        boolean running = true;
        int op = 0;
        login.run();
        while (running) {
            System.out.println("1. Books Interface");
            System.out.println("2. Loans Interface");
            System.out.println("3. Users Interface");
            System.out.println("4. Exit");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    break;
                case 2:
                    loanUI.run();
                    break;
                case 3:
                    userUI.run();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    running = false;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }
}
