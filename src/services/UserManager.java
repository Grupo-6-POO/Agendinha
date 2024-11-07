package services;
import entities.User;
import java.util.Scanner;

public abstract class UserManager extends User {

    public UserManager(String login, String senha, boolean isLogado) {
        super(login, senha, isLogado);
    }

    public User login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu Login:");
        String login = sc.nextLine();
        System.out.println("Digite sua Senha:");
        String senha = sc.nextLine();
        if (login.equals(getLogin()) || senha.equals(getSenha())){
            System.out.println("Login realizado com sucesso!");
        }

        return null;
    }
}
