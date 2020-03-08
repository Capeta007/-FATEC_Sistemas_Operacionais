package exercicios.thread.exercicio6.view;

import java.util.concurrent.Semaphore;

import exercicios.thread.exercicio6.controller.ThreadCorredor;

public class TestCorredor {

	public static void main(String[] args) {
		
		Semaphore sema = new Semaphore(1);
		
		for (int i = 1; i <= 10; i++) {
			Thread corredor = new ThreadCorredor(i, sema);
			corredor.start();
			 
		}

	}

}
