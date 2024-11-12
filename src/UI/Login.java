package UI;

import UI.Menu;
import exceptions.ManagerException;
import services.UserManager;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public static void main(String[] args) {

        UserManager userManager = new UserManager();

        JFrame frame = new JFrame("Login");
        frame.setSize(400, 250);
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

        // Campos de usuário
        JLabel usuarioLabel = new JLabel("Username:");
        usuarioLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        usuarioLabel.setForeground(Color.DARK_GRAY);

        JTextField usuarioField = new JTextField(15);
        usuarioField.setFont(new Font("Arial", Font.PLAIN, 14));
        usuarioField.setBorder(BorderFactory.createCompoundBorder(usuarioField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Campos de senha
        JLabel senhaLabel = new JLabel("Password:");
        senhaLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
        senhaLabel.setForeground(Color.DARK_GRAY);

        JPasswordField senhaField = new JPasswordField(15);
        senhaField.setFont(new Font("Arial", Font.PLAIN, 14));
        senhaField.setBorder(BorderFactory.createCompoundBorder(senhaField.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        // Botão de login estilizado
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Roboto", Font.BOLD, 14));
        loginButton.setBackground(new Color(70, 130, 180));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Adicionando componentes ao formPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(usuarioLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(usuarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(senhaLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(senhaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(loginButton, gbc);

        // Adiciona o painel principal ao frame
        mainPanel.add(formPanel, BorderLayout.CENTER);
        frame.add(mainPanel);

        // Ação de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                try {
                    userManager.verifyLogin(usuario, senha); // Método de verificação do usuário
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

