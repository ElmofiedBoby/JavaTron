package javatron;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gamePanel extends JPanel {
	
	int[] location = {50, 50, 100, 100};
	
	public gamePanel() {
		Timer t = new Timer(10, (ActionListener) new Listener());
		t.start();
	}
	public void paintComponent(Graphics g) {
		g.drawRect(location[0], location[1], location[2], location[3]);
	}
	private class Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			
			location[1]++;
		}

	}
}
