package exercicios.exercicio2.view;

import exercicios.exercicio2.controller.SomaMatrizThread;

public class Test {

	public static void main(String[] args) {
		
		int[][] matriz = new int[3][5]; 
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				matriz[i][j] = (int) ((Math.random()*10)+1);
				
			}
		}
		
		for (int i = 0; i < matriz.length; i++) {
			Thread smt = new SomaMatrizThread(matriz[i], i);
			smt.start();
		}
		
		
	}
}
