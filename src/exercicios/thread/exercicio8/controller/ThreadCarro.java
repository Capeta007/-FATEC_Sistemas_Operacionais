package exercicios.thread.exercicio8.controller;

import java.util.concurrent.Semaphore;

import exercicios.thread.exercicio8.entities.Carro;

public class ThreadCarro extends Thread {

	private static Semaphore vagasPista = new Semaphore(5);
	private static Semaphore vagaGrid = new Semaphore(1);
	private Carro car;

	public ThreadCarro(Carro car) {
		this.car = car;
	}

	@Override
	public void run() {

		try {
			car.getVagaEquipe().acquire();
			verificarVagaPista();

		} catch (Exception e) {
            e.printStackTrace();
		} finally {
			car.getVagaEquipe().release();
		}

		super.run();
	}

	private void verificarVagaPista() {

		try {
			vagasPista.acquire();
			System.err.println("O Carro " + car.getIdCarro() + " da equipe " + car.getEscuderia() + " est� na pista");
			long inicio;
			long fim;
			for (int i = 1; i <= 3; i++) {

			    inicio = System.currentTimeMillis();
				correr();
				fim = System.currentTimeMillis();
				
				System.out.println("O carro " + car.getIdCarro() + " da equipe " + car.getEscuderia() + " ficou com tempo: "
						+ (fim-inicio) + "ms na " + i + "� volta");
				if(car.getTimeAbsolut() == 0 || car.getTimeAbsolut() > (fim - inicio)) {
					car.setTime(fim - inicio);
				}
			}
			

			GridDeLargada.placar(car);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			vagasPista.release();
		}

	}

	private void correr() {
		int tamanhoDaPista = 4309;
		int totalPercorrido = 0;

		while (tamanhoDaPista > totalPercorrido) {

			
			totalPercorrido += (int) ((Math.random() * 400) + 1);

			
			try {
				sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
