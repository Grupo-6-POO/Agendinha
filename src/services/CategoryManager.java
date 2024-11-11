package services;

import entities.Category;
import entities.Task;
import exceptions.ManagerException;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager extends Category{

    Task task;
    Category category;
    private List<Category> categories = new ArrayList<>();

    public CategoryManager() {
        super();
    }

    @Override
    public Category add() {
        categories.add(category);
        System.out.println("Categoria adicionada: " + category.getName());
        return null;
    }

   // @Override
    public void delete(Category category) {
        if (!categories.remove(category)) {
            throw new ManagerException("Erro: Category not found.");
        }
        System.out.println("Categoria succesfully removed: " + category.getName());

    }

    @Override
    public void read(Category category) {

    }

    //@Override
    public void update(Category category) {
        for (Category cat : categories) {
            if (cat.getName().equals(category.getName())) {
                System.out.println("Category successfully updated: " + cat.getName());
                return;
            }
        }
        throw new ManagerException("Erro: Category not found.");

    }

    public List<Category> getAllCategories() {
        return categories;
    }

    public List<Task> getTasksInCategory(Category category) {
        if (categories.contains(category)) {
            return category.getTaskList();
        }
        throw new ManagerException("Erro: Category not found.");
    }

    public void addTask(Task task) {
        super.getTaskList().add(task);
    }

    public void removeTask(Task task) {
        super.getTaskList().remove(task);
    }


}
