package com.asahi.studentDetails;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launch {
	static int choice;

	public static void main(String[] args) {
		DataStore.read();

		printData();
	}
	
	public static void printData() {
		 Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Enter 1 to insert data");
			System.out.println("Enter 2 to update data");
			System.out.println("Enter 3 to remove data");
			System.out.println("Enter 4 to view all data");
			System.out.println("Enter 5 to sort");
			System.out.println("Enter 6 to exit");
			System.out.println("-------------------------------------");
			System.out.println("Enter your choice:");
			try {
				choice=scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid Input");
				Launch.printData();
				System.exit(0);
			}

			Launch.loadData(choice,scanner);
			
		}

	}

	private static void loadData(int choice,Scanner scanner) {
	
		switch (choice) {
		case 1:
			System.out.println("-------------------------------------------------");
			DataStore.addStudent(scanner);
			DataStore.write();
			System.out.println("-------------------------------------------------");
			break;

		case 2:
			System.out.println("-------------------------------------------------");
			System.out.println("Enter your ID:");
			Integer id = null;
			try {
				id = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid ID");
				Launch.printData();
				System.exit(0);
			}
			DataStore.updateStudent(id, scanner);
			DataStore.write();
			System.out.println("-------------------------------------------------");
			break;
		case 3:
			System.out.println("-------------------------------------------------");
			System.out.println("Enter your ID:");
			Integer id1 = null;
			try {
				id1 = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid ID");
				Launch.printData();
				System.exit(0);
			}
			DataStore.removeStudent(id1);
			DataStore.write();
			System.out.println("-------------------------------------------------");
			break;
		case 4:
			System.out.println("-------------------------------------------------");
			DataStore.viewData();
			System.out.println("-------------------------------------------------");
			break;
		case 5:
			System.out.println("-------------------------------------------------");
			DataStore.sortData(scanner);
			System.out.println("-------------------------------------------------");
			break;
		case 6:
			System.out.println("Thank you...");
			System.exit(0);
		default:
			System.out.println("Your entered wrong choice...");
			System.out.println("-------------------------------------------------");
		}
	}

}
