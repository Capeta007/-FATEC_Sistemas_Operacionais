package controller;

public class ThreadPegandoId extends Thread{
	
	private int id = 0;
	
	public ThreadPegandoId(int id) {
		
		this.id = id;
		
	}
	
	@Override
	public void run() {
		
	    escreve();
		
	}

	private void escreve() {

       System.out.println("getId = " + getId() + " || id: " + id);
		
	}
	

}
