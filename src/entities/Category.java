package entities;

import java.util.ArrayList;

public class Category {

    private String name;
    private ArrayList<Task> tasks = new ArrayList<>();

    public Category(){

    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
