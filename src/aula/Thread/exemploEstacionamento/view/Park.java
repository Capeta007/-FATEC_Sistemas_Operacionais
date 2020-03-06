package aula.Thread.exemploEstacionamento.view;

import java.util.concurrent.Semaphore;

import aula.Thread.exemploEstacionamento.controller.ThreadCar;

public class Park {

	public static void main(String[] args) {
		
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(3);
		
		for (int idCar = 0; idCar < 10; idCar++) {
			Thread car = new ThreadCar(idCar,semaforo);
			car.start();
		}

	}

}
