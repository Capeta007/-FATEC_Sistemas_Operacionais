package exercicios.exercicio2.controller;

public class SomaMatrizThread extends Thread {
	
	int[] vetor;
	int index;

	public SomaMatrizThread(int[] vetor, int index) {
		
		this.index = index;
		this.vetor = vetor;
	}
	
	@Override
	public void run() {
		
		somaVetor();
		
		super.run();
	}

	private void somaVetor() {
		int soma = 0; 
		for (int i = 0; i < vetor.length; i++) {
				soma += vetor[i];
		}
		System.out.println("[" + index + "]" + " soma = " + soma);
	}
}
