package game;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
	static Scanner keyboard = new Scanner(System.in);
	static Map map1 = new Map(16);
	static Player player = new Player(map1, 1, 1);
	static int counter = 0;
	static boolean action = false;
	static String entry = "ms1";
	
	boolean result = true;
	
	static public void draw() {
        generateFrame(map1.getSize() * 2, 1);
		System.out.println(map1.draw());
		generateFrame(map1.getSize() * 2, 2);
		System.out.println("\n" + Arrays.toString(player.getPos()));
		breakLines(36 - map1.getSize());
	}
	
	static public void update() {
		if (!action) {
			entry = keyboard.nextLine();
			actInaRow(counter, action, player, entry);
			action = true;
		} else {
			actInaRow(counter, action, player, entry);
		}
	}
	
	static void actInaRow(int counter, boolean action, Player player, String entry) {
		int char0 = Integer.parseInt(String.valueOf(entry.charAt(2)));
		entry = entry.substring(0, entry.length()-1);
		
		if (counter < char0) {
			counter++;
			if (!player.act(entry)) {
				counter = 0;
				action = false;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			counter = 0;
			action = false;
		}
		
	}
	
	static public void breakLines(int num) {
		String product = "";
		for (int l = 0; l <= num + 1; l++) {
			product += "\n";
		}
		System.out.println(product);
	}

	static public void generateFrame(int lenght, int opt) {
		String product = "";
		if (opt == 1) { 
			product += "\t┌";
		} else {
			product += "\t└";
		}
		for (int l = 0; l < lenght + 1; l++) {
			product += "─";
		}
		if (opt == 1) { 
			product += "┐";
		} else {
			product += "┘";
		}
		System.out.println(product);
	}

	
}