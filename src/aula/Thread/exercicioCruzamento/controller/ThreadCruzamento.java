package aula.Thread.exercicioCruzamento.controller;

import java.util.concurrent.Semaphore;

public class ThreadCruzamento extends Thread{

	private int idCarro;
	private String direcaoSaida;
	private String direcaoEntrada;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public ThreadCruzamento(int idCarro, String direcaoEntrada, String direcaoSaida, Semaphore semaforo) {
		
		this.idCarro = idCarro;
		this.direcaoEntrada = direcaoEntrada;
		this.direcaoSaida = direcaoSaida;
		this.semaforo = semaforo;
		
	}
	
	@Override
	public void run() {
		
		posChegada++;

        try {
        	
        	semaforo.acquire();
        	
        	cruzamento();
        	
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			semaforo.release();
		}
        
        
		
	}

	private void cruzamento() {
		
		try {
			
			System.out.println("Carro #" + idCarro + " vindo de " + direcaoEntrada + " indo para " + direcaoSaida);
			sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		posSaida++;
	}
	
	
	
	
}
