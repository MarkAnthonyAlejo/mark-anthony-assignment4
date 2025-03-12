package coderscampus.com.assignment4;

public class Student {
    private String studentId;
    private String name;
    private String course;
    private String grade;

    public Student(String studentId, String name,String course, String grade){
        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", grade=" + grade +
                '}';
    }

}
