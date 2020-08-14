package com.example.game;

import java.util.HashMap;
import java.util.Map;

public class Room {
	private String name;
	private String description;
	private String event;
	private boolean outcome;
	private Map<String,Room> directions = new HashMap<>();
	
	public Room(String name, String description, String event, boolean outcome) {
		super();
		this.name = name;
		this.description = description;
		this.event = event;
		this.outcome = outcome;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Map<String, Room> getDirections() {
		return directions;
	}
	public void setDirections(Map<String, Room> directions) {
		this.directions = directions;
	}
	
	public boolean search() {
		System.out.println(this.event);
		return this.outcome;
	}
	
	@Override
	public String toString() {
		return "This is the " + name + " room.\n" + description;
	}

}
