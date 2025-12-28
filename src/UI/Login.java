package UI;

import Controller.LoginController;

import java.util.Scanner;

public class Login implements Runnable{
    LoginController loginController;
    public Login(LoginController loginController) {
        this.loginController = loginController;
    }
    @Override
    public void run(){
        Scanner sc = new Scanner(System.in);
        int sucesso = 1;
        while(sucesso == 1) {
            System.out.println("==Login==");
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            if (loginController.ValidateLogin(username, password)) {
                System.out.println("Login Successful");
                sucesso = 0;
            } else {
                System.out.println("Invalid username or password");
            }
        }
    }
}
