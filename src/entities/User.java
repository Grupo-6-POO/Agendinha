package entities;

public class User {
    private String username;
    private String password;
    private boolean isLogado;

    public User() {
        this.username = "Lucas";
        this.password = "1234";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
