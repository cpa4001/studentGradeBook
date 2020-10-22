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
    private static void determineLetterGrade(double overallGrade){
        /* determineLetterGrade will take in the final grade in decimal format
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
            return false;
        }
        return true;
    }
    public static void writeFile() throws IOException{
        String line;
        // FileReader fileReader = new FileReader("src/temp.txt");
        File gradeFile = new File("src/gradefile.csv");

        if(!gradeFile.exists()){
            gradeFile.createNewFile();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(gradeFile, true));
            writer.write("");
            writer.close();
        } catch (IOException writerex){
            System.out.println(writerex.getStackTrace());
        }
        /*
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            //addGrades();
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + ex.getStackTrace() + "'");
        }
        catch(IOException e) {
            System.out.println("Error reading file '" + e.getStackTrace() + "'");


        }

         */
    }
    public static void addGrades(){
        Scanner scan = new Scanner(System.in);
        double quizWeight = 0.2;
        double examWeight = 0.3;
        double homeworkWeight = 0.25;
        double projectWeight = 0.25;
        int maxTotalPoints = 700;

        System.out.println("What was your overall quiz grade?");
        double quizGrade = scan.nextDouble();
        scan.nextLine();
        quizGrade *= quizWeight;

        System.out.println("What was your overall exam grade?");
        double examGrade = scan.nextDouble();
        scan.nextLine();
        examGrade *= examWeight;

        System.out.println("What was your overall homework grade?");
        double homeworkGrade = scan.nextDouble();
        scan.nextLine();
        homeworkGrade *= homeworkWeight;

        System.out.println("What was your overall project grade?");
        double projectGrade = scan.nextDouble();
        scan.nextLine();
        projectGrade  *= projectWeight;

        double overallGrade = quizGrade + examGrade + homeworkGrade + projectGrade;
        determineLetterGrade(overallGrade);
    }
    public static void main(String[] args) throws IOException{

        final String[] CLASS_SELECTION = {"Computational Math", "Graph Theory", "Differential Equations", "Linear Algebra", "Discrete Math"};
        Classroom introToProgramming = new Classroom();
        Scanner scan = new Scanner(System.in);

        System.out.print("What class are you entering for: ");
        String classPick = scan.nextLine();
        boolean studentInput = true;
        String studentYesOrNo;
        while(studentInput) {
            while (!Arrays.asList(CLASS_SELECTION).contains(classPick)) {
                System.out.print("Invalid class, please enter a correct class: ");
                classPick = scan.nextLine();
            }

            System.out.print("Are you done entering grades for this class(y/n)");
            studentYesOrNo = scan.nextLine();
            if(studentYesOrNo.toLowerCase().equals("y")){
                studentInput = false;
            }
        }
        /*
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
            //getInput();
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

         */
    }
}
