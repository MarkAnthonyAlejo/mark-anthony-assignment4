package com.coderscampus.assignment4;

import java.io.*;
import java.util.Arrays;

public class FileService {

    public Student[] readStudents(String fileName) {

        int studentCount = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            while((bufferedReader.readLine()) != null){
                studentCount++;
            }
        } catch (IOException e) {
            System.out.println("Oops, there was an error counting the number of lines: " + e.getMessage());
        }

        Student[] students = new Student[studentCount];

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            int index = 0;
            bufferedReader.readLine(); //To skip the title
            while((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split(",");
                Student student = new Student(splitLine[0].trim(),splitLine[1].trim(),splitLine[2].trim(),splitLine[3].trim());
                students[index++] = student;
            }
        } catch (IOException e) {
            System.out.println("Oops, there was an error reading the file: " + e.getMessage());
        }
        return students;
    }

    public void writeStudents(Student[] students, String course) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(course))) {
            bufferedWriter.write("Student ID,Name,Course,Grade\n");

            for (Student student : students) {
                if(student != null){
                    bufferedWriter.write(student.getStudentId() + ","
                            + student.getName() + ","
                            + student.getCourse() + ","
                            + student.getGrade() + "\n");
                }
            }
        } catch (IOException e){
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
