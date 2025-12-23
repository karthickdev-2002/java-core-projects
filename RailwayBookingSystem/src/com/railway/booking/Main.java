package com.railway.booking;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nChoose option to proceed");
			System.out.println("1 - Book ticket");
			System.out.println("2 - Cancel ticket");
			System.out.println("3 - Exit");
			int option = scanner.nextInt();

			if (option == 1) {
				System.out.println("Enter your name");
				String name = scanner.next();

				System.out.println("Enter age");
				int age = scanner.nextInt();

				System.out.println("Enter seat preference Lower Birth - L or Middle Birth - M or Upper Birth - U)");
				String preference = scanner.next();

				TicketBooking.bookTicket(name, age, preference);
			} else if (option == 2) {

				System.out.println("Enter ticket id");
				int ticketId = scanner.nextInt();

				TicketBooking.cancelTicket(ticketId);

			} else if (option == 3) {
				System.out.println("Thank you!");
				break;
			}
		}
	}
}
