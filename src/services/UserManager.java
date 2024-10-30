package services;

import entities.User;
import exceptions.ManagerException;

public class UserManager extends User {

    public void login(String username, String password){

        if (username != super.getUsername() && password != super.getPassword()){
            throw new ManagerException("Error: Username or Password are incorrect");
        }
        System.out.println("Login succesfull!");
    }
}
