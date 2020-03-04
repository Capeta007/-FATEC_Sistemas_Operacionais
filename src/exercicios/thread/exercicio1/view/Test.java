package exercicios.exercicio1.view;

import javax.xml.stream.events.StartDocument;

import exercicios.exercicio1.controller.NumeroThread;

public class Test {

	public static void main(String[] args) {
		
		for (int i = 0; i <= 4; i++) {
			Thread nt = new NumeroThread();
			nt.start();
		}

	}

}
