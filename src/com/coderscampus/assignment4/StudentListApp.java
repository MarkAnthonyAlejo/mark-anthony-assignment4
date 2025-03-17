package com.coderscampus.assignment4;

public class StudentListApp {
    public static void main(String[] args) {
        FileService fileService = new FileService();

        Student[] students = fileService.readStudents("Master_List.csv");

        Student[] course1Students = new Student[students.length];
        Student[] course2Students = new Student[students.length];
        Student[] course3Students = new Student[students.length];

        int course1Index = 0;
        int course2Index = 0;
        int course3Index = 0;

        for(Student student : students){
            if(student != null) {
                if(student.getCourse().startsWith("COMPSCI")) {
                    course1Students[course1Index++] = student;
                } else if (student.getCourse().startsWith("APMTH")) {
                    course2Students[course2Index++] = student;
                } else if (student.getCourse().startsWith("STAT")) {
                    course3Students[course3Index++] = student;
                }
            }
        }

        fileService.sortByGrade(course1Students);
        fileService.sortByGrade(course2Students);
        fileService.sortByGrade(course3Students);

        fileService.writeStudents(course1Students, "course1.csv");
        fileService.writeStudents(course2Students, "course2.csv");
        fileService.writeStudents(course3Students, "course3.csv");


    }
}
