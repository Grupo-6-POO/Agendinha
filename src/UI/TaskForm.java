package UI;

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

public class TaskForm {
    public static void main(String[] args) {

        Manager<Task> taskManager = new TaskManager(); //Instancia de objeto Polimórfica
        Calendar calendar = new Calendar();

        JFrame frame = new JFrame("Adicionar Task: ");
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Painel principal com BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Painel do formulário centralizado com GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "ADICIONAR TASK:", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Roboto", Font.BOLD, 26), Color.DARK_GRAY));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaçamento entre os elementos
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //Campo Titulo
        JLabel title = new JLabel("Título Task:");
        title.setFont(new Font("Roboto", Font.PLAIN, 14));
        title.setForeground(Color.DARK_GRAY);

        JPasswordField titleField = new JPasswordField(15);
        titleField.setFont(new Font("Arial", Font.PLAIN, 14));
        titleField.setBorder(BorderFactory.createCompoundBorder(titleField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(title, gbc);

        gbc.gridx = 1;
        formPanel.add(titleField, gbc);


        //Campo Prioridade
        JLabel priority = new JLabel("Prioridade:");
        priority.setFont(new Font("Roboto", Font.PLAIN, 14));
        priority.setForeground(Color.DARK_GRAY);

        String[] prioridade = { "NULL","LOW", "MEDIUM", "HIGH"};
        JComboBox<String> comboBox = new JComboBox<>(prioridade);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(priority, gbc);

        gbc.gridx = 1;
        formPanel.add(comboBox, gbc);


        //Campo Status
        JLabel status = new JLabel("Status:");
        status.setFont(new Font("Roboto", Font.PLAIN, 14));
        status.setForeground(Color.DARK_GRAY);

        String[] statusTask = { "NULL","PENDING", "IN_ PROGRESS", "CONCLUDED"};
        JComboBox<String> comboBox2 = new JComboBox<>(statusTask);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(status, gbc);

        gbc.gridx = 1;
        formPanel.add(comboBox2, gbc);

        //Campo Prazo:
        JLabel prazo = new JLabel("Definir Prazo:");
        prazo.setFont(new Font("Roboto", Font.PLAIN, 14));
        prazo.setForeground(Color.DARK_GRAY);

        JButton selectPrazo = new JButton("Selecione o Prazo:");
        selectPrazo.setFont(new Font("Roboto", Font.BOLD, 14));
        selectPrazo.setBackground(new Color(0, 20, 100));
        selectPrazo.setForeground(Color.WHITE);
        selectPrazo.setFocusPainted(false);
        selectPrazo.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(prazo, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 0;
        formPanel.add(selectPrazo, gbc);


        // Botão de login estilizado
        JButton addButton = new JButton("Adicionar Task");
        addButton.setFont(new Font("Roboto", Font.BOLD, 14));
        addButton.setBackground(new Color(0, 100, 90));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));


        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(addButton, gbc);



        // Adiciona o painel principal ao frame
        mainPanel.add(formPanel, BorderLayout.CENTER);
        frame.add(mainPanel);



        // Ação de Add
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = titleField.getText();
                String selectedOption = (String) comboBox.getSelectedItem();
                String selectedOption2 = (String) comboBox2.getSelectedItem();

                // Ação Selecionar prazo:
                selectPrazo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LocalDate prazoField = calendar.verifyDeadLine();
                    }
                });
                if (titulo != null && !titulo.trim().isEmpty()) {
                    Task task;
                    try {
                        addButton.addActionListener(event -> taskManager.add(Task task));// Método de verificação do usuário
                        JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                        frame.dispose();
                        new Menu();
                    } catch (ManagerException ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Invalid Login", JOptionPane.ERROR_MESSAGE);
                    }
                }
                System.out.println("Opção selecionada: " + selectedOption);
                System.out.println("Opção selecionada: " + selectedOption2);
            }
        });

        frame.setVisible(true);
    }


}
