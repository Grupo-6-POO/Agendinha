package services;

import entities.Category;
import entities.Task;
import exceptions.ManagerException;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryManager extends Category {

    Task task;
    Category category;
    private JFrame frame;
    private JPanel sidebar;
    private JPanel topBar;
    private JPanel taskViewPanel;
    private CardLayout cardLayout;
    private Map<String, JPanel> categoryPanels;
    private List<Category> categories = new ArrayList<>();
    FileManager fileManager;


    public CategoryManager() {
        super();
    }

    public void delete(String categoryName) {
        // Verifica se a categoria existe e a remove
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                categories.remove(category);
            }
        }
        //Apaga do arquivo
        fileManager = new FileManager("src/data/data.txt");
        fileManager.removeData(categoryName);
    }


    public Category add(String categoryName)  {
        if (categoryName != null && !categoryName.trim().isEmpty()) {
            Category category = new Category("");
            category.setName(categoryName);
            categories.add(category);
            fileManager = new FileManager("src/data/data.txt");
            fileManager.saveData(categoryName);
        }

        System.out.println(category);
        return category;
    }


    @Override
    public void delete(Category obj) {

//        // Verifica se a categoria existe e a remove
//        for (Category category : categories) {
//            if (category.getName().equals(categoryName)) {
//                categories.remove(category);
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public void update(Category obj) {

    }

    @Override
    public void read(Category category) {

    }

    public void updateCategory(String oldName, String newName, String newDescription) {
        for (Category category : categories) {
            if (category.getName().equals(oldName)) {
                category.setName(newName);
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

    public static void salvarCategory(Category category) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/data/data.txt");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(category);
        os.close();
        fos.close();
    }
    public static Category carregarCategory() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/data/data.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        Category category = (Category) is.readObject();
        System.out.println(category);
        is.close();
        fis.close();
        return category;
    }

    @Override
    public String toString() {
        return "Título: " + getName();}


}
