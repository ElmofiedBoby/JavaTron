package javatron;

import java.awt.Dimension;//imports for seeing screen sizeeeeeee
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class javaTron {

	static JFrame frame;

	static void menu() {
		
		frame.dispose();

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setSize(size.width / 3, size.height);
		frame.setLocation(size.width / 3, 0);
		frame.setResizable(false);
		JButton button = new JButton("START GAME");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});
		frame.add(button);
		frame.setVisible(true);
	}
	
	static void menu1() {
		
	}

	static void start() {

	}

	public static void main(String[] args) {

	}
}
