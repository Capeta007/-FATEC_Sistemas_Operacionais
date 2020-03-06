package exercicios.processos.exercicio1.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public String ip(String sistema) {

		String command;

		if (sistema.contains("Windows")) {

			command = "ipconfig";

			try {

				Process p = Runtime.getRuntime().exec(command);
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);

				String line = buffer.readLine();
				String adaptador = null;
				String todosAdap = null;

				while (line != null) {

					if (line.contains("Adaptador")) {
						adaptador = line.substring(10);

					}
					if (line.contains("IPv4")) {
						todosAdap += adaptador + "  " + line;
	                    todosAdap += "\n";
					}

					line = buffer.readLine();

				}
				
				System.out.println(todosAdap);
				buffer.close();
				reader.close();
				stream.close();

				return todosAdap;

			} catch (IOException e) {
				System.err.println("Ocorreu um erro");
			}

		} else {

		}
		return "O seu Sistema Operacional não é Compatível com nosso programa.";

	}

	public String ping(String sistema) {
		
		String command;

		if (sistema.contains("Windows")) {

			command = "ping google.com.br -n 10";

			try {

				Process p = Runtime.getRuntime().exec(command);
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);

				String line = buffer.readLine();
				String tempoSaida = "";

				while (line != null) {
					
					if(line.contains("tempo")) {
						tempoSaida += line.substring(line.indexOf("=")+1) + "\n";
					}
					if(line.contains("dia")) {
						tempoSaida += "Média é : " + line.substring(line.indexOf("dia = ")+ 6) + "\n";
					}
					
					line = buffer.readLine();

				}
				buffer.close();
				reader.close();
				stream.close();

				return tempoSaida;
				
			} catch (IOException e) {
				System.err.println("Ocorreu um erro");
			}
			
			

		} else {
			
			

		}
		return "O sistema operacional não foi reconhecido";
	}

}
