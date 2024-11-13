package UI;

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
    private Map<String, JPanel> categoryPanels;

    public Menu() {
        frame = new JFrame("Agendinha");
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        categoryPanels = new HashMap<>();

        frame.setLayout(new BorderLayout());

        // Configurações Visuais dos Componentes
        configureSidebar();
        configureTopBar();
        configureTaskViewPanel();

        frame.setVisible(true);
    }

    private void configureSidebar() {
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(50, 50, 50));
        sidebar.setPreferredSize(new Dimension(150, 600));
        sidebar.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JLabel sidebarTitle = new JLabel("Categories");
        sidebarTitle.setForeground(Color.WHITE);
        sidebarTitle.setFont(new Font("Roboto", Font.BOLD, 18));
        sidebarTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton addCategoryButton = new JButton("Add Category");
        addCategoryButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        addCategoryButton.setBackground(new Color(70, 130, 180));
        addCategoryButton.setForeground(Color.WHITE);
        addCategoryButton.setFocusPainted(false);
        addCategoryButton.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        addCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        addCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newCategory = JOptionPane.showInputDialog(frame, "New category name:");
                if (newCategory != null && !newCategory.trim().isEmpty()) {
                    addCategory(newCategory);
                }
            }
        });

        sidebar.add(sidebarTitle);
        sidebar.add(Box.createVerticalStrut(20));
        sidebar.add(addCategoryButton);
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

    private void addCategory(String categoryName) {
        JButton categoryButton = new JButton(categoryName);
        categoryButton.setFont(new Font("Roboto", Font.PLAIN, 14));
        categoryButton.setBackground(new Color(85, 85, 85));
        categoryButton.setForeground(Color.WHITE);
        categoryButton.setFocusPainted(false);
        categoryButton.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        categoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(taskViewPanel, categoryName);
            }
        });
        topBar.add(categoryButton);
        topBar.revalidate();
        topBar.repaint();

        JPanel categoryPanel = new JPanel();
        categoryPanel.setBackground(Color.LIGHT_GRAY);
        categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
        categoryPanel.add(new JLabel("Tasks for: " + categoryName));
        categoryPanel.setFont(new Font("Roboto", Font.BOLD, 24));
        categoryPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(1, 1, 1, 1),
                BorderFactory.createLineBorder(Color.BLACK, 3, true)
        ));

        categoryPanels.put(categoryName, categoryPanel);
        taskViewPanel.add(categoryPanel, categoryName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu());
    }
}
