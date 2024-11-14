package UI;

import entities.Category;
import services.CategoryManager;
import services.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private JFrame frame;
    private JPanel sidebar;
    private JPanel topBar;
    private JPanel taskViewPanel;
    private CardLayout cardLayout;
    private Map<String, JPanel> categoryPanels;
    private CategoryManager categoryManager;
    private Map<String, List<String>> categoryTasks = new HashMap<>();

    public Map<String, List<String>> getCategoryTasks() {
        return categoryTasks;
    }

    public Menu() {
        frame = new JFrame("Agendinha");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        categoryPanels = new HashMap<>();
        categoryManager = new CategoryManager();



        frame.setLayout(new BorderLayout());

        configureSidebar();
        configureTopBar();
        configureTaskViewPanel();
        carregarCategorias();

        frame.setVisible(true);
    }

    private void configureSidebar() {
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(50, 50, 50));
        sidebar.setPreferredSize(new Dimension(170, 600));
        sidebar.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JLabel sidebarTitle = new JLabel("Categories");
        sidebarTitle.setForeground(Color.WHITE);
        sidebarTitle.setFont(new Font("Roboto", Font.BOLD, 18));
        sidebarTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botão "Add Category"
        JButton addCategoryButton = new JButton("Add Category");
        addCategoryButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        addCategoryButton.setBackground(new Color(70, 130, 180));
        addCategoryButton.setForeground(Color.WHITE);
        addCategoryButton.setFocusPainted(false);
        addCategoryButton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        addCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addCategoryButton.addActionListener(e -> addCategory());

        // Botão "Delete Category"
        JButton deleteCategoryButton = new JButton("Delete Category");
        deleteCategoryButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        deleteCategoryButton.setBackground(new Color(205, 92, 92));
        deleteCategoryButton.setForeground(Color.WHITE);
        deleteCategoryButton.setFocusPainted(false);
        deleteCategoryButton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        deleteCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        deleteCategoryButton.addActionListener(e -> deleteCategory());

        // Botão "Update Category"
        JButton updateCategoryButton = new JButton("Update Category");
        updateCategoryButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        updateCategoryButton.setBackground(new Color(255, 165, 0));
        updateCategoryButton.setForeground(Color.WHITE);
        updateCategoryButton.setFocusPainted(false);
        updateCategoryButton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        updateCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        updateCategoryButton.addActionListener(e -> updateCategory());

        JLabel sidebarTask = new JLabel("Tasks");
        sidebarTitle.setForeground(Color.WHITE);
        sidebarTitle.setFont(new Font("Roboto", Font.BOLD, 18));
        sidebarTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        addTaskButton.setBackground(new Color(34, 139, 34));
        addTaskButton.setForeground(Color.WHITE);
        addTaskButton.setFocusPainted(false);
        addTaskButton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        addTaskButton.setAlignmentX(Component.CENTER_ALIGNMENT);

// Adiciona ação para abrir o TaskForm
        addTaskButton.addActionListener(e -> new TaskForm(this)); // Passar referência do Menu atual

