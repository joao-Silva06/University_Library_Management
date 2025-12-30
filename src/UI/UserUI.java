package UI;

import Controller.RegistUserController;
import Domain.User;

import java.util.Scanner;

public class UserUI implements Runnable {
    private final RegistUserController registUserController;

    public UserUI(RegistUserController registUserController) {
        this.registUserController = registUserController;
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            Scanner sc = new Scanner(System.in);
            System.out.println("===Users Interface===");
            System.out.println("1. Create new user");
            System.out.println("2. Update data");
            System.out.println("3. Delete user");
            System.out.println("4. View all users");
            System.out.println("5. Quit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createUserUI();
                    break;
                case 2:
                    updateUserUI();
                    break;
                case 3:
                    deleteUserUI();
                    break;
                case 4:
                    viewAllUsersUI();
                    break;
                case 5:
                    running = false;
                default:
                    System.out.println("Wrong choice");

            }
        }
    }

    private void createUserUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do user: ");
        String username = sc.nextLine();
        System.out.println("Digite o email do user: ");
        String email = sc.nextLine();
        registUserController.registNewUser(username, email);
    }

    private void updateUserUI() {
        boolean loop = true;
        while (loop) {
            System.out.println("1. Deseja alterar o nome do user? ");
            System.out.println("2. Deseja alterar o email do user? ");
            System.out.println("3. Sair");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            if (choice == 1) {
                updateUserNameUI();
                break;
            } else if (choice == 2) {
                updateUserEmailUI();
                break;
            } else if (choice == 3) {
                loop = false;
            }
        }
    }

    private void updateUserNameUI() {
        System.out.println("Digite o nome do user: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Digite o novo nome do user: ");
        String newUsername = sc.nextLine();
        registUserController.atualizarNome(registUserController.getUserRepo().getUserByUsername(username), newUsername);
    }

    private void updateUserEmailUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o email do user: ");
        String email = sc.nextLine();
        System.out.println("Digite o novo email do user: ");
        String newEmail = sc.nextLine();
        registUserController.atualizarEmail(registUserController.getUserRepo().getUserByEmail(email), newEmail);
    }

    private void deleteUserUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o id do user: ");
        String id = sc.nextLine();
        registUserController.getUserRepo().removeUser(registUserController.getUserRepo().getUserById(id));
    }

    private void viewAllUsersUI() {
        for (User user : registUserController.getUserRepo().getAllUsers()) {
            user.toString();
        }
    }

}
