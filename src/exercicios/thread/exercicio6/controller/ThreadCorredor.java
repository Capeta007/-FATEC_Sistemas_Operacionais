package exercicios.thread.exercicio6.controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread{

	private Semaphore sema;
	private int idCorredor;
	
	public ThreadCorredor(int idCorredor, Semaphore sema) {
		
		this.idCorredor = idCorredor;
		this.sema = sema;
	}
	
	@Override
	public void run() {
		
		corredor();
		
		try {
			sema.acquire();
			porta();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
		    sema.release();
		}
		
		
		super.run();
	}
	
	private void corredor() {
		int corredor = 200;
		int velo = (int)((Math.random()*3)+4);
		int distanciaPercorrida = 0;
		
		while(distanciaPercorrida < corredor) {
			distanciaPercorrida += velo;
			try {
				sleep(1000);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("Corredor de N°:" + idCorredor + " --Fala: Dá licença na moral !!!");
		
	}
	
	private void porta() {
		
		System.out.println("Corredor de N°:" + idCorredor + "  Entrou na Porta");
		
		try {
			sleep((int)((Math.random()*1001)+1000));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Corredor de N°:" + idCorredor + "  Saiu da Porta");

	}
	
}
