package services;

import entities.Category;
import entities.Task;
import exceptions.ManagerException;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager extends Task{
    Category category;
    FileManager fileManager;
    JFrame frame;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public TaskManager() {
        super();
    }
    public TaskManager(String title, String priority, String status, LocalDate deadLine, String category) {
        super(title, priority, status, deadLine, category);
    }

    // Lista de tarefas
    private List<Task> tasks = new ArrayList<>();

    // Sobreescrita de método
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
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
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


    public static void salvarTasksCSV(List<Task> tasks, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.append("Title,Priority,Status,DeadLine,Category\n");

        for (Task task : tasks) {
            writer.append(task.getTitle()).append(",")
                    .append(task.getPriority()).append(",")
                    .append(task.getStatus()).append(",")
                    .append(task.getDeadLine().format(formatter)).append(",")
                    .append(task.getCategory()).append("\n");
        }

        writer.flush();
        writer.close();
    }

    public static List<Task> carregarTasksCSV(String filePath) throws IOException {
        List<Task> tasks = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        // Ignora o cabeçalho
        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(","); // Divide cada linha com base na vírgula

            // Converte a String para LocalDate
            LocalDate deadLine = LocalDate.parse(data[3], formatter);

            // Cria uma nova Task com os dados lidos
            Task task = new Task(data[0], data[1], data[2], deadLine, data[4]);
            tasks.add(task); // Adiciona a task à lista
        }

        reader.close();
        return tasks;
    }



    public static void salvarTask(Task task) throws IOException { // Salva Objetos
        FileOutputStream fos = new FileOutputStream("src/data/obj.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(task);
        os.close();
        fos.close();
    }
    public static Task carregarTask() throws IOException, ClassNotFoundException {
        //Lê e retorna objetos
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
        return "Título: " + getTitle() + "\nPrioridade: " + getPriority() + "\nStatus: "+ getStatus() + "\nPrazo Final: " + getDeadLine();
    }


}
