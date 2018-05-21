package javatron;

//used for setting window size
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

//window
import javax.swing.JFrame;

public class javaTron {

	public static void main(String[] args) {
		// initiates
		commandConfigure conf = new commandConfigure();
		tronBike player1 = new tronBike();
		
		// asks for settings in console - move into a GUI later
				conf.name();
				int c = conf.color();
				while (c != 1 && c != 2 && c != 3) {
					System.out.println("That is not a valid color! Please try again.");
					c = conf.color();
				}
				Color color = conf.checkColor(c);
				System.out.println(color);
		
		//JPanel
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // gets the size of screen
				JFrame gameFrame = new JFrame("JavaTron");
				gameFrame.setSize(640, 480);
				gameFrame.setLocation(dim.width / 3, dim.height / 3 - 40); // 40 to represent windows taskbar size
				gameFrame.setDefaultCloseOperation(3);
				gameFrame.setAlwaysOnTop(true);
				gameFrame.setContentPane(new gamePanel()); //uncomment when gamePanel is
				// completed
				gameFrame.setVisible(true);

	}

}