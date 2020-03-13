package aula.Thread.execicioCassino.controller;

import java.util.concurrent.Semaphore;

import aula.Thread.execicioCassino.view.Cassino;

public class ThreadJogo extends Thread {

	private int pontuacao = 0;
	private int id;
	private Semaphore sema;

	public ThreadJogo(int id, Semaphore sema) {

		this.sema = sema;
		this.id = id;

	}

	@Override
	public void run() {

		while (pontuacao < 5) {

			jogarDados();

		}

		try {
			sema.acquire();
			if (Cassino.posicao == 0) {
				System.out.println("O jogador n°:" + id + " Ganhou o premio de R$5000");
				Cassino.posicao++;
			} else if (Cassino.posicao == 1) {
				System.out.println("O jogador n°:" + id + " Ganhou o premio de R$4000");
				Cassino.posicao++;
			} else if (Cassino.posicao == 2) {
				System.out.println("O jogador n°:" + id + " Ganhou o premio de R$3000");
				Cassino.posicao++;
			} else {
				System.out.println("O jogador n°:" + id + " Ganhou o premio de R$0");
				Cassino.posicao++;
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sema.release();
		}

		super.run();
	}

	private void jogarDados() {

		int dado1;
		int dado2;
		int soma;

		dado1 = (int) ((Math.random() * 6) + 1);
		dado2 = (int) ((Math.random() * 6) + 1);
		soma = dado1 + dado2;

		if (soma == 7 || soma == 11) {
			pontuacao++;
		}

	}
}
