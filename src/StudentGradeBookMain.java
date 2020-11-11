/**
  * Student Grade Book acts as an interface where students can sign in and view grades, and
  * where teachers can sign in, edit, and assign grades.
  * Author: Christian Apostoli
  * Date: 11/04/2020
 */
import java.lang.String;
import java.util.*;
import java.io.*;
public class StudentGradeBookMain {
    //Courses that the student can pick to calculate their overall grade
    public static final String[] AVAILABLE_CLASSES = {"COMPUTATIONAL MATH", "GRAPH THEORY", "DIFFERENTIAL EQUATIONS",
            "LINEAR ALGEBRA", "DISCRETE MATH", "MATH HISTORY", "STATISTICS", "COP 2006"};
    public static ArrayList<String> previouslySelectedClasses = new ArrayList<>();

    protected static void validateClass(){
        /** Verifies that the student is taking a valid and
         * available class that exists and has not been previously entered.
         */
        Scanner scan = new Scanner(System.in);
        System.out.println(Arrays.toString(AVAILABLE_CLASSES));
        System.out.print("Please select a class out of the available courses above: ");
        String classSelected = scan.nextLine().toUpperCase();

        while (!Arrays.asList(AVAILABLE_CLASSES).contains(classSelected) ||
                previouslySelectedClasses.contains(classSelected)) {

            //while the class selected by the student is not in available classes
            // the console will prompt for correct class
            if (!Arrays.asList(AVAILABLE_CLASSES).contains(classSelected)) {
                System.out.print("Invalid class, please enter a correct class: ");
                classSelected = scan.nextLine().toUpperCase();

            } else if (previouslySelectedClasses.contains(classSelected)) {
                //while the class selected by the student was preveiously selected the console
                // will prompt for a new and correct class
                System.out.print("This class has already been selected, please enter a new class: ");
                classSelected = scan.nextLine().toUpperCase();
            }
        }
        pageLineBreak();
        previouslySelectedClasses.add(classSelected);
        System.out.println("ENTERING GRADES FOR " + classSelected);
    }
    private static void pageLineBreak(){
        /** Prints a line of hyphens to break up sections of the console
         * for increased readability for the user.
         */
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) throws IOException{

        //Courses that the student can pick to calculate their overall grade
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your first and last name: ");
        String studentName = scan.nextLine();
        //Student's name will be split into first name and last name
        String[] studentFullName = studentName.split(" ");

        //Creates a student object using the first two elements in studentFullName
        Student student = new Student(studentFullName[0], studentFullName[1]);

        //Flag to see if the student is still inputting grades
        boolean studentGradeInput = true;
        //Flag for the current class for use in final version
        //boolean studentGradeInputCurrentClass = true;

        //Numeric command which will be the students choice of action
        int studentExitCommand = 0;

        //Counter increments by 1 for every class selected
        int courseSelectedCounter = 0;

        int gradebookFirstLine = 0;
        while(studentGradeInput) {
            if(studentExitCommand == 0 || studentExitCommand == 2) {
                System.out.print("Would you like to \n" +
                        "(1) Enter grades for a class  \n" +
                        "(2) Look at grades for a previous class \n" +
                        "Enter a command (1-2) ");
                studentExitCommand = scan.nextInt();
                scan.nextLine();
            }

            switch(studentExitCommand){
                case 1:
                    pageLineBreak();
                    break;
                case 2:
                    //For alpha, students will not be allowed to just look at previous grades and exit
                    // at INITIAL command prompt, this option is given at the end of the while loop
                    pageLineBreak();
                    //Will recall all previously entered grades
                    student.recallPreviousGrades();
                    pageLineBreak();
                    System.out.print("Would you like to \n" +
                            "(1) Enter grades for a class  \n" +
                            "(2) Exit the gradebook \n" +
                            "Enter a command (1-2) ");
                    studentExitCommand = scan.nextInt();
                    scan.nextLine();
                    if(studentExitCommand == 2){
                        studentGradeInput = false;
                        pageLineBreak();
                        System.out.println("Have a nice day.");
                    }
                    pageLineBreak();
                    break;
            }
            if(studentExitCommand == 1){
                validateClass();
                //This will write the name to the gradebook only once
                if(gradebookFirstLine == 0){
                    student.writeNameToGradebook();
                    gradebookFirstLine = 1;
                }
                //HashGradebook.addAssignment();
                student.setCategoryGrades();
                //The student will be prompted for the grades of the current class until
                //they answer "n"
            /* Will be used in final version when asking for list of values
            System.out.print("Are you done entering grades for this class? (y/n) ");
            studentYesOrNo = scan.nextLine();
            if(studentYesOrNo.toLowerCase().equals("y")){
                studentGradeInputCurrentClass = false;
                courseSelectedCounter++;
                previouslySelectedClasses.add(classSelected);
            } else{
                courseSelectedCounter++;
            }
            */
                courseSelectedCounter++;
                pageLineBreak();

                //Student's response will keep program running or close program.
                System.out.print("Would you like to \n" +
                        "(1) Enter grades for a class  \n" +
                        "(2) Look at previous grades \n" +
                        "(3) Look at previous grades and exit the Gradebook  \n" +
                        "(4) Exit the Gradebook \n"+
                        "Enter a command (1-4) ");
                studentExitCommand = scan.nextInt();
                scan.nextLine();

                switch(studentExitCommand){
                    case 1:
                        break;
                    case 2:
                        pageLineBreak();
                        student.recallPreviousGrades();
                        pageLineBreak();
                        System.out.print("Would you like to \n" +
                                "(1) Enter grades for a class  \n" +
                                "(2) Exit the gradebook \n" +
                                "Enter a command (1-2)");
                        studentExitCommand = scan.nextInt();
                        scan.nextLine();
                        if(studentExitCommand == 2){
                            studentGradeInput = false;
                            System.out.println("Have a nice day.");
                        }
                        break;
                    case 3:
                        pageLineBreak();
                        student.recallPreviousGrades();
                        studentGradeInput = false; //Student has chosen to exit the gradebook after receiving recorded grades
                        pageLineBreak();
                        System.out.println("Have a nice day.");
                        break;
                    case 4:
                        pageLineBreak();
                        studentGradeInput = false; //Student has chosen to exit gradebook
                        System.out.println("Have a nice day.");
                        break;
                }
                //When the counter reaches 8, the student is notified there are no more classes to enter grades for, and
                //the program will end.
                if(courseSelectedCounter == 8){
                    pageLineBreak();
                    System.out.println("There are no more classes to enter grades for.");
                    System.out.println("Have a nice day.");
                    studentGradeInput = false;
                }
            }
        }
    }
}
