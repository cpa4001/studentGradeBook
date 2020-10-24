/*
  Student Grade Book acts as an interface where students can sign in and view grades, and
  where teachers can sign in, edit, and assign grades.
  Author: Christian Apostoli
  Date: 10/16/2020

  ADD ALL JAVADOCS ON GITHUB
 */
import java.lang.String;
import java.util.*;
import java.io.*;
public class StudentGradeBookMain {
    public static void main(String[] args) throws IOException{

        final String[] AVAILABLE_CLASSES = {"Computational Math", "Graph Theory", "Differential Equations",
                                           "Linear Algebra", "Discrete Math", "Math History", "Statistics"};
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your first and last name: ");
        String studentName = scan.nextLine();
        //Student's name will be split into first name and last name
        String[] studentFullName = studentName.split(" ");

        //Creates a student object using the first two elements in studentFullName
        Student student = new Student(studentFullName[0],studentFullName[1]);
        System.out.print("What class are you entering for: ");
        String classSelected = scan.nextLine();

        boolean studentGradeInput = true;
        boolean studentGradeInputCurrentClass = true;
        String studentYesOrNo = "y";
        while(studentGradeInput) {
            while (!Arrays.asList(AVAILABLE_CLASSES).contains(classSelected)) {
                //while the class selected by the student is available/exists, the console will prompt for correct class
                System.out.print("Invalid class, please enter a correct class: ");
                classSelected = scan.nextLine();
            }
            while(studentGradeInputCurrentClass){
                System.out.print("Are you done entering grades for this class(y/n)");
                studentYesOrNo = scan.nextLine();
                //Student's choice of y will ex
                if(studentYesOrNo.toLowerCase().equals("y")){
                    studentGradeInput = false;
                } /* else{

                }
                */
            }

            System.out.println("Are you done entering grades? (y/n)");
            studentYesOrNo = scan.nextLine();

            if(studentYesOrNo.toLowerCase().equals("y")){
                studentGradeInput = false;
            }
        }
    }
}
