package exercicios.thread.exercicio8.view;

import java.util.concurrent.Semaphore;

import exercicios.thread.exercicio8.controller.ThreadCarro;

public class TreinoFormula1 {
	
	public static void main(String[] args) {
		
		Semaphore vagasPista = new Semaphore(5);
	    String[] escuderias = {"Mercedes", "Ferrari", "RBR-Honda", "McLaren-Renault", "Renault", "Alpha Touri-Honda", "Alpha-Romeo"};
	    Thread carro;
	    Semaphore vagaEquipe;
	    Semaphore vagaGrip;
	    int idCarro = 1;
	    for (String escuderia : escuderias) {
	    	vagaEquipe = new Semaphore(1);
	    	vagaGrip = new Semaphore(1);
			carro = new ThreadCarro(escuderia, idCarro, vagasPista, vagaEquipe, vagaGrip);
			carro.start();
			idCarro++;
			carro = new ThreadCarro(escuderia, idCarro, vagasPista, vagaEquipe, vagaGrip);
			carro.start();
			idCarro++;
		}
		
	}

}
