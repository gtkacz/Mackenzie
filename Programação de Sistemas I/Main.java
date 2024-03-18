import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Venda venda1 = new Venda("987.654.321-09", "Consumidor Final");

        Produto refrigerante = new Produto(1, "Refrigerante", 4.79);
        venda1.adicionarProduto(refrigerante, 3);

        Produto amendoim = new Produto(2, "Amendoim salgado", 2.83);
        venda1.adicionarProduto(amendoim, 4);

        Produto bis = new Produto(3, "Chocolate BIS", 7.42);
        venda1.adicionarProduto(bis, 1);

        venda1.imprimirCupomFiscal();

        Venda venda2 = new Venda("123.456.789-00", "Cliente 2");
        Produto produto2 = new Produto(4, "Produto 2", 10.0);
        venda2.adicionarProduto(produto2, 5);

        venda2.imprimirCupomFiscal();
    }
}

class Produto {
    private int codigo;
    private String descricao;
    private double valorUnitario;

    public Produto(int codigo, String descricao, double valorUnitario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }
}

class Venda {
    private String cpf;
    private String nomeCliente;
    private List<Produto> produtos;
    private List<Integer> quantidades;

    public Venda(String cpf, String nomeCliente) {
        this.cpf = cpf;
        this.nomeCliente = nomeCliente;
        this.produtos = new ArrayList<>();
        this.quantidades = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        produtos.add(produto);
        quantidades.add(quantidade);
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            total += produtos.get(i).getValorUnitario() * quantidades.get(i);
        }
        return total;
    }

    public void imprimirCupomFiscal() {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("------------------------------------------");
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nomeCliente);
        System.out.println("------------------------------------------");

        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            int quantidade = quantidades.get(i);
            double subtotal = produto.getValorUnitario() * quantidade;

            System.out.println((i + 1) + ". " + produto.getDescricao() +
                    "\t" + quantidade + " un.\t" + df.format(produto.getValorUnitario()) +
                    "\tR$ " + df.format(subtotal));
        }

        System.out.println("------------------------------------------");
        System.out.println("Total a pagar: R$ " + df.format(calcularTotal()));
        System.out.println("------------------------------------------");
    }
}
