package com.asahi.studentDetails;

import java.util.Comparator;

import com.asahi.studentDetails.entities.Student;

public class SortById implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2) {
        if(s1.getId() > s2.getId()){
            return 1;
        } else {
            return -1;
        }
    }
}
