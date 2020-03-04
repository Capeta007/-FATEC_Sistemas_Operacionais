package view;

import controller.ThreadTemperaturas;

public class PricipalTemp {
	
	public static void main(String[] args) {
		
		int[] tipo = {1,2,3,2,5,1,2,8,2,1};
		double[] celsius = {0,20,32,31,42,10,10,10,10,10,10,10,10,10};
		
		for (int i = 0; i < tipo.length; i++) {
			
			Thread tt = new ThreadTemperaturas(tipo[i], celsius[i], i);
			tt.start();
			
		}
		
	}

}
