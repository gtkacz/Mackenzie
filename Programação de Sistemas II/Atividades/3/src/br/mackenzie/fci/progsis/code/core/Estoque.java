package src.br.mackenzie.fci.progsis.code.core;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class Estoque {
    private List<ItemEstoque> itens;

    public Estoque() {
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        itens.add(new ItemEstoque(produto, quantidade));
    }

    public void removerProduto(Produto produto, int quantidade) {
        for (ItemEstoque item : itens) {
            if (item.getProduto().equals(produto)) {
                item.removerQuantidade(quantidade);
                if (item.getQuantidade() <= 0) {
                    itens.remove(item);
                }
                return;
            }
        }
    }

    public void venderProduto(Produto produto, int quantidade, LocalDate dataVenda) {
        removerProduto(produto, quantidade);
        registrarVenda(produto, quantidade, dataVenda);
    }

    public void registrarVenda(Produto produto, int quantidade, LocalDate dataVenda) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true));
            writer.write("Data da venda: " + dataVenda.toString() + "\n");
            writer.write("Produto: " + produto.getNome() + " Quantidade: " + quantidade + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarEstoque() {
        try {
            File file = new File("estoque.txt");
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Nome,Preço,Data de Fabricação,Perecível,Quantidade");
            bw.newLine();

            for (ItemEstoque item : itens) {
                Produto produto = item.getProduto();
                bw.write(produto.getNome() + "," + produto.getPreco() + "," + produto.getDataFabricacao() + ","
                        + produto.isPerecivel() + "," + item.getQuantidade());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarEstoque() {
        try {
            File file = new File("estoque.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String nome = fields[0];
                double preco = Double.parseDouble(fields[1]);
                LocalDate dataFabricacao = LocalDate.parse(fields[2]);
                boolean perecivel = Boolean.parseBoolean(fields[3]);
                int quantidade = Integer.parseInt(fields[4]);

                Produto produto = new Produto(nome, preco, dataFabricacao, perecivel);
                adicionarProduto(produto, quantidade);

                line = br.readLine();
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ItemEstoque> getItens() {
        return itens;
    }
}
