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

        final String[] AVAILABLE_CLASSES = {"COMPUTATIONAL MATH", "GRAPH THEORY", "DIFFERENTIAL EQUATIONS",
                                           "LINEAR ALGEBRA", "DISCRETE MATH", "MATH HISTORY", "STATISTICS", "COP 2006"};
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your first and last name: ");
        String studentName = scan.nextLine();
        //Student's name will be split into first name and last name
        String[] studentFullName = studentName.split(" ");

        //Creates a student object using the first two elements in studentFullName
        Student student = new Student(studentFullName[0],studentFullName[1]);

        boolean studentGradeInput = true;
        boolean studentGradeInputCurrentClass = true;
        String studentYesOrNo = "y";

        int courseSelectedCounter = 0;
        while(studentGradeInput) {

            System.out.println(Arrays.toString(AVAILABLE_CLASSES));
            System.out.print("Please select a class out of the available courses above: ");
            String classSelected = scan.nextLine().toUpperCase();
            System.out.println("----------------------------------------");
            while (!Arrays.asList(AVAILABLE_CLASSES).contains(classSelected)) {
                //while the class selected by the student is not in available classes
                // the console will prompt for correct class
                System.out.print("Invalid class, please enter a correct class: ");
                classSelected = scan.nextLine();
            }

            student.getCategoryGrades();
            //The student will be prompted for the grades of the current class until
            //they answer "n"
            System.out.print("Are you done entering grades for this class? (y/n) ");
            studentYesOrNo = scan.nextLine();
            if(studentYesOrNo.toLowerCase().equals("y")){
                studentGradeInputCurrentClass = false;
                courseSelectedCounter++;
            } /* else{

            }*/

            //Student's response will keep program running or close program.
            System.out.print("Are you done entering grades for all classes? (y/n) ");
            studentYesOrNo = scan.nextLine();
            System.out.println("----------------------------------------");

            if(studentYesOrNo.toLowerCase().equals("y")){
                studentGradeInput = false;
                System.out.println("Have a nice day.");
            }

            if(courseSelectedCounter > 8){
                System.out.println("There are no more classes to enter grades for.");
                System.out.println("Have a nice day.");
                studentGradeInput = false;
            }
        }
    }
}
