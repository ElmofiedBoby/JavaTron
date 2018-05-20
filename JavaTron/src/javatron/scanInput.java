package javatron;

//This scanner is to be used with commandConfigure.java

import java.util.Scanner;

public class scanInput {

	public int scanNum() {

		Scanner numScan = new Scanner(System.in);
		int num = numScan.nextInt();

		return num;
	}

	public String scanString() {

		Scanner stringScan = new Scanner(System.in);
		String string = stringScan.nextLine();

		return string;
	}

}