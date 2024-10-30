package services;
import Enums.Priority;
import Enums.Status;
import entities.Category;
import entities.Task;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class TaskManager extends Task implements Manager {

    private ArrayList<Task> historyConcludedTasks;

    public TaskManager(String title , String description, Status status, Priority priority, Category category){
            super(title, description, status, priority, category);

    }
    protected ArrayList<Task> tasks = new ArrayList<>();

    public void add() {
        Category category;
        Task task = new Task(getTitle(), getDescription(), getStatus(), getPriority(), Category category);
        Scanner sc = new Scanner(System.in);
        System.out.println("Título da Tarefa: ");
        setTitle(sc.nextLine());
        System.out.println("Descrição da Tarefa: ");
        setDescription(sc.nextLine());
        System.out.println("Repetir? \n1 - SIM\n2 - NÃO\n");
        String resposta = sc.nextLine();
        if (resposta == "1"){
            setRepeating(true);
        }
        else if (resposta == "2") {
            setRepeating(false);
        }
        else {
            System.out.println("Resposta Inválida");
        }
        tasks.add(task);
        System.out.printf("Sua Tarefa foi criada com sucesso e está com o status " + getStatus());
        //return task;



        //Lucas
//        category.getTasks().add(task);
//        int taskCount = category.getTasks().size();
//        System.out.println(taskCount);
    }

    @Override
    public void Delete() {

    }

    @Override
    public void Update() {

    }

    public void concludeTask(Task task){

    }
}
