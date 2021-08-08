package model;
import java.sql.Date;

public class Testes {
	private int n_ANAC;
	private String nome;
	private Date datateste;
	private float nhoras;
	private float pontuação;
	private int nmatricula;
	private Tecnico tecnico;
	
	public int getN_ANAC() {
		return n_ANAC;
	}
	public void setN_ANAC(int n_ANAC) {
		this.n_ANAC = n_ANAC;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDatateste() {
		return datateste;
	}
	public void setDatateste(Date datateste) {
		this.datateste = datateste;
	}
	public float getNhoras() {
		return nhoras;
	}
	public void setNhoras(float nhoras) {
		this.nhoras = nhoras;
	}
	public float getPontuação() {
		return pontuação;
	}
	public void setPontuação(float pontuação) {
		this.pontuação = pontuação;
	}
	public int getNmatricula() {
		return nmatricula;
	}
	public void setNmatricula(int nmatricula) {
		this.nmatricula = nmatricula;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
}
