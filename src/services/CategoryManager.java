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

    public void addCategory(String name, String description) {
        Category category = new Category(name, description);
        categories.add(category);
    }

    public boolean deleteCategory(String categoryName) {
        // Verifica se a categoria existe e a remove
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                categories.remove(category);
                return true;
            }
        }
        return false;
    }

    @Override
    public void read(Category category) {

    }

    public void updateCategory(String oldName, String newName, String newDescription) {
        for (Category category : categories) {
            if (category.getName().equals(oldName)) {
                category.setName(newName);
                category.setDescription(newDescription);
                break;
            }
        }
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
