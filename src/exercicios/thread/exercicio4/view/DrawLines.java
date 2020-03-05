package exercicios.thread.exercicio4.view;

import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawLines extends JPanel{
    
    public void paintComponent( Graphics g ){
    super.paintComponent( g );
//    g.drawLine( 900, 50, 900, 250);
    g.drawLine(10, 50, 950, 50);
    g.drawLine(10, 250, 950, 250);
    g.drawLine(70, 50, 70, 250);
    
    
    for (int i = 0; i < 50; i++) {
    	if(i%3 == 0) {
    		g.drawLine( 800 + i, 50, 800+i, 250);
    	}
	}
        
    g.drawLine( 10,147,950 ,147);

    }
}
