package services;
import Enums.Priority;
import Enums.Status;
import entities.Category;
import entities.Task;

public class TaskManager extends Task implements Manager<Task>{

    public TaskManager(String title, String description, Status status, Priority priority, Category category) {
        super(title, description, status, priority, category);
    }

    @Override
    public Task Add(Task item) { //dúvida - Task ou TaskManager
        return null;
    }

    @Override
    public void Delete(Task item) {

    }

    @Override
    public void Read(Task item) {

    }

    @Override
    public void Update(Task item) {

    }
}
