package entities;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private String description;
    private List<Task> taskList = new ArrayList<>();

    public Category(){

    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Task> getTaskList() { return taskList; }

    public void addTask(Task task) { taskList.add(task); }
    public void removeTask(Task task) { taskList.remove(task); }
}
