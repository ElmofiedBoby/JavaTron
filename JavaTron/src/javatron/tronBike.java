package javatron;

import java.awt.Color;
import java.awt.Graphics;

public class tronBike {
	static final int RIGHT = 90;
	static final int LEFT = 270;
	static final int UP = 0;
	static final int DOWN = 180;

	String name;
	Color color;
	int[] location;
	boolean isAlive;
	int direction;

	public void tronBike(Color col, Graphics g, int[] location) {
		g.setColor(col);
		g.fillRect(location[0], location[1], location[2], location[3]);
	}

}
