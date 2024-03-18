package src.br.mackenzie.fci.progsis.code.core;

import java.io.Serializable;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class ItemEstoque implements Serializable {
    private static final long serialVersionUID = 1L;

    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerQuantidade(int quantidade) {
        this.quantidade -= quantidade;
    }
}
