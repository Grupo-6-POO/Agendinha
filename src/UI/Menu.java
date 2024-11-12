package UI;

import entities.Category;
import services.CategoryManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private JFrame frame;
    private JPanel sidebar;
    private JPanel topBar;
    private JPanel taskViewPanel;
    private CardLayout cardLayout;
    private Map<String, JPanel> categoryPanels;  // Armazena os painéis de cada categoria

    public Menu() {
        Category category = new Category();
        CategoryManager categoryManager = new CategoryManager();

        frame = new JFrame("Agendinha");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        categoryPanels = new HashMap<>();

        // Configura o layout da janela principal
        frame.setLayout(new BorderLayout());

        // Sidebar
        configureSidebar();

        // Barra superior de categorias
        configureTopBar();

        // Área de exibição das tarefas (painel central)
        configureTaskViewPanel();

        frame.setVisible(true);
    }

    // Configuração da sidebar
    private void configureSidebar() {
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(60, 63, 65));
        sidebar.setPreferredSize(new Dimension(120, 600));

        JButton addCategoryButton = new JButton("Add Category");
        addCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newCategory = JOptionPane.showInputDialog(frame, "Category name:");

                if (newCategory != null && !newCategory.trim().isEmpty()) {
                    addCategory(newCategory);
                }
            }
        });

        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(addCategoryButton);
        sidebar.add(Box.createVerticalGlue());

        frame.add(sidebar, BorderLayout.WEST);
    }

    // Configuração da barra superior de categorias
    private void configureTopBar() {
        topBar = new JPanel();
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topBar.setBackground(new Color(80, 85, 90));
        topBar.setPreferredSize(new Dimension(800, 50));

        frame.add(topBar, BorderLayout.NORTH);
    }

    // Configuração do painel de visualização de tarefas
    private void configureTaskViewPanel() {
        taskViewPanel = new JPanel();
        cardLayout = new CardLayout();
        taskViewPanel.setLayout(cardLayout);

        frame.add(taskViewPanel, BorderLayout.CENTER);
    }

    // Adiciona uma nova categoria
    private void addCategory(String categoryName) {
        JButton categoryButton = new JButton(categoryName);
        categoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(taskViewPanel, categoryName);
            }
        });
        topBar.add(categoryButton);
        topBar.revalidate();
        topBar.repaint();

        // Cria um painel para a nova categoria
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
        categoryPanel.add(new JLabel("Tasks for: " + categoryName));
        categoryPanels.put(categoryName, categoryPanel);

        taskViewPanel.add(categoryPanel, categoryName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu());
    }
}
