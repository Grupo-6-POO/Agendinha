package services;

public abstract class Manager {

    public void startClass(){
        System.out.println("Método que vai ser sobreescrito!");
    }

    public abstract Manager Add();
    public abstract void Delete();
    public abstract void Read();
    public abstract void Update();
}

}
