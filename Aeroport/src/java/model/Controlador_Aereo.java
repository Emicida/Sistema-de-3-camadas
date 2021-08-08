package model;
import java.sql.Date;

public class Controlador_Aereo {
	private int nmembro;
	private Date exame;
	private Sindicato sindicato;
	public Sindicato getSindicato() {
		return sindicato;
	}
	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}
	public int getNmembro() {
		return nmembro;
	}
	public void setNmembro(int nmembro) {
		this.nmembro = nmembro;
	}
	public Date getExame() {
		return exame;
	}
	public void setExame(Date exame) {
		this.exame = exame;
	}
}
