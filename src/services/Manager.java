package services;

public interface Manager <T>{

    T Add(T item);
    //Obs: o metodo acima retorna um objeto, está opção pode ser alterada futuramente conforme o desenvolvimento do projeto
    void Delete(T item);
    void Read(T item);
    void Update(T item);
}
