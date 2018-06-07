package com.asahi.studentDetails.manager;

import com.asahi.studentDetails.entities.Student;

public class StudentManager {
	
	private static int count=0;
	private static StudentManager instance = null;
	
	private StudentManager() {
		count++;
	}

	public static StudentManager getInstance() {
		if(count==0) {
			instance=new StudentManager();
		}
		return instance;
	}
	
	public Student createStudent(int id,String name,int age,int mark) {
		Student student=new Student(id,name,age,mark);
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		student.setMark(mark);
		return student;	
	}
}
