package application;
import Enums.Priority;
import entities.Calendar;
import entities.Category;
import entities.Task;
import entities.User;
import services.TaskManager;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import static services.TaskManager.carregarTask;
import static services.TaskManager.salvarTask;

//Classe teste
public class Aplication implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Task task = new TaskManager("Nada", "So um teste", Priority.LOW, new Category("nada"));
        salvarTask(task);
        carregarTask();



        //String senha = JOptionPane.showInputDialog(null, "Senha");
        //System.out.println(senha);



    }


    //ArrayList <User> usuarios = new ArrayList<>();
    //usuarios.add(new User("Bruna", "1234"));
    //usuarios.add(new User("Lucas", "5678"));
    //for(User usuario : usuarios){
    // salvarUsuario(usuario);}
    //System.out.println(usuarios);

//      public static void salvarUsuario(User usuario) throws IOException {
//        FileOutputStream fos = new FileOutputStream("../data.txt");
//        ObjectOutputStream os = new ObjectOutputStream(fos);
//
//        os.writeObject(usuario);
//        os.close();
//        fos.close();
//      }

}

