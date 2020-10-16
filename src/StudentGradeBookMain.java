/**
  Student Gradebook acts as an interface where students can sign in and view grades, and
  where teachers can sign in, edit, and assign grades.
  Author: Christian Apostoli
  Date: 10/16/2020
 */
import java.lang.String;
import java.util.*;
@SuppressWarnings("DanglingJavadoc")
public class StudentGradeBookMain {
    public static void determineLetterGrade(double overallGrade){
        /** determineLetterGrade will take in the final grade in decimal format
         * and determine the letter grade for that student.
         * double overallGrade: the students final grade in decimal format
         */
        if(overallGrade > 89.00){
            System.out.println("Your overall grade was an A!");
        }else if (overallGrade > 79.00){
            System.out.println("Your overall grade was a B");
        }else if (overallGrade > 69.00){
            System.out.println("Your overall grade was a C");
        } else if(overallGrade > 59.00){
            System.out.println("Your overall grade was a D");
        }else{
            System.out.println("Your overall grade was a F");
        }
    }
    /*
    public static void getStudentGrades(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the assignment weight.");
        //assignmentWeight = scan.nextDouble();
        scan.nextLine();

        System.out.println("Please enter the student's grade for the assignment");
        //assignmentGrade = scan.nextDouble();
        scan.nextLine();
    }
    */
    public static boolean validateGradeWeight(double assignmentGrade, double assignmentWeight){
        if(assignmentGrade > 100 || assignmentGrade < 0 || assignmentWeight > 100 || assignmentWeight < 0 ){
            return true;
        }
        return true;
    }
    public static void main(String[] args){
        //This array will have the names of all the students of the class

        Classroom introToProgramming = new Classroom();
        Scanner scan = new Scanner(System.in);

        System.out.print("Would you like to sign in as a Student or Teacher (S/T) ");
        String signInOption = scan.nextLine();
        boolean passwordCorrect = false;

        if(signInOption.toLowerCase().equals("s")) {
            System.out.println("Welcome Student.");
            passwordCorrect = true;
        }
        while(!passwordCorrect){
            System.out.print("Please Enter Teacher Password ");
            String password = scan.nextLine();
            if(password.toLowerCase().equals("teacheradmin")){
                passwordCorrect = true;
                System.out.println("Welcome Professor");
            }
        }

        boolean teacherInput = true;
        while(teacherInput){
            //getinput();
            System.out.println("-----------------------");
            System.out.println("Please enter a command (1-6)");
            System.out.println("(1) Show all students.");
            System.out.println("(2) Show all students' grades.");
            System.out.println("(3) Add an Assignment.");
            System.out.println("(4) Add a Test.");
            System.out.println("(5) Assign a grade.");
            System.out.println("(6) Edit a grade.");
            System.out.println("(7) Exit Program");
            int command = scan.nextInt();
            scan.nextLine();
            System.out.println("-------------------------");

            Teacher greenwell = new Teacher();
            if (command != 7){
                greenwell.teacherDecision(command);
            }else{
                teacherInput = false;
            }




        }
    }
}
