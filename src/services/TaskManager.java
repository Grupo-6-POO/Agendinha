package services;
import Enums.Priority;
import Enums.Status;
import entities.Category;
import entities.Task;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager extends Task {
    Category category;

    public TaskManager(String title, String description, Status status, Priority priority, Category category) {
        super(title, description, status, priority, category);
    }

    ArrayList <Task> tasks = new ArrayList<>();

    @Override
    public void startClass() {
        super.startClass();
        System.out.println("Método sobreescrevido");
        //tasks.add(TaskManager.add());
    }
    public Category chooseCategory(){
        return null;
    }

    public Task Add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Título da Tarefa: ");
        setTitle(sc.nextLine());
        System.out.println("Descrição da Tarefa: ");
        setDescription(sc.nextLine());
        System.out.println("Repetir? \n1 - SIM\n2 - NÃO\n");
        String resposta = sc.nextLine();
        if (resposta.equals("1")){
            setRepeating(true);
        }
        else if (resposta.equals("2")) {
            setRepeating(false);
        }
        else {
            System.out.println("Resposta Inválida");
        }
        category = chooseCategory();
        Task task;
        task = new Task(getTitle(), getDescription(), getStatus(), getPriority(), category);
        System.out.println("Sua Tarefa foi criada com sucesso e está com o status " + getStatus());
        sc.close();
        return task;
    }
    public void Delete(){

    }
    public void Read(){
        System.out.println(getTitle());
        System.out.println(getDescription());
        System.out.println(getStatus());
        System.out.println(getPriority());
    }
    public  void Update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n");
    }
}
