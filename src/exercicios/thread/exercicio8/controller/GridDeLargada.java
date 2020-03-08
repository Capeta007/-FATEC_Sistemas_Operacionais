package exercicios.thread.exercicio8.controller;

import java.util.ArrayList;

public class GridDeLargada {
	
	private static ArrayList<Piloto> placar = new ArrayList<>(); 

	public static void placar(String escuderia, int idCarro, double tempo) {
		
		
		
		if(placar.size() == 13) {
			
			placar.add(new Piloto(escuderia, idCarro, tempo));
			Piloto aux;
			
			for (int i = 0; i < 14; i++) {
				for(int j = i+1; j < 14; j++) {
					if (placar.get(j).getTempo() < placar.get(i).getTempo()) {
						aux = placar.get(j);
						placar.set(j,placar.get(i));
						placar.set(i, aux);
					}
				}
			}
            int grid = 1;
            System.err.println("Grid de largada: \n");
            double time;
			for (Piloto piloto : placar) {
				time =  (piloto.getTempo()/1000);
				System.out.println(grid+"° - Carro N°: "+ piloto.getIdCarro() + " Equipe " + piloto.getEscuderia() + " Tempo: " + time);
				grid++;
			}
			
			
		}else {
			
			placar.add(new Piloto(escuderia, idCarro, tempo));
			
		}
		
	}
}
