package exercicios.processos.exercicio2.controller;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ProcessosController {
	
	public ArrayList<String> readProcess(String sistema) {
		
		if(sistema.contains("Windows")) {

			try {
				Process p = Runtime.getRuntime().exec("tasklist /fo table");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				ArrayList<String> table = new ArrayList<>();
				
				while(line != null) {		
				    table.add(line.substring(0, 25));
				    System.out.println(line.substring(0, 25));
					line = buffer.readLine();
				}
				
				return table;

			} catch (IOException e) {
				
				System.out.println("Erro na leitura dos processos");
				
			}
			
			
		}
		
		if(sistema.contains("Linux")) {
			
			try {
				Process p = Runtime.getRuntime().exec("ps -A");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				String line = buffer.readLine();
				
				while(line != null) {
					System.out.println(line);
					line = buffer.readLine();
				}
				
			} catch (IOException e) {
				
				System.out.println("Erro na leitura dos processos");
				
			}
			
			
		}
		return null;
		
	}

	public void kill(String sistema, String alvo) {
		
		String cmdPid;
		String cmdNome;
		int pid;
		
		if(sistema.contains("Windows")) {
			cmdPid = "TASKKILL /PID";
            cmdNome = "TASKKILL /IM";
			pid = 0;
			
			StringBuffer buffer = new StringBuffer();
			
			try {
				pid = Integer.parseInt(alvo);
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
				
			} catch (NumberFormatException e) {
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(alvo);
				
			}
		}
		
		if(sistema.contains("Linux")) {
			
			cmdPid = "kill";
			cmdNome = "pkill";
			pid = 0;
			
			StringBuffer buffer = new StringBuffer();
			
			try {
				pid = Integer.parseInt(alvo);
				buffer.append(cmdPid);
				buffer.append(" ");
				buffer.append(pid);
				
			}catch (Exception e) {
				
				buffer.append(cmdNome);
				buffer.append(" ");
				buffer.append(alvo);
				
			}
			
		}
		
		
	}
}
