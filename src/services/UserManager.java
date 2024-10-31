package services;
import entities.User;

public abstract class UserManager extends User {

    public UserManager(String login, String senha) {
        super(login, senha);
    }
}
