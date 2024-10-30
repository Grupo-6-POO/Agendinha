package services;
import entities.Task;
import exceptions.ManagerException;

import java.util.ArrayList;

public class TaskManager extends Task implements Manager {

    private ArrayList<Task> historyConcludedTasks;
    private CategoryManager categoryManager;

    public TaskManager(){
        this.categoryManager = new CategoryManager();
    }


    @Override
    public void Add() {
        Task task = new Task();
        categoryManager.getTasks().add(task);
        int taskCount = categoryManager.getTasks().size();
        System.out.println(taskCount);
    }

    @Override
    public void Delete() {

    }

    @Override
    public void Update() {

    }
}
