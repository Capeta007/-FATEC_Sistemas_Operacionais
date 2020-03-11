package exercicios.thread.exercicio7.view;

import java.util.concurrent.Semaphore;

import exercicios.thread.exercicio7.controller.ThreadCarro;


public class TreinoFormula1 {
	
	public static void main(String[] args) {
		
		String[] direcoes = new String[] {"N","S","L","O"};
		Semaphore sema = new Semaphore(1);
		
		for (int i = 1; i <= 1000; i++) {
			Thread tc = new ThreadCarro(i, direcoes[((int)((Math.random()*4)))], sema);
			tc.start();
		}
		
	}

}
