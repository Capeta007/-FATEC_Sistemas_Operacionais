package exercicios.thread.exercicio8.controller;

public class Piloto {

	private String escuderia;
	private int idCarro;
	private double tempo;
	
	public Piloto(String escuderia, int idCarro, double tempo) {
		super();
		this.escuderia = escuderia;
		this.idCarro = idCarro;
		this.tempo = tempo;
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
	public double getTempo() {
		return tempo;
	}
	public void setTempo(double tempo) {
		this.tempo = tempo;
	}
	
	
}
