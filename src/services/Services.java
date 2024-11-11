package services;

public interface Services <M> {
    M add();
    void delete(M obj);
    void read(M obj);
    void update(M obj);
}
