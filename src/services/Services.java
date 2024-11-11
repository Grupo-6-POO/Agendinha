package services;

public interface Services <M> {
    Manager add();
    void delete(M m);
    void read(M m);
    void update(M m);
}
