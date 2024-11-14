package entities;

import services.Manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category extends Manager <Category> implements Serializable {

    private String name;
    private List<Task> taskList = new ArrayList<>();

    public Category() {}

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public List<Task> getTaskList() {
        return taskList;
    }


    @Override
    public Category add(Category obj) {
        return null;
    }

    @Override
    public void delete(Category obj) {
    }

    @Override
    public void read(Category obj) {
    }

    @Override
    public void update(Category obj) {
    }
}


