import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
@Component
public class GerenciadorNomesBD implements GerenciadorNomes {
    private final JdbcTemplate jdbcTemplate;

    public GerenciadorNomesBD(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void createTableIfNotExists() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS nomes (nome VARCHAR(255))");
    }

    @Override
    public List<String> obterNomes() {
        return jdbcTemplate.query("SELECT nome FROM nomes", (rs, rowNum) -> rs.getString("nome"));
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() <= MAX_CARACTERES_NOMES) {
            jdbcTemplate.update("INSERT INTO nomes(nome) VALUES (?)", nome);
        } else {
            System.out.println("O nome excede o limite de caracteres permitido.");
        }
    }
}
