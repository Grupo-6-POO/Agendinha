package entities;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Calendar {
    private JFrame frame;

    public Calendar() {
    }


    public LocalDate verifyDeadLine() {
        LocalDate deadLineDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato esperado
        LocalDate today = LocalDate.now(); // Obtém a data de hoje

        while (deadLineDate == null) {
            String deadLine = JOptionPane.showInputDialog(null, "Digite o prazo final (dd/MM/yyyy): ");

            try {
                deadLineDate = LocalDate.parse(deadLine, formatter);
                if (deadLineDate.isBefore(today)) {
                    JOptionPane.showMessageDialog(null, "Data inválida. Tente novamente.");
                    deadLineDate = null; // Redefine para null para repetir o loop
                }
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Data inválida. Use o formato dd/MM/yyyy.");
            }
        }
        return deadLineDate;

    }




}
