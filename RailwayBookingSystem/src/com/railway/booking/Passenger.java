package com.railway.booking;

class Passenger {
	static int idCounter = 1;

	int id;
	String name;
	int age;
	String berthPreference;
	String allottedBerth;

	Passenger(String name, int age, String berthPreference) {
		this.id = idCounter++;
		this.name = name;
		this.age = age;
		this.berthPreference = berthPreference;
	}
}
