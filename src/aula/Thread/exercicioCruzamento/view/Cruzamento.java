package aula.Thread.exercicioCruzamento.view;

import java.util.concurrent.Semaphore;

import aula.Thread.exercicioCruzamento.controller.ThreadCruzamento;

public class Cruzamento {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		
		Thread tc = new ThreadCruzamento(1,"N", "S", semaforo);
		tc.start();
		tc = new ThreadCruzamento(2,"S", "N", semaforo);
		tc.start();
		tc = new ThreadCruzamento(3,"L", "O", semaforo);
		tc.start();
		tc = new ThreadCruzamento(4,"O", "L", semaforo);
		tc.start();

	}

}
