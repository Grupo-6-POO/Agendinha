// Nova classe UpdateTask
package UI;

import entities.Calendar;
import entities.Task;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;


public class UpdateTask {
    private Menu menu; // Referência para o Menu
    private JFrame frame;
    private Task task;
    private Calendar calendar;
    private List<String> categories;
    private String[] prioridade;
    private String[] statusTask;



    public UpdateTask (Menu menu){
        this.menu = menu;
        // Painel de Atualização

        JFrame frame = new JFrame("Atualizar Task");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel updatePanel = new JPanel();
        updatePanel.setBorder(BorderFactory.createTitledBorder("Atualizar Task"));
        updatePanel.setLayout(new GridLayout(6, 1, 5, 5));

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "ATUALIZAR TASK:", TitledBorder.CENTER, TitledBorder.BELOW_TOP, new Font("Roboto", Font.BOLD, 20), Color.DARK_GRAY));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Botão para atualizar o Nome
        JButton updateNomeButton = new JButton("Atualizar Nome");
        updateNomeButton.setBackground(new Color(0, 100, 90));
        updateNomeButton.setForeground(Color.WHITE);
        updateNomeButton.addActionListener(e -> {
            String novoNome = JOptionPane.showInputDialog(frame, "Digite o novo nome:");
            if (novoNome != null && !novoNome.trim().isEmpty()) {
                task.setTitle(novoNome); // Atualiza o nome da Task
                JOptionPane.showMessageDialog(frame, "Nome atualizado com sucesso.");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        formPanel.add(updateNomeButton, gbc);

        // Botão para atualizar a Categoria
        JButton updateCategoriaButton = new JButton("Atualizar Categoria");
        updateCategoriaButton.setBackground(new Color(0, 100, 90));
        updateCategoriaButton.setForeground(Color.WHITE);
//        updateCategoriaButton.addActionListener(e -> {
//            String novaCategoria = (String) JOptionPane.showInputDialog(frame, "Escolha a nova categoria:",
//                    "Atualizar Categoria", JOptionPane.QUESTION_MESSAGE, null,
//                    categories.toArray(new String[0]), categories.get(0));
//            if (novaCategoria != null) {
//                task.setCategory(novaCategoria);
//                JOptionPane.showMessageDialog(frame, "Categoria atualizada com sucesso.");
//            }
//        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        formPanel.add(updateCategoriaButton, gbc);

        // Botão para atualizar a Prioridade
        JButton updatePrioridadeButton = new JButton("Atualizar Prioridade");
        updatePrioridadeButton.setBackground(new Color(0, 100, 90));
        updatePrioridadeButton.setForeground(Color.WHITE);
        updatePrioridadeButton.addActionListener(e -> {
            String novaPrioridade = (String) JOptionPane.showInputDialog(frame, "Escolha a nova prioridade:",
                    "Atualizar Prioridade", JOptionPane.QUESTION_MESSAGE, null, prioridade, prioridade[0]);
            if (novaPrioridade != null) {
                task.setPriority(novaPrioridade); // Atualiza a prioridade da Task
                JOptionPane.showMessageDialog(frame, "Prioridade atualizada com sucesso.");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        formPanel.add(updatePrioridadeButton, gbc);

        // Botão para atualizar o Status
        JButton updateStatusButton = new JButton("Atualizar Status");
        updateStatusButton.setBackground(new Color(0, 100, 90));
        updateStatusButton.setForeground(Color.WHITE);
        updateStatusButton.addActionListener(e -> {
            String novoStatus = (String) JOptionPane.showInputDialog(frame, "Escolha o novo status:",
                    "Atualizar Status", JOptionPane.QUESTION_MESSAGE, null, statusTask, statusTask[0]);
            if (novoStatus != null) {
                task.setStatus(novoStatus); // Atualiza o status da Task
                JOptionPane.showMessageDialog(frame, "Status atualizado com sucesso.");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3  ;
        gbc.gridwidth = 1;
        formPanel.add(updateStatusButton, gbc);


        // Botão para atualizar o Prazo
        JButton updatePrazoButton = new JButton("Atualizar Prazo");
        updatePrazoButton.setBackground(new Color(0, 100, 90));
        updatePrazoButton.setForeground(Color.WHITE);
        updatePrazoButton.addActionListener(e -> {
            LocalDate novoPrazo = calendar.verifyDeadLine();
            if (novoPrazo != null) {
                task.setDeadLine(novoPrazo); // Atualiza o prazo da Task
                JOptionPane.showMessageDialog(frame, "Prazo atualizado com sucesso.");
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 4  ;
        gbc.gridwidth = 1;
        formPanel.add(updatePrazoButton, gbc);

        updatePanel.add(formPanel, BorderLayout.CENTER);
        frame.add(updatePanel);

        frame.setVisible(true);
    }



}
