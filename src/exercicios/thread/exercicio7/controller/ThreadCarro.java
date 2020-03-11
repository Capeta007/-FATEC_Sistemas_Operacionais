package exercicios.thread.exercicio7.controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{

	private String direcaoInicial;
	private ArrayList<String> direcoes = new ArrayList<String>();
	private int idCarro;
	private Semaphore sema;
	
	public ThreadCarro(int idCarro, String direcaoInicial, Semaphore sema) {
	
		this.idCarro = idCarro;
		this.direcaoInicial = direcaoInicial;
		this.sema = sema;
	
		this.direcoes.add("N");
		this.direcoes.add("S");
		this.direcoes.add("L");
		this.direcoes.add("O");
		
		this.direcoes.remove(direcaoInicial);
		
	}
	
	@Override
	public void run() {
		
		try {
			sema.acquire();
			
			
			encruzilhada(direcoes.get((int)((Math.random()*3))));
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sema.release();
		}
		
		
		super.run();
	}
	
	public void encruzilhada(String direcao) {
		
		System.out.println("Carro#" + idCarro + " Saindo de " + direcaoInicial + " indo para " + direcao);
		try {
			sleep(500);
		} catch (Exception e) {
			System.err.println("Erro no sleep");
		}
		
	}

	

	
}
