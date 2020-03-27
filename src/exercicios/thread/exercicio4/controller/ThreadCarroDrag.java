package exercicios.thread.exercicio4.controller;

import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
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
		
		
			correr();

		
		super.run();
	}

	private void correr() {
		
		distanciaPercorrida = 20;
		
		if(car.equals("sonic")) {
			carro.setIcon(new ImageIcon(getClass().getResource("img/sonicVelOne.gif")));
		}else {
			carro.setIcon(new ImageIcon(getClass().getResource("img/knucklesVelOne.gif")));
		}
		
		while(distanciaPercorrida < tamanho) {
			distanciaPercorrida += (int)(Math.random()*puloMaximo);
			carro.setLocation(distanciaPercorrida+x, y);
			if(distanciaPercorrida > 200) {
				
			
				if(car.equals("sonic")) {
					carro.setIcon(new ImageIcon(getClass().getResource("img/sonicVelTwo.gif")));
				}else {
					carro.setIcon(new ImageIcon(getClass().getResource("img/knucklesVelTwo.gif")));
				}
				
				
			}
			
			if(distanciaPercorrida+25 > tamanho) {
				if(car.equals("sonic")) {
					carro.setIcon(new ImageIcon(getClass().getResource("img/sonicPassou.gif")));
				}
			}
			
			try {
				sleep(100);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		try {
			sleep(300);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		registrar();
		
		
	}
	
	private void registrar() {
		
		if(primeiro.getText().isEmpty()) {
			primeiro.setText(" "+car);
			primeiro.setFont(new Font("arial", 1, 17));
			
			if(car.equals("sonic")) {
				carro.setIcon(new ImageIcon(getClass().getResource("img/sonicVenceu.gif")));
				carro.setLocation(850, y);
				primeiro.setBackground(Color.BLUE);
			}else {
				carro.setIcon(new ImageIcon(getClass().getResource("img/knucklesVenceu.gif")));
				carro.setLocation(850, y+22);
				primeiro.setBackground(Color.RED);
			}
			
		}else {
			segundo.setText(" "+car);
			segundo.setFont(new Font("arial", 1, 17));
			
			if(car.equals("sonic")) {
				carro.setLocation(850, y+11);
				carro.setIcon(new ImageIcon(getClass().getResource("img/sonicPerdeu.gif")));
				segundo.setBackground(Color.BLUE);
			}else {
				carro.setIcon(new ImageIcon(getClass().getResource("img/knucklesPerdeu.gif")));
				carro.setLocation(850, y+20);
				segundo.setBackground(Color.RED);
			}
			
		}
	}
}
