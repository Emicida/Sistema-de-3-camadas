package model;

public class Aviao {
	private int registro;
	private String nome;
	private String codmodelo;
	private Modelo modelo;
	private Aeroporto aeroporto;
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodmodelo() {
		return codmodelo;
	}
	public void setCodmodelo(String codmodelo) {
		this.codmodelo = codmodelo;
	}
	public Aeroporto getAeroporto() {
		return aeroporto;
	}
	public void setAeroporto(Aeroporto aeroporto) {
		this.aeroporto = aeroporto;
	}
	
}
