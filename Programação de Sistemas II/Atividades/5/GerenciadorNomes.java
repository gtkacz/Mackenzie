import java.util.List;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public interface GerenciadorNomes {
    int MAX_CARACTERES_NOMES = 20;

    List<String> obterNomes();

    void adicionarNome(String nome);
}