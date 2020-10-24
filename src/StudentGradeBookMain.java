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

        final String[] CLASS_SELECTION = {"Computational Math", "Graph Theory", "Differential Equations", "Linear Algebra", "Discrete Math"};
        Scanner scan = new Scanner(System.in);

        System.out.print("What is your first and last name: ");
        String studentName = scan.nextLine();
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
            System.out.println("Are you done entering grades? (y/n)");
            studentYesOrNo = scan.nextLine();

            if(studentYesOrNo.toLowerCase().equals("y")){
                studentInput = false;
            }
        }
    }
}
