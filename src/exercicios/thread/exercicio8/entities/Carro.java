package exercicios.thread.exercicio8.entities;

import java.text.DecimalFormat;
import java.util.concurrent.Semaphore;

public class Carro{

	private int idCarro;
	private String escuderia;
	private double tempo = 0;
	
	private Semaphore vagaEquipe;
	
	public Carro(String escuderia, int idCarro, Semaphore vagaEquipe) {
		super();
		this.escuderia = escuderia;
		this.idCarro = idCarro;
		this.vagaEquipe = vagaEquipe;
	}
	
	public String getEscuderia() {
		return escuderia;
	}
	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}
	public int getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}
	public double getTimeAbsolut() {
		return tempo;
	}
	public double getTimeSeconds() {
	    return tempo/1000;
	}
	public void setTime(double tempo) {
		this.tempo = tempo;
	}

	public Semaphore getVagaEquipe() {
		return vagaEquipe;
	}

	public void setVagaEquipe(Semaphore vagaEquipe) {
		this.vagaEquipe = vagaEquipe;
	}

	
}
