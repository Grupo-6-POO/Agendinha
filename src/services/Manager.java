package services;
import Enums.Priority;

public abstract class Manager implements Services <Manager>{

    public void startClass(Manager manager){
        System.out.println("Método que vai ser sobreescrito!");
    }

    public abstract Manager add();
    public abstract void delete(Manager m);
    public abstract void read(Manager m);
    public abstract void update(Manager m);
}


