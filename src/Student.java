public class Student {

    public String studentFirstName;
    public String studentLastName;
    public String studentId;
    public String className;
    public double overallGrade;

    public Student(String studentFirstName, String studentLastName){
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        Classroom.students.add(studentFirstName + " " + studentLastName);

    }

    public Student(){
        this.overallGrade = 0;
        studentFirstName = "NULL";
        studentLastName = "NULL";
    }

}
