package exercicios.thread.exercicio3.controller;

import java.util.ArrayList;

public class Colocacao {

	ArrayList altar;
	
	public Colocacao() {
		
		this.altar = new ArrayList();
		
	}
	
	public void add(int sapo) {
		altar.add(sapo);
	}
	
	public ArrayList getAltar() {
		return altar;
	}
}
