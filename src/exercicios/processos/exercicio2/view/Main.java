package view;

import controller.ProcessosController;

public class Main {

	public static void main(String[] args) {
		
		ProcessosController proc = new ProcessosController();
		
		
		//proc.readProcess(System.getProperty("os.name"));
		
		proc.kill(System.getenv("os.name"), "notepad.exe");

	}

}
