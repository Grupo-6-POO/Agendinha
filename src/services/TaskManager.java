package services;
import Enums.Priority;
import Enums.Status;
import entities.Category;
import entities.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager extends Task {
    Category category;

    public TaskManager() {
        super();
    }
    public TaskManager(String title, String description, Priority priority, Category category) {
        super(title, description, priority, category);
    }

    private List<Task> taskList ;


    @Override
    public void startClass(Manager task) {
        taskList = new ArrayList<>();
        System.out.println("Método sobreescrevido");
        taskList.add((Task) task);
    }

    public Category chooseCategory(){
        Category categorias;
        categorias = new CategoryManager();
        //getAllCategories();
        return null;
    }

    public Task add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Título da Tarefa: ");
        setTitle(sc.nextLine());
        System.out.println("Descrição da Tarefa: ");
        setDescription(sc.nextLine());
        System.out.println("Repetir? \n1 - SIM\n2 - NÃO\n");
        String resposta = sc.nextLine();
        while(true){
            if (resposta.equals("1")){
                setRepeating(true);
                break;
            }
            else if (resposta.equals("2")) {
                setRepeating(false);
                break;
            }
            else {
                System.out.println("Resposta Inválida");
            }}
        category = chooseCategory();
        Task task;
        task = new Task(getTitle(), getDescription(), getPriority(), category);
        System.out.println("Sua Tarefa foi criada com sucesso e está com o status " + getStatus());
        sc.close();
        return task;
    }
    public void delete(Task task){
        taskList.remove(task);
        System.out.println("Tarefa removida: " + task.getTitle());
    }
    public void read(){
        System.out.println(getTitle());
        System.out.println(getDescription());
        System.out.println(getStatus());
        System.out.println(getPriority());
    }
    public  void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("O que você deseja atualizar?\n");
    }
    public List<Task> getAllTasks() {
        return category.getTaskList();
    }

    public List<Task> getTaskList() { return taskList; }
    public void addTask(Task task) {}

}
