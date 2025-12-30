package Controller;

import Domain.User;
import Repository.BookRepo;
import Repository.UserRepo;

public class RegistUserController {
    private UserRepo userRepo;

    public RegistUserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registNewUser(String name, String email) {
        String id = "U-" + Long.toString((long) (Math.random() * 10000000000L));
        User user = new User(id, name, email);
        userRepo.addUser(user);
        user.toString();
    }
    public void atualizarEmail(User user, String email) {
        userRepo.getUserById(user.getId()).setEmail(email);
    }
    public void atualizarNome(User user, String name) {
        userRepo.getUserById(user.getId()).setName(name);
    }

    public UserRepo getUserRepo() {
        return userRepo;
    }

    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
}
