package entities;
import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Calendar  {
    private JFrame frame;


    public Calendar() {
    }

    public static void verifyInicialDeadLine(){
        getCurrentDay();

    }
    public LocalDate verifyDeadLine(){
        String deadLine = JOptionPane.showInputDialog(frame, "Digite o prazo final (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define o formato esperado

        try {
            // Converte a string para LocalDate usando o formato especificado
            LocalDate date = LocalDate.parse(deadLine, formatter);
            System.out.println(date);
            return date;
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida! Por favor, use o formato dd/MM/yyyy.");
            return null;
        }

    }

    public static void getCurrentDay() {
        LocalDate today = LocalDate.now(); //Retorna a data atual
        System.out.println(today );
    }



}
