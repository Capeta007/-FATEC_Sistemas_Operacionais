package aula.Thread.execicioCassino.view;

import java.util.concurrent.Semaphore;

import aula.Thread.execicioCassino.controller.ThreadJogo;

public class Cassino {
	
	public static int posicao = 0;

	public static void main(String[] args) {
		
		ThreadJogo jogo = null;
		Semaphore sema = new Semaphore(1);
		
		for (int i = 1; i <= 10; i++) {
			
			 jogo = new ThreadJogo(i , sema);
			 jogo.start();
		}

	}

}
