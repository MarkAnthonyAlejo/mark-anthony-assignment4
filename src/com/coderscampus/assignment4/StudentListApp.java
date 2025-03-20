package com.coderscampus.assignment4;

public class StudentListApp {
    public static void main(String[] args) {

        FileService fileService = new FileService();
        StudentService studentService = new StudentService();

        Student[] students = fileService.readStudents("Master_List.csv");

        String[] courses = {"COMPSCI", "APMTH", "STAT"};
        int courseCount = 1;

        for(String course : courses){
            Student[] courseStudents = studentService.sortByCourse(students, course);
            studentService.sortByGrade(courseStudents);
            fileService.writeStudents(courseStudents, "course" + courseCount++ + ".csv");
        }

    }
}
