package application;
import entities.Calendar;
import entities.Category;
import entities.Task;
import services.TaskManager;

public class Main {
    public static void main(String[] args){
       // Calendar calendar = new Calendar(); //teste calendário
       // calendar.verifyInicialDeadLine();

        TaskManager taskManager = new TaskManager();
        Task task;
        taskManager.add();

    }
}
