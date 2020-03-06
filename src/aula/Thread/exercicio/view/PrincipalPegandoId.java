package aula.Thread.exercicio.view;

import aula.Thread.exercicio.controller.ThreadPegandoId;

public class PrincipalPegandoId {

	public static void main(String[] args) throws InterruptedException {
		
		for(int id = 0; id < 100; id++) {
			
			Thread tpi = new ThreadPegandoId(id);
			
			tpi.start();	
	
		}
		
		
		
	}
	
}
