/**
  * Student Grade Book acts as an interface where students can sign in and view grades, and
  * where teachers can sign in, edit, and assign grades.
  * Author: Christian Apostoli
  * Date: 10/30/2020

 */
import java.lang.String;
import java.util.*;
import java.io.*;
public class StudentGradeBookMain {
    public static void main(String[] args) throws IOException{

        //Courses that the student can pick to calculate their overall grade
        final String[] AVAILABLE_CLASSES = {"COMPUTATIONAL MATH", "GRAPH THEORY", "DIFFERENTIAL EQUATIONS",
                                           "LINEAR ALGEBRA", "DISCRETE MATH", "MATH HISTORY", "STATISTICS", "COP 2006"};
        ArrayList<String> previouslySelectedClasses = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your first and last name: ");
        String studentName = scan.nextLine();
        //Student's name will be split into first name and last name
        String[] studentFullName = studentName.split(" ");

        //Creates a student object using the first two elements in studentFullName
        Student student = new Student(studentFullName[0],studentFullName[1]);

        //Flag to see if the student is still inputting grades
        boolean studentGradeInput = true;
        //Flag for the current class for use in final version
        //boolean studentGradeInputCurrentClass = true;
        int studentExitCommand;

        //Counter increments by 1 for every class selected
        int courseSelectedCounter = 0;
        while(studentGradeInput) {

            System.out.print("Would you like to \n" +
                            "(1) Enter grades for a class  \n" +
                            "(2) Look at grades for a previous class \n");
            studentExitCommand = scan.nextInt();

            switch(studentExitCommand){
                case 2:
                    student.recallPreviousGrades();
                    System.out.println("----------------------------------------");
                    break;
            }


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
            System.out.println("----------------------------------------");
            System.out.println("ENTERING GRADES FOR " + classSelected);
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
            previouslySelectedClasses.add(classSelected);
            System.out.println("----------------------------------------");

            //Student's response will keep program running or close program.
            System.out.print("Would you like to \n" +
                             "(1) Enter grades for a class  \n" +
                             "(2) Look at grades for a previous class \n" +
                             "(3) Exit the gradebook \n"+
                             "Enter a command (1-3) ");
            studentExitCommand = scan.nextInt();
            System.out.println("----------------------------------------");

            switch(studentExitCommand){
                case 1:
                    break;
                case 2:
                    student.recallPreviousGrades();
                    System.out.println("----------------------------------------");
                    break;
                case 3:
                    studentGradeInput = false; //Student has chosen to exit gradebook
                    System.out.println("Have a nice day.");
                    break;
            }
            //When the counter reaches 8, the student is notified there are no more classes to enter grades for.
            if(courseSelectedCounter == 8){
                System.out.println("There are no more classes to enter grades for.");
                System.out.println("Have a nice day.");
                studentGradeInput = false;
            }
        }
    }
}
