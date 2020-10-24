import java.util.*;
public class Classroom {
    public static ArrayList<String> students = new ArrayList<>();
    public static ArrayList<String> assignmentsAndTests = new ArrayList<>();
    public static ArrayList<ArrayList<Double>> gradeMatrix = new ArrayList<ArrayList<Double>>();

    public Classroom(){
        //Dummy values for students.
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
        int counter = 1;
        Scanner scan = new Scanner(System.in);
        boolean studentInput = true;
        System.out.println("Please enter your scores:");
        while(studentInput){
            System.out.print("Score "+ counter + ": ");
            sumOfStudentScores += scan.nextInt();
            String endCommand = scan.nextLine();
            counter++;
            if(endCommand.toLowerCase().equals("end")){
                studentInput = false;
            }
        }
        return sumOfStudentScores / (counter - 1);
    }
}
