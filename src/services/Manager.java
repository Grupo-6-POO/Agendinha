package services;
import Enums.Priority;
import entities.Category;
import entities.Task;

public abstract class Manager<M> implements Services <M> {

    public void startClass(M manager){
        System.out.println("Método que vai ser sobreescrito!");
    }

    public abstract M add();
    public abstract void delete(M obj);
    public abstract void read(M obj);
    public abstract void update(M obj);
}


