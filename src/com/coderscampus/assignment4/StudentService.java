package com.coderscampus.assignment4;

import java.util.Arrays;

public class StudentService {
    public void sortByGrade(Student[] students) {
        Arrays.sort(students, (student1, student2) -> {
            if (student1 == null || student2 == null) {
                return 0;
            }
            Integer grade1 = Integer.parseInt(student1.getGrade());
            Integer grade2 = Integer.parseInt((student2.getGrade()));
            return grade2.compareTo(grade1);
        });
    }

    public Student[] sortByCourse(Student[] students, String course) {

        int studentCount = 0;
        for(Student student : students){
            if(student != null){
                if(student.getCourse().trim().startsWith(course)){
                    studentCount++;
                }
            }
        }

        Student[] studentsByCourse = new  Student[studentCount];
        int index = 0;

        for(Student student : students){
            if(student != null) {
                if(student.getCourse().trim().startsWith(course)) {
                    studentsByCourse[index++] = student;
                }
            }
        }
        return studentsByCourse;
    }

}
