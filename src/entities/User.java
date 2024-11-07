package entities;

public class User {
    private String login;
    private String senha;
    private boolean isLogado = false;

    public User(String login, String senha, boolean isLogado){
        this.login = login;
        this.senha = senha;
        this.isLogado = isLogado;
    }

    public String getLogin() { return login; }
    public String getSenha() { return senha; }
}
