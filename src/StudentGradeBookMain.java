/**
  Student Gradebook acts as an interface where students can sign in and view grades, and
  where teachers can sign in, edit, and assign grades.
  Author: Christian Apostoli
  Date: 10/16/2020
 */
import java.lang.String;
import java.util.*;
import java.io.*;
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
    public static void writeFile(){
        String fileName = "studentgradebooktemp.txt";
        String line = null;
        FileReader fileReader = new FileReader(fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            //addgrades();
            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '" + fileName + "'");
        }
    }
    public static void main(String[] args){
        //This array will have the names of all the students of the class

        String[] CLASS_SELECTION = new String[5];
        CLASS_SELECTION = new String[]{"Computational Math", "Graph Theory", "Differential Equations", "Linear Algebra", "Discrete Math"};
        Classroom introToProgramming = new Classroom();
        Scanner scan = new Scanner(System.in);

        System.out.println("What class are you entering for");
        String classPick = scan.nextLine();
        
        while(Arrays.binarySearch(CLASS_SELECTION, classPick) <= 0){
            System.out.println("Invalid class, please enter a correct class");
            classPick = scan.nextLine();
        }
        System.out.print("Would you like to sign in as a Student or Teacher (S/T) ");
        String signInOption = scan.nextLine();
        boolean passwordCorrect = false;

        if(signInOption.toLowerCase().equals("s")) {
            System.out.println("Welcome Student.");
            passwordCorrect = true;
            //studentAction();
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
            System.out.println("(7) Exit Gradebook");
            int teacherCommand = scan.nextInt();
            scan.nextLine();
            System.out.println("-----------------------");

            Teacher greenwell = new Teacher();
            if (teacherCommand > 7 || teacherCommand < 1){
                System.out.println("Not a valid command, please enter a number (1-7): ");
                teacherCommand = scan.nextInt();
                scan.nextLine();
            }else if (teacherCommand != 7) {
                greenwell.teacherDecision(teacherCommand);
            }else{
                teacherInput = false;
                System.out.println("Have a nice day Professor.");
            }

        }
    }
}
