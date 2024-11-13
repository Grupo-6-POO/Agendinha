package services;

public interface Services <M> {
    M add(M obj);
    void delete(M obj);
    void read(M obj);
    void update(M obj);
}
