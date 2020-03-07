package exercicios.thread.exercicio5.controller;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import javax.swing.JTextField;

import exercicios.thread.exercicio5.view.TelaJogo;

public class ThreadRodando extends Thread{
	
	
	private Semaphore sema;
	private JTextField caixa;
	
	
	public ThreadRodando(JTextField caixa,Semaphore sema) {

		this.caixa = caixa;
		this.sema = sema;
	}
	
	@Override
	public void run() {
		

		try {
			sema.acquire();
			girar();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sema.release();
		}
		
		
		super.run();
	}

	private void girar() {
		
		for (int i = 0; i < 150; i++) {
			caixa.setText(""+((int)((Math.random()*7)+1)));
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	

}
