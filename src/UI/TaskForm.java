package UI;

import entities.Task;
import exceptions.ManagerException;
import services.TaskManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskForm {
    public static void main(String[] args) {

        Task taskManager = new TaskManager();

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
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "LOGIN", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Roboto", Font.BOLD, 36), Color.DARK_GRAY));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Espaçamento entre os elementos
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Descrição:");
        title.setFont(new Font("Roboto", Font.PLAIN, 14));
        title.setForeground(Color.DARK_GRAY);

        JPasswordField titleField = new JPasswordField(15);
        titleField.setFont(new Font("Arial", Font.PLAIN, 14));
        titleField.setBorder(BorderFactory.createCompoundBorder(titleField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));


        // Campos Descrição
        JLabel description = new JLabel("Descrição:");
        description.setFont(new Font("Roboto", Font.PLAIN, 14));
        description.setForeground(Color.DARK_GRAY);

        JPasswordField descriptionField = new JPasswordField(15);
        descriptionField.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionField.setBorder(BorderFactory.createCompoundBorder(descriptionField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Botão de login estilizado
        JButton addButton = new JButton("Login");
        addButton.setFont(new Font("Roboto", Font.BOLD, 14));
        addButton.setBackground(new Color(40, 40, 110));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));


        // Adicionando componentes ao formPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(title, gbc);

        gbc.gridx = 1;
        formPanel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(description, gbc);

        gbc.gridx = 1;
        formPanel.add(descriptionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(addButton, gbc);

        // Adiciona o painel principal ao frame
        mainPanel.add(formPanel, BorderLayout.CENTER);
        frame.add(mainPanel);

        // Ação de login
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = titleField.getText();
                String descricao = descriptionField.getText();

                try {
                    addButton.addActionListener(e -> taskManager.add());// Método de verificação do usuário
                    JOptionPane.showMessageDialog(frame, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    frame.dispose();
                    new Menu();
                } catch (ManagerException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Invalid Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }


}
