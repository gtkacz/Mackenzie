package src.br.mackenzie.fci.progsis.code;

import src.br.mackenzie.fci.progsis.code.core.*;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    private static Estoque estoque = new Estoque();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Remover produto");
            System.out.println("3. Vender produto");
            System.out.println("4. Salvar estoque");
            System.out.println("5. Carregar estoque");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    removerProduto();
                    break;
                case 3:
                    venderProduto();
                    break;
                case 4:
                    estoque.salvarEstoque();
                    System.out.println("Estoque salvo com sucesso!");
                    break;
                case 5:
                    estoque.carregarEstoque();
                    System.out.println("Estoque carregado com sucesso!");
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void adicionarProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        String dataFabricacaoStr;
        LocalDate dataFabricacao;

        while (true) {
            try {
                System.out.print("Data de fabricação (AAAA-MM-DD): ");
                dataFabricacaoStr = scanner.nextLine();
                dataFabricacao = LocalDate.parse(dataFabricacaoStr);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Data em formato inválido, tente novamente.");
            }
        }

        System.out.print("O produto é perecível? (true/false): ");
        boolean perecivel = scanner.nextBoolean();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(nome, preco, dataFabricacao, perecivel);
        estoque.adicionarProduto(produto, quantidade);
        System.out.println("Produto adicionado ao estoque com sucesso!");
    }

    private static void removerProduto() {
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();

        for (ItemEstoque item : estoque.getItens()) {
            if (item.getProduto().getNome().equals(nome)) {
                estoque.removerProduto(item.getProduto(), quantidade);
                System.out.println("Produto removido do estoque com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado no estoque!");
    }

    private static void venderProduto() {
        System.out.println("Produtos disponíveis no estoque: ");

        if (estoque.getItens().isEmpty()) {
            System.out.println("Nenhum produto disponível no estoque!");
            return;
        }

        for (ItemEstoque item : estoque.getItens()) {
            int id = estoque.getItens().indexOf(item);
            System.out.println(id + ". " + item.getProduto().getNome() + " - " + item.getQuantidade() + " unidades");
        }

        System.out.print("Escolha o produto: ");
        int id = scanner.nextInt();

        ItemEstoque item = estoque.getItens().get(id);

        estoque.venderProduto(item.getProduto(), item.getQuantidade(), LocalDate.now());
    }
}
