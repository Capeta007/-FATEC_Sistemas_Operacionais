package exercicios.thread.exercicio1.controller;

public class NumeroThread extends Thread {

	public NumeroThread() {
		
	}
	
	@Override
	public void run() {
		
		System.out.println(getNumero());
		
		super.run();
	}
	

	private long getNumero() {		return super.getId();
	}
}