// Adicionando o botão ao sidebar
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(addTaskButton);

        sidebar.add(sidebarTitle);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(addCategoryButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(deleteCategoryButton);
        sidebar.add(Box.createVerticalStrut(10));
        sidebar.add(updateCategoryButton);
        sidebar.add(Box.createVerticalGlue());

        frame.add(sidebar, BorderLayout.WEST);
    }

    private void configureTopBar() {
        topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topBar.setBackground(new Color(70, 70, 70));
        topBar.setPreferredSize(new Dimension(800, 50));

        JLabel topBarTitle = new JLabel("Agendinha");
        topBarTitle.setFont(new Font("Roboto", Font.BOLD, 24));
        topBarTitle.setForeground(Color.WHITE);
        topBar.add(topBarTitle);

        frame.add(topBar, BorderLayout.NORTH);
    }

    private void configureTaskViewPanel() {
        taskViewPanel = new JPanel();
        cardLayout = new CardLayout();
        taskViewPanel.setLayout(cardLayout);
        taskViewPanel.setBackground(Color.WHITE);
        taskViewPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(taskViewPanel, BorderLayout.CENTER);
    }

    private void addCategory(){
        String newCategoryName = JOptionPane.showInputDialog(frame, "New category name:");
        categoryManager.add(newCategoryName);
        addCategoryToUI(newCategoryName);

    }

    private void deleteCategory() {
        String categoryName = JOptionPane.showInputDialog(frame, "Enter category name to delete:");

        // Verifica se a categoria existe e é excluída com sucesso
        if (categoryName != null ) {
            categoryManager.delete(categoryName);
            JButton buttonToRemove = findCategoryButton(categoryName);

            if (buttonToRemove != null) {
                topBar.remove(buttonToRemove);
                topBar.revalidate();
                topBar.repaint();
            }

            // Remove o painel associado à categoria
            taskViewPanel.remove(categoryPanels.remove(categoryName));
            taskViewPanel.revalidate();
            taskViewPanel.repaint();
        } else {
            JOptionPane.showMessageDialog(frame, "Category not found or could not be deleted.");
        }
    }

    private void updateCategory() {
        String categoryName = JOptionPane.showInputDialog(frame, "Enter category name to update:");
        if (categoryName != null && categoryPanels.containsKey(categoryName)) {
            String newCategoryName = JOptionPane.showInputDialog(frame, "New category name:");
            if (newCategoryName != null && !newCategoryName.trim().isEmpty()) {
                // Atualiza o botão da categoria na interface gráfica
                JButton categoryButton = findCategoryButton(categoryName);
                if (categoryButton != null) {
                    categoryButton.setText(newCategoryName);
                }

                // Atualiza o painel de visualização de tarefas associadas à categoria
                JPanel categoryPanel = categoryPanels.get(categoryName);
                if (categoryPanel != null) {
                    categoryPanels.remove(categoryName); // Remove o painel antigo
                    categoryPanels.put(newCategoryName, categoryPanel); // Adiciona com o novo nome
                }
                // Atualiza a interface gráfica
                taskViewPanel.revalidate();
                taskViewPanel.repaint();
                JOptionPane.showMessageDialog(frame, "Category updated successfully.");
            } else {
                JOptionPane.showMessageDialog(frame, "Category not found or could not be updated.");
            }
        }
    }


    private JButton findCategoryButton(String categoryName) {
        for (Component component : topBar.getComponents()) {
            if (component instanceof JButton && ((JButton) component).getText().equals(categoryName)) {
                return (JButton) component;
            }
        }
        return null;
    }

    public void displayTasksForCategory(String categoryName) {
        JPanel categoryPanel = categoryPanels.get(categoryName);

        if (categoryPanel != null) {
            categoryPanel.removeAll(); // Limpar tarefas anteriores

            // Obter tarefas da categoria selecionada
            List<String> tasks = categoryTasks.get(categoryName);

            if (tasks != null) {
                for (String task : tasks) {
                    JLabel taskLabel = new JLabel(task);
                    taskLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
                    taskLabel.setForeground(Color.BLACK);
                    categoryPanel.add(taskLabel);
                }
            }

            categoryPanel.revalidate();
            categoryPanel.repaint();
        }
    }
    public void addCategoryToUI(String categoryName) {
        JButton categoryButton = new JButton(categoryName);
        categoryButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        categoryButton.setBackground(new Color(85, 85, 85));
        categoryButton.setForeground(Color.WHITE);
        categoryButton.setFocusPainted(false);
        categoryButton.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        categoryButton.addActionListener(e -> {
            cardLayout.show(taskViewPanel, categoryName);
            displayTasksForCategory(categoryName); // Mostrar tarefas da categoria selecionada
        });

        topBar.add(categoryButton);
        topBar.revalidate();
        topBar.repaint();

        JPanel categoryPanel = new JPanel();
        categoryPanel.setBackground(Color.LIGHT_GRAY);
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));

        categoryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        categoryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        categoryPanels.put(categoryName, categoryPanel);
        taskViewPanel.add(categoryPanel, categoryName);
    }

    public void addTaskToCategory(String categoryName, String task) {
        List<String> tasks = categoryTasks.get(categoryName);
        if (tasks != null) {
            tasks.add(task);
        }
    }

    public void carregarCategorias() {
        FileManager fileManager = new FileManager("src/data/data.txt");
        fileManager.loadData();
        fileManager.displayData();
        List<String> categories = fileManager.loadData();
        for (String category : categories) {
            categoryTasks.put(category, new ArrayList<>()); // Inicialmente, sem tarefas
            addCategoryToUI(category);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);

    }
}
