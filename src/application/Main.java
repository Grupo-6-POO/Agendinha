package application;

import services.CategoryManager;
import services.TaskManager;

public class Main {
    public static void main(String[] args){

        TaskManager taskManager = new TaskManager();

        taskManager.Add();
    }
}
