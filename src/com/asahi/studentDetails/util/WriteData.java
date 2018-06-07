package com.asahi.studentDetails.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.asahi.studentDetails.entities.Student;

public class WriteData {
	public static void writeToFile(String fileName, List<Student> list){
		try(BufferedWriter br=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))){
			
			for(Student str1:list) {
					br.write(str1.toString()+"\n");
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
