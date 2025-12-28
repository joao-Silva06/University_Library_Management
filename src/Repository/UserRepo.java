package Repository;

import Domain.User;

import java.util.Set;

public class UserRepo {
    Set<User> users; //set pois não permita que haja user repetidos
    public UserRepo(Set<User> users){
        this.users = users;
    }
    public User getUserById (String id){
        for(User user : users){
            if(id == user.getId()){
                return user;
            }
        }
        return null;
    }
    public User getUserByEmail(String email){
        for(User user : users){
            if(email == user.getEmail()){
                return user;
            }
        }
        return null;
    }
    public User getUserByUsername(String username){
        for(User user : users){
            if (username == user.getName()){
                return user;
            }
        }
        return null;
    }
    public Set<User> getAllUsers(){
        return users;
    }

}
