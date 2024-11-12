package UI;

import javax.swing.*;

public class Home extends InterfaceGrafica{

    @Override
    public JPanel mostrar() {
        JPanel panel = new JPanel();

        JButton buttonTXT = new JButton("TXT");
        buttonTXT.addActionListener(e -> changePanel(new FilePanel("TXT","./data/data.txt").mostrar()));

        return panel;
    }
}
