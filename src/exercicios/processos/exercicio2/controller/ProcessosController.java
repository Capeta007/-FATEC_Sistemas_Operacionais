package exercicios.processos.exercicio2.controller;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProcessosController {

    public ArrayList<String> readProcess(String sistema) {

        if (sistema.contains("Windows")) {

            try {
                Process p = Runtime.getRuntime().exec("tasklist /fo table");
                InputStream stream = p.getInputStream();
                InputStreamReader reader = new InputStreamReader(stream);
                BufferedReader buffer = new BufferedReader(reader);
                String line = buffer.readLine();
                for (int i = 0; i < 2; i++) {

                    line = buffer.readLine();

                }

                ArrayList<String> table = new ArrayList<>();

                while (line != null) {

                    line = buffer.readLine();
                    if (line != null) {
                        table.add(line);
                    }
                }
                buffer.close();
                reader.close();
	        stream.close();
                
                
                return table;

            } catch (IOException e) {

                System.out.println("Erro na leitura dos processos");

            }

        }

        if (sistema.contains("Linux")) {

            try {
                Process p = Runtime.getRuntime().exec("ps -A");
                InputStream stream = p.getInputStream();
                InputStreamReader reader = new InputStreamReader(stream);
                BufferedReader buffer = new BufferedReader(reader);
                String line = buffer.readLine();
                line = buffer.readLine();

                ArrayList<String> table = new ArrayList<>();
                
                while (line != null) {
                    
                    table.add(line);
                    line = buffer.readLine();
                    
                }
                
                buffer.close();
	        reader.close();
	        stream.close();

                 return table;
                 
            } catch (IOException e) {

                System.out.println("Erro na leitura dos processos");

            }
            
            

        }
        return null;

    }

    public void kill(String sistema, String alvo) {

        if (sistema.contains("Windows")) {
            String cmdPid = "TASKKILL /PID";
            String cmdNome = "TASKKILL /IM";
            int pid = 0;

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

            }finally{
                try {
                    Runtime.getRuntime().exec(buffer.toString());
                } catch (IOException ex) {
                    Logger.getLogger(ProcessosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (sistema.contains("Linux")) {

            String cmdPid = "kill";
            String cmdNome = "pkill";
            int pid = 0;

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

            }finally{
                try {
                    Runtime.getRuntime().exec(buffer.toString());
                } catch (IOException ex) {
                    Logger.getLogger(ProcessosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
}
