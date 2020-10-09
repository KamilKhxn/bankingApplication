package test;// variables, if/else statments

import java.util.Scanner;

public class bankingApplication {

	static Scanner input = new Scanner(System.in);

	static double balance = 0;
	static double withdrawelAmount;
	double depositAmount;
	static double x;

	public static void main(String[] args) {
		bankEntrance();
	}

	public static void bankEntrance() {
		// asking what they would like to do
		System.out.println(
				"What would you like to do? \n 1 View Current Balance \n 2 Withdraw an amount \n 3 Deposit cash \n 4 Leave");
		int choice = input.nextInt();

		// if statement going through other methods
		if (choice == 1) {// view current balance
			currentBalance();
		} else if (choice == 2) {// withdraw an amount
			withdrawel();

		} else if (choice == 3) {
			deposit();

		} else if (choice == 4) {
			exit();

		}
	}

	public static void currentBalance() {
		System.out.println("\n================================\n");
		System.out.println("Your balance is " + balance + " \nEnter your balance in dollars");
		System.out.println("\n================================\n");

		balance = input.nextInt();
		bankEntrance();

	}

	public static void withdrawel() {
		System.out.println("\n================================\n");
		System.out.println("How much would you like to wirthdraw from your account?");
		withdrawelAmount = input.nextInt();
		// if statement to calculate if there is sufficient funds

		if (withdrawelAmount <= balance) {

			x = balance - withdrawelAmount; // calculate new balance
			System.out.println("You have withdrawn " + withdrawelAmount + "your new balance is " + x);
			System.out.println("\n================================\n");

			bankEntrance();

		} else {
			System.out.println(
					"You do not have sufficent funds to make this transaction\n Do you want to withdraw another amount?y/n ");

			String answer = input.next();
			if (answer.toLowerCase().startsWith("y")) {
				withdrawel();
			} else if (answer.toLowerCase().startsWith("n")) {// test
				System.out.println("would you like to leave?");
				answer = input.nextLine();
				if (answer.toLowerCase().startsWith("y")) {
					exit();

				} else if (answer.toLowerCase().startsWith("n")) {
					bankEntrance();
				}
			}

		}

	}

	public static void deposit() {
		System.out.println("\n================================\n");
		System.out.println("how much would you like to deposit in your account?");
		double answer = input.nextInt();
		double j = x + answer;
		System.out.println("your new balance is $" + j);
		System.out.println("\n================================\n");
		bankEntrance();
	}

	public static void exit() {
		System.out.println("\n================================\n");
		System.out.println("would you like to leave the bank? y/n");
		// link to bank entrance
		String answer = input.next();
		if (answer.toLowerCase().startsWith("y")) {
			System.out.println("have a good day!");
			System.out.println("\n================================\n");
		} else if (answer.toLowerCase().startsWith("n")) {
			bankEntrance();

		}
	}
}