package exercicios.thread.exercicio4.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exercicios.thread.exercicio4.controller.ThreadCarroDrag;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pista extends JFrame {

	private DrawLines contentPane;
	private JTextField tfprimeiro;
	private JTextField tfsegundo;
	private JLabel lbCarro1;
	private JLabel lbCarro2;

	public Pista() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 400);
		contentPane = new DrawLines();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btComecar = new JButton("Play");
		btComecar.setBounds(10, 11, 124, 43);
		contentPane.add(btComecar);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		construirPlacar();
		construirCarros();
		
		
		
		btComecar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				tfprimeiro.setText(null);
				tfsegundo.setText(null);
				tfprimeiro.setBackground(null);
				tfsegundo.setBackground(null);
				
				comecarCorrida();

				super.mouseClicked(e);
			}
		});
		
	
	}

	public void comecarCorrida() {
		
		
		Thread carro1 = new ThreadCarroDrag("Carro1", lbCarro1,800, 100, tfprimeiro, tfsegundo,80, 90);
		Thread carro2 = new ThreadCarroDrag("Carro2", lbCarro2,800, 100, tfprimeiro, tfsegundo,80, 180);
		carro1.start();
		carro2.start();
	}
	
	public void construirCarros() {
		
		lbCarro1 = new JLabel("Carro1");
		contentPane.add(lbCarro1);
		lbCarro2 = new JLabel("Carro2");
		contentPane.add(lbCarro2);
		lbCarro1.setVisible(true);
		lbCarro2.setVisible(true);
		lbCarro1.setBounds(20, 90, 60, 20);
		lbCarro2.setBounds(20, 180, 60, 20);
	}
	
	public void construirPlacar() {
		
		tfprimeiro = new JTextField();
		tfprimeiro.setEditable(false);
		tfprimeiro.setVisible(true);
		contentPane.add(tfprimeiro);
		tfprimeiro.setBounds(150, 270, 120, 30);
		
		JLabel lbPrimeiro = new JLabel("Primeiro:");
		lbPrimeiro.setVisible(true);
		contentPane.add(lbPrimeiro);
		lbPrimeiro.setFont(new Font("arial", 1, 20));
		lbPrimeiro.setBounds(60, 270, 120, 30);
		
		JLabel lbSegundo = new JLabel("Segundo:");
		lbSegundo.setVisible(true);
		contentPane.add(lbSegundo);
		lbSegundo.setFont(new Font("arial", 1, 20));
		lbSegundo.setBounds(55, 320, 120, 30);
		
		tfsegundo = new JTextField();
		tfsegundo.setEditable(false);
		tfsegundo.setVisible(true);
		contentPane.add(tfsegundo);
		tfsegundo.setBounds(150, 320, 120, 30);
	}
	
	public void draw(Graphics g) {
		g.drawLine( 0, 0, 250, 250 );
	}
	

}
