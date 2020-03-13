package aula.Thread.execicioBilheteria.controller;

import java.sql.Time;
import java.util.concurrent.Semaphore;

public class ThreadCompraIngresso extends Thread {

	private static int totalDeIngressos = 100;
	private Semaphore sema;
	private int id;

	public ThreadCompraIngresso(int id, Semaphore sema) {

		this.sema = sema;
		this.id = id;
	}

	@Override
	public void run() {

		if (loginSistema()) {

			System.out.println("Cliente " + id + " Conseguiu logar no sistema");

			if (processoDeCompra()) {

				System.out.println("Cliente " + id + " Conseguiu entrar no processo de compra");

				int ingressos = (int) ((Math.random() * 4) + 1);

				try {
					if (validarIngressos(ingressos)) {

						sema.acquire();
						System.out.println("Cliente " + id + " Comprou: " + ingressos + " restam: " + totalDeIngressos);

					}
				} catch (Exception e) {

					System.err.println("Erro na parada para imprimir a compra");
					
				} finally {
					sema.release();
				}
			} else {

				System.err.println("Cliente " + id + " acabou com o tempo do processo de compra");
			}

		} else {
			System.err.println("Cliente " + id + " não conseguiu logar");
		}

		super.run();
	}

	private boolean loginSistema() {

		double inicio;
		double fim;

		inicio = System.currentTimeMillis();

		try {
			sleep((int) ((Math.random() * 1950) + 51));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fim = System.currentTimeMillis();

		if ((fim - inicio) <= 1000) {
			return true;
		}
		return false;
	}

	private boolean processoDeCompra() {

		double inicio;
		double fim;

		inicio = System.currentTimeMillis();

		try {
			sleep((int) ((Math.random() * 1999) + 1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fim = System.currentTimeMillis();

		if ((fim - inicio) <= 2500) {
			return true;
		}
		return false;
	}

	private boolean validarIngressos(int ingressos) {

		if (ingressos <= totalDeIngressos) {
			totalDeIngressos -= ingressos;
			return true;
		}

		return false;
	}

}
