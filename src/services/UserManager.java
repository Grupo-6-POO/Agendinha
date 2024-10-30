package services;

import entities.User;
import exceptions.ManagerException;

import java.util.ArrayList;

public abstract class UserManager extends User {

    ArrayList <User> usuarios = new ArrayList<>();
    public void login(String username, String password){

        if (username != super.getUsername() && password != super.getPassword()){
            throw new ManagerException("Error: Username or Password are incorrect");
        }
        System.out.println("Login succesfull!");
    }
}
