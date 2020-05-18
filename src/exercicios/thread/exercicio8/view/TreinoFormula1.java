package exercicios.thread.exercicio8.view;

import java.util.concurrent.Semaphore;

import exercicios.thread.exercicio8.controller.ThreadCarro;
import exercicios.thread.exercicio8.entities.Carro;

public class TreinoFormula1 {
	
	public static void main(String[] args) {
		
		
	    String[] escuderias = {"Mercedes", "Ferrari", "RBR-Honda", "McLaren-Renault", "Renault", "Alpha Touri-Honda", "Alpha-Romeo"};
	    Thread carro;
	    int i = 0;
	    for (String escuderia : escuderias) {   	
	    	Semaphore vagaEquipe = new Semaphore(1);
	    	carro = new ThreadCarro(new Carro(escuderia, i, vagaEquipe));
			carro.start();
			carro = new ThreadCarro(new Carro(escuderia, i+1, vagaEquipe));
			carro.start();
			i= i + 2;
		}
	}

}
