package exercicios.thread.exercicio4.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import exercicios.thread.exercicio4.controller.ThreadCarroDrag;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Semaphore;

public class Pista extends JFrame {

	private DrawLines contentPane;
	private static JTextField tfprimeiro;
	private static JTextField tfsegundo;
	private JLabel lbCarro1;
	private JLabel lbCarro2;
	private Thread carro1;
	private Thread carro2;

	public Pista() {

		setResizable(false);

		setSize(1000, 400);
		contentPane = new DrawLines();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btComecar = new JButton("Play");
		btComecar.setBounds(10, 4, 124, 43);
		contentPane.add(btComecar);
		setLocationRelativeTo(null);
		setVisible(true);

		JButton btReset = new JButton("Reset");
		btReset.setBounds(150, 4, 124, 43);
		contentPane.add(btReset);
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

		btReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (carro1.isAlive() || carro2.isAlive()) {
					carro1.stop();
					carro2.stop();
				}

				tfprimeiro.setText(null);
				tfsegundo.setText(null);
				tfprimeiro.setBackground(null);
				tfsegundo.setBackground(null);
				lbCarro1.setBounds(20, 90, 60, 60);
				lbCarro2.setBounds(20, 180, 60, 60);
				lbCarro1.setIcon(new ImageIcon(getClass().getResource("img/sonicEsperando.gif")));
				lbCarro2.setIcon(new ImageIcon(getClass().getResource("img/knucklesEsperando.gif")));

				super.mouseClicked(e);
			}
		});

	}

	public void comecarCorrida() {

		carro1 = new ThreadCarroDrag("sonic", lbCarro1, 830, 30, tfprimeiro, tfsegundo, 20, 90);
		carro2 = new ThreadCarroDrag("knuckles", lbCarro2, 830, 30, tfprimeiro, tfsegundo, 20, 180);
		carro1.start();
		carro2.start();
	}

	public void construirCarros() {
		ImageIcon icon1 = new ImageIcon(getClass().getResource("img/sonicEsperando.gif"));
		ImageIcon icon2 = new ImageIcon(getClass().getResource("img/knucklesEsperando.gif"));
		lbCarro1 = new JLabel(icon1);
		contentPane.add(lbCarro1);
		lbCarro2 = new JLabel(icon2);
		contentPane.add(lbCarro2);
		lbCarro1.setVisible(true);
		lbCarro2.setVisible(true);
		lbCarro1.setBounds(20, 90, 60, 60);
		lbCarro2.setBounds(20, 180, 60, 60);
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
		g.drawLine(0, 0, 250, 250);
	}

}
