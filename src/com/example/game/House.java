package com.example.game;

import java.util.HashMap;
import java.util.Scanner;

public class House {
	public static void main(String [] args) {
		boolean game = true;
		Room currentRoom;
		Room entranceHall = new Room("Entrance Hall","Welcome to my house!. Please type forward, back, left, or right");
		Room livingRoom = new Room("Painting Room", "Painting scatter the walls, each with with their own colors and imagery. Where will you go next?");
		//System.out.println("Hello");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		//currentRoom = 
		//entrane hall, living room, painting room, bedroom
		System.out.println(word);
	}

}
