package UI;

import Enums.Priority;
import entities.Calendar;
import entities.Task;
import exceptions.ManagerException;
import services.Manager;
import services.TaskManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class TaskForm {
    private Menu menu; // Referência para o Menu
    private Manager<Task> taskManager = new TaskManager(); // Instância de TaskManager
    private Calendar calendar = new Calendar();

    public TaskForm(Menu menu) {
        this.menu = menu; // Guardar referência do menu
        JFrame frame = new JFrame("Add Task");
        frame.setSize(500, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Painel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Painel de formulário
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "ADICIONAR TASK:", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Roboto", Font.BOLD, 20), Color.DARK_GRAY));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campo Nome da Task
        JLabel title = new JLabel("Nome Task:");
        JTextField taskField = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(title, gbc);
        gbc.gridx = 1;
        formPanel.add(taskField, gbc);

        // Campo Categoria
        JLabel categoryLabel = new JLabel("Categoria:");
        List<String> categories = menu.getCategoryTasks().keySet().stream().toList();
        JComboBox<String> categoryComboBox = new JComboBox<>(categories.toArray(new String[0]));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(categoryLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(categoryComboBox, gbc);

        // Campo Prioridade
        JLabel priority = new JLabel("Prioridade:");
        String[] prioridade = {"NULL", "LOW", "MEDIUM", "HIGH"};
        JComboBox<String> priorityBox = new JComboBox<>(prioridade);
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(priority, gbc);
        gbc.gridx = 1;
        formPanel.add(priorityBox, gbc);

        // Botão Selecionar Prazo
        JLabel prazo = new JLabel("Definir Prazo:");
        JButton selectPrazo = new JButton("Selecione o Prazo");
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(prazo, gbc);
        gbc.gridx = 1;
        formPanel.add(selectPrazo, gbc);

        // Botão Adicionar Task
        JButton adicionarTask = new JButton("Adicionar Task");
        adicionarTask.setBackground(new Color(0, 100, 90));
        adicionarTask.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        formPanel.add(adicionarTask, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        frame.add(mainPanel);

        // Ação ao clicar em "Adicionar Task"
        adicionarTask.addActionListener(e -> {
            String titulo = taskField.getText();
            String categoria = (String) categoryComboBox.getSelectedItem();

            if (titulo != null && !titulo.trim().isEmpty()) {
                Task task = new Task();
                task.setTitle(titulo);
                task.setPriority(Priority.valueOf(priorityBox.getSelectedItem().toString()));

                try {
                    taskManager.add(task);
                    menu.addTaskToCategory(categoria, titulo); // Adiciona tarefa à categoria
                    JOptionPane.showMessageDialog(frame, "Task adicionada!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    frame.dispose();
                } catch (ManagerException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Título é obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
