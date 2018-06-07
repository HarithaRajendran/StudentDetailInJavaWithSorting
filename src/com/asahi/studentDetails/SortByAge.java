package com.asahi.studentDetails;

import java.util.Comparator;

import com.asahi.studentDetails.entities.Student;

public class SortByAge implements Comparator<Student>{

	    @Override
	    public int compare(Student s1, Student s2) {
//	        if(s1.getAge() > s2.getAge()){
//	            return 1;
//	        } else {
//	            return -1;
//	        }
	    	
	    	Integer a1 = s1.getAge();
	    	Integer a2 = s2.getAge();
	    	
	    	return a1.compareTo(a2);
	    }
}
