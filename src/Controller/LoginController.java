package Controller;

import Domain.User;
import Repository.UserRepo;

import java.util.Set;

public class LoginController {
    private String PASSWORD = "123@45-/";
    private String USERNAME = "admin";
    public LoginController() {
    }
    public boolean ValidateLogin(String username, String password) {
        if(username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }
        return false;
    }




}
