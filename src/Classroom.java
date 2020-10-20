import java.util.*;
public class Classroom {
    public static ArrayList<String> students = new ArrayList<String>();
    public static ArrayList<String> assignmentsAndTests = new ArrayList<String>();
    public static ArrayList<ArrayList<Double>> gradeMatrix = new ArrayList<ArrayList<Double>>();

    public Classroom(){
        students.add("Christian Apostoli");
        students.add("Lebron James");
        students.add("Kanye East");
        students.add("Thomas Washington");
    }
    public Classroom(ArrayList<String> students){
        Classroom.students = students;
    }
    public Classroom(ArrayList<String> students, ArrayList<String> assignmentsAndTests){
        Classroom.students = students;
        Classroom.assignmentsAndTests = assignmentsAndTests;
    }
    protected double classAverage(){
        double classAvg = 0.0;
        for(int i = 0; i <=  students.size(); i++){
            for(int j = 0; j<= assignmentsAndTests.size(); j++){
                classAvg += gradeMatrix.get(i).get(j);
            }
        }

        return  classAvg / assignmentsAndTests.size();
    }
    protected void addStudent(String firstName, String lastName){
        students.add(firstName + " " + lastName);
    }
    protected void removeStudent(String firstName, String lastName){
        students.remove(firstName + " " + lastName);
    }

    public static double getStudentsGrades(){
        double sumOfStudentScores = 0.00;
        int counter = 0;
        Scanner scan = new Scanner(System.in);
        boolean studentInput = true;
        while(studentInput){
            sumOfStudentScores += scan.nextInt();
            scan.nextLine();
            counter++;
        }
        return sumOfStudentScores / counter;
    }
}
