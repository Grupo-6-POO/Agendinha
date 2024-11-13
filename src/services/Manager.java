package services;
import Enums.Priority;
import entities.Category;
import entities.Task;

public abstract class Manager<M> implements Services <M> {

    public abstract M add(M obj);
    public abstract void delete(M obj);
    public abstract void update(M obj);

    public void read(M obj){
        System.out.println("Titulo: " + "\nDescrição: ");
    }
}


