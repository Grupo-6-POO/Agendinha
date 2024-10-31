package services;

public interface Manager <T>{

    void Add(T item);
    void Delete(T item);
    void Read(T item);
    void Update(T item);
}
