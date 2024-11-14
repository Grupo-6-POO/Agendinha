package services;

import entities.Category;
import entities.Task;
import exceptions.ManagerException;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager extends Task{
    Category category;
    FileManager fileManager;
    JFrame frame;

    public TaskManager() {
        super();
    }
    public TaskManager(String title, String priority, String status, LocalDate deadLine) {
        super(title, priority, status, deadLine);
    }


    // Lista de tarefas
    private List<Task> tasks = new ArrayList<>();

    public Task add(Task task) {
        System.out.println("Método add chamado");
        if (task == null) {
            throw new ManagerException("A tarefa não pode ser nula.");
        }
        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new ManagerException("O título da tarefa é obrigatório.");
        }
        if (task.getDeadLine() == null) {
            throw new ManagerException("O prazo da tarefa é obrigatório.");
        }
        if (task.getPriority() == null || task.getPriority().equals("NULL")) {
            throw new ManagerException("A prioridade da tarefa é obrigatória.");
        }
        if (task.getStatus() == null || task.getStatus().equals("NULL")) {
            throw new ManagerException("O status da tarefa é obrigatório.");
        }

        if (task.getTitle() != null && !task.getTitle().trim().isEmpty() && task.getDeadLine() != null) {
            // Adiciona a tarefa na lista após validação
            tasks.add(task);
            System.out.println("Tarefa adicionada com sucesso: " + task.getTitle());

            System.out.println("Chamando salvarTask...");

            try {
                salvarTask(task);
                carregarTask();
                System.out.println("Tarefa salva.");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return task;
        }
        return task;
    }

    public List<Task> getTasks() throws IOException, ClassNotFoundException {
        carregarTask();
        return tasks;}

    public void delete(Task task){
        tasks.remove(task);
        System.out.println("Tarefa removida: " + task.getTitle());
    }
    public void read(Task task){
        //Usar o toString();
    }
    public  void update(Task task){
        Scanner sc = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n" + "[ 1 ] - Status:\n" + "[ 2 ]");
    }

    public List<Task> getAllTasks() {
        return category.getTaskList();
    }


    public static void salvarTask(Task task) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/data/obj.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(task);
        os.close();
        fos.close();
    }
    public static Task carregarTask() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/data/obj.txt");
        ObjectInputStream is = new ObjectInputStream(fis);

        Task task = (Task) is.readObject();
        System.out.println(task);
        is.close();
        fis.close();
        return task;
    }
    @Override
    public String toString() {
        return "Título: " + getTitle() + "\nPrioridade: " + getPriority() + "\nCategoria: " + getCategory() + "\nStatus: "+ getStatus();
    }


}
