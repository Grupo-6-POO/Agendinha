package UI;

import services.FileManager;

import javax.swing.*;

public class FilePanel extends InterfaceGrafica{
    private String tipo;
    private String caminhoArquivo;

    public FilePanel(String tipo, String caminhoArquivo) {
        this.tipo = tipo;
        this.caminhoArquivo = caminhoArquivo;
    }

    @Override
    public JPanel mostrar() {
        FileManager fm = new FileManager(caminhoArquivo);
        JPanel panel = new JPanel();

        JButton lerArquivoScanner = new JButton("Ler " + tipo + " Scanner");
        lerArquivoScanner.addActionListener(e -> fm.lerArquivoScanner());
        return panel;
    }
}
