
import java.util.Scanner;

public class Date {
	private String month;
	private int day;
	private int year; // a four digit number.

	public Date() {
		month = "January";
		day = 1;
		year = 1000;
	}

	public Date(int monthInt, int day, int year) {
		setDate(monthInt, day, year);
	}

	public Date(String monthString, int day, int year) {
		setDate(monthString, day, year);
	}

	public Date(int year) {
		setDate(1, 1, year);
	}

	public void setDate(int monthInt, int day, int year) {
		if (dateCheck(monthInt, day, year)) {
			this.month = monthString(monthInt);
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	public void setDate(String monthString, int day, int year) {
		if (dateCheck(monthString, day, year)) {
			this.month = monthString;
			this.day = day;
			this.year = year;
		} else {
			System.out.println("Fatal Error");
			System.exit(0);
		}
	}

	public int getMonth() {
		return switch (month) {
		case "January" -> 1;
		case "February" -> 2;
		case "March" -> 3;
		case "April" -> 4;
		case "May" -> 5;
		case "June" -> 6;
		case "July" -> 7;
		case "August" -> 8;
		case "September" -> 9;
		case "October" -> 10;
		case "November" -> 11;
		case "December" -> 12;
		default -> {
			System.out.println("Fatal Error");
			System.exit(0);
			yield 0; // Needed to keep the compiler happy
		}
		};
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public String toString() {
		return (month + " " + day + ", " + year);
	}

	public void readInput() {
		boolean tryAgain = true;
		Scanner keyboard = new Scanner(System.in);
		while (tryAgain) {
			System.out.println("Enter month, day, and year.");
			System.out.println("Do not use a comma.");
			var monthInput = keyboard.next();
			var dayInput = keyboard.nextInt();
			var yearInput = keyboard.nextInt();
			if (dateCheck(monthInput, dayInput, yearInput)) {
				setDate(monthInput, dayInput, yearInput);
				tryAgain = false;
			} else
				System.out.println("Illegal date. Reenter input.");
		}
	}

	private boolean dateCheck(int monthInt, int dayInt, int yearInt) {
		return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000)
				&& (yearInt <= 9999));
	}

	private boolean dateCheck(String monthString, int dayInt, int yearInt) {
		return (monthCheck(monthString) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000) && (yearInt <= 9999));
	}

	private boolean monthCheck(String month) {
		return switch (month) {
		case "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" -> true;
		default -> false;
		};
	}

	private String monthString(int monthNumber) {
		return switch (monthNumber) {
		case 1 -> "January";
		case 2 -> "February";
		case 3 -> "March";
		case 4 -> "April";
		case 5 -> "May";
		case 6 -> "June";
		case 7 -> "July";
		case 8 -> "August";
		case 9 -> "September";
		case 10 -> "October";
		case 11 -> "November";
		case 12 -> "December";
		default -> {
			System.out.println("Fatal Error");
			System.exit(0);
			yield "Error";
		}// to keep the compiler happy
		};
	}
}
