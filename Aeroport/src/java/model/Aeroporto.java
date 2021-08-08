package model;

public class Aeroporto {
	private String nome;
	private String endereco;
	private int naviões;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getNaviões() {
		return naviões;
	}
	public void setNaviões(int naviões) {
		this.naviões = naviões;
	}
	public String toString() {
		return "nome = "+nome+" endereco = "+endereco;
	}

}