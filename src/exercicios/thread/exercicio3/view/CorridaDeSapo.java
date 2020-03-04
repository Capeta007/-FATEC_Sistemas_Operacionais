package exercicios.thread.exercicio3.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import exercicios.thread.exercicio3.controller.Colocacao;
import exercicios.thread.exercicio3.controller.ThreadSapo;

public class CorridaDeSapo {
	
	public static void main(String[] args) {
		
		int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho da corrida: "));
		int puloMaximo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do pulo máximo: "));
		
		
		Colocacao colocacao = new Colocacao();
		
			Thread sapo1 = new ThreadSapo(1, tamanho, puloMaximo, colocacao);
			Thread sapo2 = new ThreadSapo(2, tamanho, puloMaximo, colocacao);
			Thread sapo3 = new ThreadSapo(3, tamanho, puloMaximo, colocacao);
			Thread sapo4 = new ThreadSapo(4, tamanho, puloMaximo, colocacao);
			Thread sapo5 = new ThreadSapo(5, tamanho, puloMaximo, colocacao);
			sapo1.start();
			sapo2.start();
			sapo3.start();
			sapo4.start();
			sapo5.start();
			
		while(true) {
			if(!sapo1.isAlive()) {
				if(!sapo2.isAlive()) {
					if(!sapo3.isAlive()) {
						if(!sapo4.isAlive()) {
							if(!sapo5.isAlive()) {
								break;
							}
						}
					}
				}
			}
		}
		
		ArrayList col = colocacao.getAltar();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(col.get(i));
		}
	}

}
