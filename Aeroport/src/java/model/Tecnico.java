package model;

public class Tecnico {
	private int nmatricula;
	private String telefone;
	private float salario;
	private String endereco;
	private int nmembro;
	private String nome;
	private String codmodelo;
	private Sindicato sindicato;
	private Modelo modelo;
	
	public Sindicato getSindicato() {
		return sindicato;
	}
	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public int getNmatricula() {
		return nmatricula;
	}
	public void setNmatricula(int nmatricula) {
		this.nmatricula = nmatricula;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNmembro() {
		return nmembro;
	}
	public void setNmembro(int nmembro) {
		this.nmembro = nmembro;
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
}
