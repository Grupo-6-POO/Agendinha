package services;

public abstract class Manager<M> implements Services <M> {

    //SuperPai do Método Sobrescrito
    public M add(M obj){
        System.out.println("Cada filho terá sua implementação");
        return obj;
    }
    public abstract void delete(M obj);
    public abstract void update(M obj);

    public void read(M obj){
        System.out.println("Titulo: " + "\nDescrição: ");
    }
}


