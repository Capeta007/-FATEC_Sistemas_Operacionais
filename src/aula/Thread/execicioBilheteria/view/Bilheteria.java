package aula.Thread.execicioBilheteria.view;

import java.util.concurrent.Semaphore;

import aula.Thread.execicioBilheteria.controller.ThreadCompraIngresso;

public class Bilheteria {

	public static void main(String[] args) {
		
		Semaphore sema = new Semaphore(1);
		
		for (int i = 1; i <= 300; i++) {
			Thread comprar = new ThreadCompraIngresso(i,sema);
			comprar.start();
			
		}

	}

}
