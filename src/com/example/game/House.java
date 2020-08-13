package com.example.game;

import java.util.HashMap;
import java.util.Scanner;

public class House {
	public static void main(String [] args) {
		boolean game = true;
		Room currentRoom;
		Room entranceHall = new Room("Entrance Hall","Welcome to my house!. Please type forward, back, left, or right");
		Room livingRoom = new Room("Painting Room", "Painting scatter the walls, each with with their own colors and imagery. Where will you go next?");
		Room bedRoom = new Room("Bedroom", "A freshly made bed captures your attention. Smooth red silk lines the edges and soft pillows make you sleepy. Where to next?");
		entranceHall.setDirections(new HashMap<String,Room>(){{put("forward",livingRoom);}});
		livingRoom.setDirections(new HashMap<String,Room>(){{put("right",bedRoom);put("back",entranceHall);}});
		
		
		//System.out.println("Hello");
		Scanner scanner = new Scanner(System.in);
		String word;
		currentRoom = entranceHall;
		while(game) {
			System.out.println(currentRoom);
			word = scanner.nextLine();
			word = word.toLowerCase();
			if(currentRoom.getDirections().containsKey(word)) {
				currentRoom = currentRoom.getDirections().get(word);
			} else if (word.equals("quit")) {
				game = false;
			} else {
				System.out.println("Invalid Input. Try forward, back, left right, or quit");
			}
		}
		//entrane hall, living room, painting room, bedroom
		//System.out.println(word);
	}

}
