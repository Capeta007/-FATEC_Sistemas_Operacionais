package exercicios.thread.exercicio4.controller;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class ThreadCarroDrag extends Thread{

	private String car;
	private int tamanho;
	private int distanciaPercorrida;
	private int puloMaximo;
	private JTextField primeiro;
	private JTextField segundo;
	private JLabel carro;
	private int y;
	private int x;
	
	public ThreadCarroDrag(String car, JLabel carro ,int tamanho, int puloMaximo, JTextField primeiro, JTextField segundo, int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.carro = carro;
		this.car = car;
		this.tamanho = tamanho;
		this.puloMaximo = puloMaximo;
		this.primeiro = primeiro;
		this.segundo = segundo;
	}

	@Override
	public void run() {
		
		pular();
		
		super.run();
	}

	private void pular() {
		
		distanciaPercorrida = 0;
		
		while(distanciaPercorrida < tamanho) {
			distanciaPercorrida += (int)(Math.random()*puloMaximo);
			carro.setLocation(distanciaPercorrida+x, y);
			try {
				sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		if(primeiro.getText().isEmpty()) {
			primeiro.setText(" "+car);
			primeiro.setFont(new Font("arial", 1, 17));
			primeiro.setBackground(Color.BLUE);
		}else {
			segundo.setText(" "+car);
			segundo.setFont(new Font("arial", 1, 17));
			segundo.setBackground(Color.RED);
		}
		
	}	
}
