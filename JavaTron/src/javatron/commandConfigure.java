package javatron;

/*
 * this configures settings for the game before being able to play it
 * and stores things such as player name, color, and checks if it is valid.
 * This will be moved to a GUI later.
 */


import java.awt.Color;

public class commandConfigure {

	scanInput scan = new scanInput();

	public String name() {
		System.out.print("Enter the name of player one: ");
		String name = scan.scanString();
		return name;
	}

	public int color() {
		System.out.print("Enter the number of the color you want (1 - RED, 2 - BLUE, 3 - GREEN): ");
		int col = scan.scanNum();

		return col;

	}

	public Color checkColor(int c) {
		Color color;
		if (c == 1)
			color = Color.RED;
		else if (c == 2)
			color = Color.BLUE;
		else if (c == 3)
			color = Color.GREEN;
		else {
			System.out.println("Invalid choice, try again!");
			color = null;
		}
		return color;
	}
}
