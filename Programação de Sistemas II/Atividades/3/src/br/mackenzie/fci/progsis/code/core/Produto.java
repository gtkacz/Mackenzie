package src.br.mackenzie.fci.progsis.code.core;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
import java.time.LocalDate;
import java.io.Serializable;

public class Produto implements Serializable {
    private String nome;
    private double preco;
    private LocalDate dataFabricacao;
    private boolean perecivel;

    public Produto(String nome, double preco, LocalDate dataFabricacao, boolean perecivel) {
        this.nome = nome;
        this.preco = preco;
        this.dataFabricacao = dataFabricacao;
        this.perecivel = perecivel;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public LocalDate getDataFabricacao() {
        return dataFabricacao;
    }

    public boolean isPerecivel() {
        return perecivel;
    }
}
