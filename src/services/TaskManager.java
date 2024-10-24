package services;
import java.util.ArrayList;
import java.util.Scanner;
import Enums.Priority;
import Enums.Status;
import entities.Task;

public abstract class TaskManager extends Task implements TaskCategoryManager {

    public TaskManager (String title , String description, Status status, Priority priority, Integer progress, boolean isRepeat){
        super(title, description, status, priority, progress, isRepeat);
    }

    protected ArrayList<Task> tasks = new ArrayList<>();



    @Override
    public Manager add() {
        Task task = new Task(getTitle(), getDescription(), getStatus(), getPriority(), getProgress(), getRepeating());
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
        return task;
    }

    @Override
    public void delete() {

    }

    @Override
    public void read() {

    }

    @Override
    public void update() {

    }





//+concludeTask: void
//+showTask: void //vai ser o void read
//+increaseProgress: int
//+setPriority: Priority
//+setStatus: Status
//+verifyTask: Task
// Add: void
// Delete: void
//+rename: void
}
