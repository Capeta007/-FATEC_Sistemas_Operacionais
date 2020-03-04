package exercicios.thread.exercicio3.controller;

import java.util.ArrayList;

public class ThreadSapo extends Thread{
	
	private int id;
	private int tamanho;
	private int distanciaPercorrida;
	private int puloMaximo;
    private Colocacao col;
	
	public ThreadSapo(int id,int tamanho, int puloMaximo, Colocacao col) {
		this.tamanho = tamanho;
		this.puloMaximo = puloMaximo;
		this.id = id;
		this.col = col;
	}
	
	@Override
	public void run() {
		
		pular();
		
		super.run();
	}

	private void pular() {
		
		while(distanciaPercorrida < tamanho) {
			distanciaPercorrida += (int)(Math.random()*puloMaximo);
			try {
				sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		col.add(id);
		
		
	}
	

}
