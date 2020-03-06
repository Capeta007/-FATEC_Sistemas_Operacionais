package aula.Thread.exemploEstacionamento.controller;

import java.util.concurrent.Semaphore;

public class ThreadCar extends Thread{
	
	private int idCar;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;

	public ThreadCar(int idCar, Semaphore semaforo) {
	    
		this.semaforo = semaforo;
		this.idCar = idCar;
	}
	
	
	@Override
	public void run() {
		
		carroAndando();
		
		try {
			semaforo.acquire();
			carroEstacionando();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
			carroSaindo();
		}
		
		
		
		
		
		
	}

 
	private void carroAndando() {
		int distanciaTotal = (int)((Math.random()*2001)+1000);
		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 30;
		
		while(distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Carro #" + idCar + " já percorreu " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("Carro #"+ idCar + " foi o "+ posChegada+"o. a chegar");
	}
	
	private void carroEstacionando() {
		
		System.out.println("Carro #" + idCar + " estacionou");
		int tempo = (int)((Math.random()*2001)+2000);
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void carroSaindo() {
		
		posSaida++;
		System.out.println("Carro #" + idCar + " foi o "+ posSaida + "o. a sair");
		
	}


	


	
}
