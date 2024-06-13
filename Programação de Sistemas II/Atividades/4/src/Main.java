package src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class Main {
    private static List<Time> times = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar time");
            System.out.println("2. Listar times");
            System.out.println("3. Salvar lista");
            System.out.println("4. Carregar lista");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarTime();
                    break;
                case 2:
                    listarTimes();
                    break;
                case 3:
                    salvarLista();
                    break;
                case 4:
                    carregarLista();
                    System.out.println("Lista carregada com sucesso!");
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarTime() {
        System.out.print("Nome do time: ");
        String nome = scanner.nextLine();

        System.out.print("Quantidade de títulos: ");
        int titulos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Estádio: ");
        String estadio = scanner.nextLine();

        Time time = new Time(nome, titulos, estadio);
        times.add(time);

        System.out.println("Time adicionado à lista com sucesso!");
    }

    private static void listarTimes() {
        if (times.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            System.out.println("Lista de times:");
            for (Time time : times) {
                System.out.println(time.getNome() + " - " + time.getTitulos() + " títulos - " + time.getEstadio());
            }
        }
    }

    private static void salvarLista() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write("Nome,Títulos,Estádio");
            bw.newLine();

            for (Time time : times) {
                bw.write(time.getNome() + "," + time.getTitulos() + "," + time.getEstadio());
                bw.newLine();
            }
            System.out.println("Lista salva com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void carregarLista() {
        times.clear();
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String nome = fields[0];
                int titulos = Integer.parseInt(fields[1]);
                String estadio = fields[2];
                Time time = new Time(nome, titulos, estadio);
                times.add(time);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
