package application;
import entities.User;
import java.io.*;
import java.util.ArrayList;

//Classe teste
public class Aplication implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      ArrayList <User> usuarios = new ArrayList<>();
      usuarios.add(new User("Bruna", "1234"));
      usuarios.add(new User("Lucas", "5678"));
      for(User usuario : usuarios){
        salvarUsuario(usuario);}
      System.out.println(usuarios);

    }


      public static void salvarUsuario( User usuario) throws IOException {
        FileOutputStream fos = new FileOutputStream("../data.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(usuario);
        os.close();
        fos.close();
      }

}

