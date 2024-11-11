package entities;

import services.Manager;

import java.util.ArrayList;
import java.util.List;

public class Category extends Manager{

    private String name;
    private String description;
    private List<Task> taskList = new ArrayList<>();

    public Category() {

    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    @Override
    public Manager add() {
        return null;
    }

    @Override
    public void delete(Manager m) {

    }

    @Override
    public void read(Manager m) {

    }

    @Override
    public void update(Manager m) {

    }
}


