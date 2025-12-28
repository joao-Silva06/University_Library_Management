package Main;

import Controller.LoginController;
import Domain.Book;
import Repository.UserRepo;
import UI.Login;

public class main {
    public static void main(String[] args) {
        LoginController controller = new LoginController();
        Login login = new Login(controller);
        login.run();
    }
}
