package src.br.mackenzie.fci.progsis.code.core;

/**
 *
 * @author Gabriel Mitelman Tkacz
 */
public class Time {
	private String nome;
	private int titulos;
	private String estadio;
	
	public Time(String nome, int titulos, String estadio) {
		this.nome = nome;
		this.titulos = titulos;
		this.estadio = estadio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTitulos() {
		return titulos;
	}

	public void setTitulos(int titulos) {
		this.titulos = titulos;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
}