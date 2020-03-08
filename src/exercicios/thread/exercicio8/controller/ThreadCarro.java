package exercicios.thread.exercicio8.controller;

import java.sql.Time;
import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{

	private Semaphore vagaPista;
	private Semaphore vagaEquipe;
	private Semaphore grid;
	private String escuderia;
	private int idCarro;
	
	public ThreadCarro(String escuderia, int idCarro, Semaphore vagaPista, Semaphore vagaEquipe, Semaphore grid) {
		
		this.grid = grid;
		this.idCarro = idCarro;
		this.escuderia = escuderia;
		this.vagaPista = vagaPista;
		this.vagaEquipe = vagaEquipe;
	
		
	}
	
	@Override
	public void run() {
		
		try {
			vagaEquipe.acquire();
			verificarVagaPista();
			
		} catch (Exception e) {
			
		}finally {
			vagaEquipe.release();
		}
		
		super.run();
	}

	private void verificarVagaPista() {
		
		try {
			vagaPista.acquire();
			long inicio = System.currentTimeMillis();
			correr();
			long fim  = System.currentTimeMillis();  
			System.out.println( "O carro " + idCarro + " da equipe " + escuderia + " ficou com tempo: " + ((fim - inicio)/1000) + " Galvão");
			double tempo = fim - inicio;
			grid.acquire();
			GridDeLargada.placar(escuderia, idCarro, tempo);
		} catch (Exception e) {
			System.err.println("Erro" + e);
		}finally {
			vagaPista.release();
			grid.release();
		}
		
		
	}

	private void correr() {
		System.out.println("O Carro " + idCarro + " da equipe " + escuderia + " está na pista galvão");
		int tamanhoDaPista = 1000;
		int totalPercorrido = 0;
		
		
		while((tamanhoDaPista*3) > totalPercorrido) {
			
			totalPercorrido += (int)((Math.random()*400)+1);
			
			try {
				sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
	}
}
