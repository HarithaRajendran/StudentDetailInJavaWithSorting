package com.asahi.studentDetails.util;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;

import com.asahi.studentDetails.entities.Student;
import com.asahi.studentDetails.manager.StudentManager;

public class ReadData {
	private static int count = 0;
	static String[] student = new String[100];
	static String[] f = new String[20];

	public static List<Student> read(String filename) {
		List<Student> lt = new ArrayList<Student>();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
			
			//Files.
			String line;

			while ((line = br.readLine()) != null) {
				student[count] = line;
				count++;
			}
			for (String s : student) {
				if (s != null) {
					String[] value = s.split(",");
					lt.add(StudentManager.getInstance().createStudent(Integer.parseInt(value[0]), value[1], Integer.parseInt(value[2]),
							Integer.parseInt(value[3])));
				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lt;

	}
}
