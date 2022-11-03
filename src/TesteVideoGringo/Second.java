package TesteVideoGringo;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class Second extends JPanel implements ActionListener{
	Timer t = new Timer(5, this);
	double x = 0, y = 0, velX= 9, velY = 9;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
		g2.fill(circle);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(x < 0 || x > 540) {
			velX = -velX;
			
		}
		
		if(y < 0 || y > 330) {
			velY = -velY;
			
		}
		x+= velX;
		y+= velY;
		repaint();
	}
}
