package services;
import entities.User;
import exceptions.ManagerException;

import java.util.Scanner;

public class UserManager extends User {

    public UserManager(){
        super();
    }

    public UserManager(String login, String senha, boolean isLogado) {
        super();
    }

    public void verifyLogin(String username, String password){
        if(!super.getUsername().equals(username) || !super.getPassword().equals(password)){
            throw new ManagerException("Error: Username or password incorrect");
        }
        System.out.println("Login successfully");
    }

}

