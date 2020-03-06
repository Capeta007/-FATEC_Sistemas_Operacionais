package exercicios.processos.exercicio1.view;



import javax.swing.JOptionPane;

import exercicios.processos.exercicio1.controller.RedesController;


public class Main {

	public static void main(String[] args) {

		String opc = JOptionPane.showInputDialog("1 - Verificar IP \n " + "2 - Verificar Ping \n" + "9 - Sair");

		opc = opc.trim();

		RedesController redesC = new RedesController();

		String sistema = System.getProperty("os.name");

		while (!opc.equals("9")) {

			switch (opc) {

			case "1":

				JOptionPane.showMessageDialog(null, redesC.ip(sistema));
				

				break;

			case "2":

				JOptionPane.showMessageDialog(null, redesC.ping(sistema));
				

				break;

			case "9":
				
				JOptionPane.showInternalMessageDialog(null, "Progama Finalizado");

				break;

			default:

				JOptionPane.showConfirmDialog(null, "O valor digitado é inválido !!!");

				break;
			}
			
			opc = JOptionPane.showInputDialog("1 - Verificar IP \n " + "2 - Verificar Ping \n" + "9 - Sair");

			opc = opc.trim();
		}

	}

}
