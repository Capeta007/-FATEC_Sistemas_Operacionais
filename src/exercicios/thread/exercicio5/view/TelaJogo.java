package exercicios.thread.exercicio5.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exercicios.thread.exercicio5.controller.ThreadRodando;

public class TelaJogo extends JFrame {

	private JPanel contentPane;
    private JTextField[] texts = new JTextField[3];
    public static int[] resultado = new int[3];

	public TelaJogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		construirTextField();
		construirBotao();
		
	}

	private void construirTextField() {
		
		for (int i = 0; i < texts.length; i++) {
			texts[i]= new JTextField();
			texts[i].setVisible(true);
			texts[i].setBounds(70+200*i, 50, 150, 200);
			texts[i].setFont(new Font("arial", 1, 200));
			texts[i].setHorizontalAlignment(texts[i].CENTER);
			texts[i].setEnabled(false);
			contentPane.add(texts[i]);
		}
		
	}
	
	private void construirBotao() {
		
		Semaphore sema = new Semaphore(3);
		
		
		JButton btButton = new JButton("Jogar");
		btButton.setBackground(new Color(255, 51, 51));
		btButton.setFont(new Font("Arial", Font.BOLD, 60));
		btButton.setBounds(222, 309, 267, 120);
		contentPane.add(btButton);
		setVisible(true);
		
		btButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i < texts.length; i++) {
					
					Thread sorte = new ThreadRodando(texts[i],sema);
					sorte.start();
					
				}
				
			}
		});
	}
}
