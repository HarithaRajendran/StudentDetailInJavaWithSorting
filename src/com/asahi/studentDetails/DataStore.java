package com.asahi.studentDetails;

import java.util.List;
import java.util.Scanner;

import com.asahi.studentDetails.entities.Student;
import com.asahi.studentDetails.manager.StudentManager;
import com.asahi.studentDetails.util.ReadData;
import com.asahi.studentDetails.util.WriteData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class DataStore {

	static List<Student> list = new ArrayList<Student>();
	private static int id;
	
	/*--TO INSERT DATA--*/
	public static void addStudent(Scanner scanner2) {
		for (Student s : list) {
			id = s.getId();
			id++;
		}

		System.out.println("Enter your Name:");
		String name = scanner2.next();
		try {
			int age = 0;
			do {
				System.out.println("Enter your age:");
				
				age = scanner2.nextInt();
				if(age<10 || age > 30) {
					System.out.println("Invalid age");
				}
				
				//System.exit(0);
				//throw new InputMismatchException();
				
			}while(age<10 || age > 30);
			
			
			System.out.println("Enter your Mark(Should be < 101 and >-1):");
			int mark = scanner2.nextInt();
			list.add(StudentManager.getInstance().createStudent(id, name, age, mark));
			System.out.println("Details Inserted successfully...");
		} catch (InputMismatchException e) {
			System.out.println("Invalid Input...");
			Launch.printData();
			System.exit(0);
		}
	}

	/*--TO UPDATE DATA--*/
	private static void data(Integer id, Scanner scanner2,Student student) {
		try {
					System.out.println("Enter 1 to update Name");
					System.out.println("Enter 2 to update Age");
					System.out.println("Enter 3 to update grade");
					System.out.println("Enter 4 to all");
					String value = scanner2.next();
					if (value.equals("1")) {
						System.out.println("Enter your New Name");
						String newName = scanner2.next();
						student.setName(newName);

						System.out.println("Name updated successfully");
					} else if (value.equals("2")) {
						System.out.println("Enter your New age");
						Integer newAge = scanner2.nextInt();
						student.setAge(newAge);
						System.out.println("Age updated successfully");

					} else if (value.equals("3")) {
						System.out.println("Enter your New Mark");
						int newMark = scanner2.nextInt();
						student.setMark(newMark);
						System.out.println("Mark updated successfully..");

					} else if (value.equals("4")) {
						System.out.println("Enter your Name");
						String newName = scanner2.next();
						System.out.println("Enter your Age");
						Integer newAge = scanner2.nextInt();
						System.out.println("Enter your Mark");
						int newMark = scanner2.nextInt();
						student.setName(newName);
						student.setAge(newAge);
						student.setMark(newMark);
						System.out.println("Data updated successfully...");

					} else {
						System.out.println("Invalid choice...!");
					}

		} catch (InputMismatchException e) {
			System.out.println("Invalid Input...");
			Launch.printData();
			System.exit(0);
		}
	}
	


	public static void updateStudent(Integer id, Scanner scanner2) {
		boolean state=false;	
		for (Student s : list) {
		      if (id.equals(s.getId())) {
		        data(id,scanner2,s);
		        state = true;
		        break;
		      } else {
		        state = false;
		      }
		      if ((list.size() - 1 == list.indexOf(s)) && !state) {
		        System.out.println("student ID not found");
		      }
		}	
	}
	
	
	/*--TO REMOVE DETAIL OF STUDENT--*/
	public static void removeStudent(Integer id) {
		boolean state=false;
		for (Student student : list) {
			
			 if (id.equals(student.getId())) {
				 list.remove(student);
					System.out.println("Removed Successfully...");
			        state = true;
			        break;
			      } else {
			        state = false;
			      }
			      if ((list.size() - 1 == list.indexOf(student)) && !state) {
			        System.out.println("student ID not found");
			      }
		}
	}

	/*--TO VIEW DATA--*/
	public static void viewData() {
		Collections.sort(list, new SortById());
		System.out.println("-------------------------------------------------");
		System.out.println("ID          NAME          AGE          MARK");
		System.out.println("-------------------------------------------------");
		for (Student s : list) {
			System.out.println(
					s.getId() + "          " + s.getName() + "          " + s.getAge() + "          " + s.getMark());
		}
		System.out.println("-------------------------------------------------");
	}

	/*--TO SORT DATAS--*/
	public static void sortData(Scanner scanner2) {
		System.out.println("Enter 1 to sort by Name");
		System.out.println("Enter 2 to sort by Age");
		System.out.println("Enter 3 to sort by Mark");
		String value = scanner2.next();
		if (value.equals("1")) {
			Collections.sort(list, new SortByName());
			for (Student str : list) {
				System.out.println(str);
			}
		} else if (value.equals("2")) {
			Collections.sort(list, new SortByAge());
			for (Student s : list) {
				System.out.println(s);
			}
		} else if (value.equals("3")) {
			Collections.sort(list, new SortByMark());
			for (Student s : list) {
				System.out.println(s);
			}
		} else {
			System.out.println("Wrong Action...");
		}

	}
	
	/*--TO READ AND WRITE DATA--*/
	
	public static void read() {
		list = ReadData.read("studentData.csv");
	}

	public static void write() {
		WriteData.writeToFile("studentData.csv", list);
	}

}
