package coderscampus.com.assignment4;

import java.io.*;
import java.util.Arrays;

public class FileService {

    public Student[] readStudents(String fileName) {
        Student[] students = new Student[100];

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            int index = 0;
            bufferedReader.readLine(); //To skip the title
            while((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split(",");
                Student student = new Student(splitLine[0],splitLine[1],splitLine[2],splitLine[3]);
                students[index++] = student;
            }
        } catch (IOException e) {
            System.out.println("Oops, there was an error reading the file: " + e.getMessage());
        }
        return students;
    }

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

    public void writeStudents(Student[] students, String course) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(course))) {
            bufferedWriter.write("Student ID, Name, Course, Grade\n");

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
