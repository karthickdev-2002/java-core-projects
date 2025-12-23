package com.railway.booking;

import java.util.*;

class TicketBooking {

	static int lowerBerth = 21;
	static int middleBerth = 21;
	static int upperBerth = 21;

	static int racSeats = 18;
	static int waitingList = 10;

	static Map<Integer, Passenger> confirmedList = new HashMap<>();
	static Queue<Passenger> racList = new LinkedList<>();
	static Queue<Passenger> waitingQueue = new LinkedList<>();

	public static void bookTicket(String name, int age, String preference) {

		Passenger p = new Passenger(name, age, preference);

		if (lowerBerth + middleBerth + upperBerth > 0) {
			allotBerth(p);
			confirmedList.put(p.id, p);
			System.out.println("Ticket Confirmed for " + "ID :" + p.id + " | Name :" + p.name + " | Berth: " + p.allottedBerth);
		} else if (racSeats > 0) {
			racList.add(p);
			racSeats--;
			System.out.println("Added to RAC: " + p.name);
		} else if (waitingList > 0) {
			waitingQueue.add(p);
			waitingList--;
			System.out.println("Added to Waiting List: " + p.name);
		} else {
			System.out.println("No tickets available!");
		}

	}

	private static void allotBerth(Passenger p) {

		if (p.berthPreference.equalsIgnoreCase("L") && lowerBerth > 0) {
			lowerBerth--;
			p.allottedBerth = "Lower";
		} else if (p.berthPreference.equalsIgnoreCase("M") && middleBerth > 0) {
			middleBerth--;
			p.allottedBerth = "Middle";
		} else if (p.berthPreference.equalsIgnoreCase("U") && upperBerth > 0) {
			upperBerth--;
			p.allottedBerth = "Upper";
		} else {
			if (lowerBerth > 0) {
				lowerBerth--;
				p.allottedBerth = "Lower";
			} else if (middleBerth > 0) {
				middleBerth--;
				p.allottedBerth = "Middle";
			} else {
				upperBerth--;
				p.allottedBerth = "Upper";
			}
		}
	}

	public static void cancelTicket(int passengerId) {

		Passenger removedPassenger = confirmedList.remove(passengerId);

		if (removedPassenger == null) {
			System.out.println("Invalid Passenger ID");
			return;
		}

		System.out.println("Cancelled Ticket of " + removedPassenger.name);

		if (removedPassenger.allottedBerth.equals("Lower"))
			lowerBerth++;
		if (removedPassenger.allottedBerth.equals("Middle"))
			middleBerth++;
		if (removedPassenger.allottedBerth.equals("Upper"))
			upperBerth++;

		if (!racList.isEmpty()) {
			Passenger racPassenger = racList.poll();
			racSeats++;

			allotBerth(racPassenger);
			confirmedList.put(racPassenger.id, racPassenger);
			System.out.println("RAC Passenger Confirmed: " + racPassenger.name);
		}

		if (!waitingQueue.isEmpty()) {
			Passenger waitingPassenger = waitingQueue.poll();
			waitingList--;
			racList.add(waitingPassenger);
			racSeats--;
			System.out.println("Waiting Passenger moved to RAC: " + waitingPassenger.name);
		}
	}

	public static void printBookedTickets() {

		System.out.println("\n--- Confirmed Tickets ---");
		for (Passenger p : confirmedList.values()) {
			System.out.println(p.id + " | " + p.name + " | " + p.allottedBerth);
		}

		System.out.println("\n--- RAC List ---");
		for (Passenger p : racList) {
			System.out.println(p.id + " | " + p.name);
		}

		System.out.println("\n--- Waiting List ---");
		for (Passenger p : waitingQueue) {
			System.out.println(p.id + " | " + p.name);
		}
	}

	public static void printBookedTicket(int ticketId) {

		Passenger p = confirmedList.get(ticketId);
		System.out.println(p.id + " | " + p.name + " | " + p.allottedBerth);
	}
}
