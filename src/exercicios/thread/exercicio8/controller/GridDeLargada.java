package exercicios.thread.exercicio8.controller;

import java.util.ArrayList;

import exercicios.thread.exercicio8.entities.Carro;

public class GridDeLargada {
	
	private static ArrayList<Carro> placar = new ArrayList<>();

	public static void placar(Carro car) {
		
		if(placar.size() == 13) {

			placar.add(car);
			Carro aux;
			
			for (int i = 0; i < 14; i++) {
				for(int j = i+1; j < 14; j++) {
					if (placar.get(j).getTimeAbsolut() < placar.get(i).getTimeAbsolut()) {
						aux = placar.get(j);
						placar.set(j,placar.get(i));
						placar.set(i, aux);
					}
				}
			}
            int grid = 1;
            System.out.println();
            System.err.println("Grid de largada: ");
			for (Carro piloto : placar) {
				System.out.println(grid+"° - Carro N°: "+ piloto.getIdCarro() + " Equipe " + piloto.getEscuderia() + " Tempo: " + piloto.getTimeSeconds() + "s");
				grid++;
			}
			
			
		}else {
			
			placar.add(car);
			
		}
		
	
   }
}
