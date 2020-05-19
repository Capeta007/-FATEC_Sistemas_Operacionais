package exercicios.thread.exercicio8.view;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

import exercicios.thread.exercicio8.controller.ThreadCarro;
import exercicios.thread.exercicio8.entities.Carro;

public class TreinoFormula1 {

	private static ArrayList<Carro> placar = new ArrayList<>();

	public static void main(String[] args) {

		String[] escuderias = { "Mercedes", "Ferrari", "RBR-Honda", "McLaren-Renault", "Renault", "Alpha Touri-Honda",
				"Alpha-Romeo" };
		Thread carro;
		int i = 0;
		for (String escuderia : escuderias) {
			Semaphore vagaEquipe = new Semaphore(1);
			carro = new ThreadCarro(new Carro(escuderia, i, vagaEquipe));
			carro.start();
			carro = new ThreadCarro(new Carro(escuderia, i + 1, vagaEquipe));
			carro.start();
			i = i + 2;
		}
	}

	public static void placar(Carro car) {

		if (placar.size() == 13) {

			placar.add(car);
			Carro aux;

			for (int i = 0; i < 14; i++) {
				for (int j = i + 1; j < 14; j++) {
					if (placar.get(j).getTimeAbsolut() < placar.get(i).getTimeAbsolut()) {
						aux = placar.get(j);
						placar.set(j, placar.get(i));
						placar.set(i, aux);
					}
				}
			}
			
			int grid = 1;
			System.out.println();
			System.err.println("Grid de largada: ");
			for (Carro piloto : placar) {
				System.out.println(grid + "° - Carro N°: " + piloto.getIdCarro() + " Equipe " + piloto.getEscuderia()
						+ " Tempo: " + piloto.getTimeSeconds() + "s");
				grid++;
			}

		} else {

			placar.add(car);

		}
	}
}
