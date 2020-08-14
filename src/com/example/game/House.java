package com.example.game;

import java.util.HashMap;
import java.util.Scanner;

public class House {
	public static void main(String [] args) {
		boolean game = true;
		boolean hasKey = false;
		Room currentRoom;
		Room entranceHall = new Room("Entrance Hall","Welcome to my house!. Please type forward, back, left, or right","No hidden wall switches or secret doors, just a plain white hallway",false);
		Room livingRoom = new Room("Living Room", "A rather empty and clean room stands before you a single couch and coffee table makes you feel like it could be rather lively with the right group","some spare change in the sofa, but nothing out of the usual",false);
		Room paintingRoom = new Room("Painting Room", "Paintings scatter the walls, each with with their own colors and imagery. Where will you go next?","Taped behind one of the paintings was a key!!!",true);
		Room bedRoom = new Room("Bedroom", "A freshly made bed captures your attention. Smooth red silk lines the edges and soft pillows make you sleepy. Where to next?","You messed up a perfectly nice bed, only to find nothing...",false);
		Room backYard = new Room("backYard", "A well maintained display of plantlife greet you. You feel a freshness now that you are out of the house. You also see a lonely shed in the back.","some bugs here and there, but nothing of interest was found",false);
		Room shed = new Room("Shed", "Looks like a ordinary tool shed complete with its own work bench","You find a hidden switch in the workbench. Upon pressing it a floor board becomes loose. Under it is a treasure map! It's pointing to the neighbor's house!",true);
		entranceHall.setDirections(new HashMap<String,Room>(){{put("forward",livingRoom);}});
		livingRoom.setDirections(new HashMap<String,Room>(){{put("right",bedRoom);put("back",entranceHall); put("left",paintingRoom);put("forward",backYard);}});
		paintingRoom.setDirections(new HashMap<String,Room>(){{put("back",livingRoom);}});
		bedRoom.setDirections(new HashMap<String,Room>(){{put("back",livingRoom);}});
		backYard.setDirections(new HashMap<String,Room>(){{put("back",livingRoom);put("forward",shed);}});
		shed.setDirections(new HashMap<String,Room>(){{put("back",backYard);}});
		
		//System.out.println("Hello");
		Scanner scanner = new Scanner(System.in);
		String word;
		currentRoom = entranceHall;
		while(game) {
			System.out.println(currentRoom);
			word = scanner.nextLine();
			word = word.toLowerCase();
			if(currentRoom.getDirections().containsKey(word)) {
				if(currentRoom.getName().equals("backYard")&&!hasKey&&word.equals("forward")) {
					System.out.println("The Shed is locked. Try to 'search' the house for the key.");
				} else {
					currentRoom = currentRoom.getDirections().get(word);
				}
				
			} else if (word.equals("quit")) {
				game = false;
			} else if (word.equals("search")) {
				hasKey = currentRoom.search();
				if(currentRoom.getName().equals("Shed")) {
					game = false;
				}
			} else {
				System.out.println("Invalid Input. Try forward, back, left right, or quit");
			}
		}
		//entrane hall, living room, painting room, bedroom
		//System.out.println(word);
	}

}
