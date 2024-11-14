package services;
import java.io.*;
import entities.Task;
import entities.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    // Método para salvar dados no arquivo
    public void saveData(String data) {
        try (FileWriter writer = new FileWriter(filePath, true); // `true` para permitir append no arquivo
             BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(data);
            bw.newLine(); // Quebra de linha após cada entrada
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Método para recuperar todos os dados do arquivo
    public List<String> loadData() {
        List<String> dataList = new ArrayList<>();
        try (FileReader reader = new FileReader("src/data/data.txt");
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler dados: " + e.getMessage());
        }
        return dataList;
    }

    // Método para limpar o arquivo (caso queira começar do zero)
    public void clearData() {
        try (FileWriter writer = new FileWriter(filePath, false); // `false` para sobrescrever o conteúdo
             BufferedWriter bw = new BufferedWriter(writer)) {
            // Não escreve nada no arquivo, apenas apaga o conteúdo anterior
        } catch (IOException e) {
            System.out.println("Erro ao limpar dados: " + e.getMessage());
        }
    }

    // Método para exibir dados recuperados
    public void displayData() {
        List<String> data = loadData();
        for (String line : data) {
            System.out.println(line);
        }
    }

    // Apaga somente o dado desejado
    public void removeData(String dataToRemove) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.equals(dataToRemove)) { // Ignora a linha que queremos remover
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/data/data.txt", false))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao sobrescrever o arquivo: " + e.getMessage());
        }
    }



}
