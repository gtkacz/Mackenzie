import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class GerenciadorNomesMem implements GerenciadorNomes {
    private List<String> nomes = new ArrayList<String>();

    @Override
    public List<String> obterNomes() {
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        nomes.add(nome);
    }
}