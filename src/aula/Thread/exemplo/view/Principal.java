package aula.Thread.exemplo.view;

import aula.Thread.exemplo.controller.ThreadCalcController;

public class Principal {
	
	public static void main(String[] args) {
		
		int a = 10;
		int b = 2;
		
		
		for(int operacao = 0; operacao < 4; operacao++) {
			Thread tcc = new ThreadCalcController(a, b, operacao);
			tcc.start();
		}
	}

}
