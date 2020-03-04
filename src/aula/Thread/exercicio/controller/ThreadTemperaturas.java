package controller;

public class ThreadTemperaturas extends Thread{

	private int tipo = 0;
	private double tempC = 0;
	private int index = 0;
	
	public ThreadTemperaturas(int tipo, double tempC, int index) {
		
		this.tipo = tipo;
		this.tempC = tempC;
		this.index = index;
		
	}
	
	@Override
	public void run() {
		
		converter();
		
	}
	
	
	private void converter() {
		
		double tempConvertida = tempC;
	    String unidade = "°C";
		
		switch (tipo) {
		case 1:
			
			tempConvertida = (tempC + 273);
			unidade = "°K";
			
			break;
			
		case 2:
			
			tempConvertida = (tempC*1.8 + 32);
			unidade = "°F";
			
		}
		
		System.out.println("[" +index+ "]"+ "  " + tempC + " = " + tempConvertida + unidade);
		
	}
	
	
}
