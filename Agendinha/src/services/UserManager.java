package services;

import entities.User;
import exceptions.UserException;

public class UserManager extends User {

    public void login(String username, String password){

        if (username != super.getUsername() && password != super.getPassword()){
            throw new UserException("Error: Username or Password are incorrect");
        }
        System.out.println("Login succesfull!");
    }
}
