package com.asahi.studentDetails;

import java.util.Comparator;

import com.asahi.studentDetails.entities.Student;

public class SortByName implements Comparator<Student>{
	
	@Override
	public int compare(Student s1, Student s2) {
		   String studentName1 = s1.getName();
		   String studentName2 = s2.getName();

		   return studentName1.compareToIgnoreCase(studentName2);
	    }
	    
}
