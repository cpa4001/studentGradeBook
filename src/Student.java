/** Student class will handle grade input, calculating a student's overall grade,
 *  writing to a gradebook text file, and recalling previous grades.
 *  Author: Christian Apostoli
 *  Date: 11/02/2020
 */

import java.io.*;
public class Student {

    public final String studentFirstName;
    public final String studentLastName;
    public Student(String studentFirstName, String studentLastName){
        /** Constructs a student object using passed name.
         * @param studentFirstName
         * @param studentLastName
         */
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    public static void determineLetterGradeAndDifference(double overallGrade){
        /** Determines the letter grade for the student. Calculates
         * the percentage needed to earn the next highest grade
         * @param overallGrade the students final class grade in decimal format
         */
        double gradeDifference;
            if (overallGrade >= 90.00){
                System.out.println("Congratulations, your overall grade is an A for this course.");

            }else if (overallGrade >= 80.00){
                System.out.println("Your overall grade is a B for this course.");
                gradeDifference = 90.00 - overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from an A");

            }else if (overallGrade >= 70.00){
                System.out.println("Your overall grade is a C for this class.");
                gradeDifference = 80.00 - overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from a B");

            } else if (overallGrade >= 60.00){
                System.out.println("Your overall grade is a D");
                gradeDifference = 70.00 - overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from a C");

            }else{
                System.out.println("Your overall grade is an F");
                gradeDifference = 60.00 - overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from a D");
                System.out.println("You might want to consider withdrawing from the course.");
            }
    }

    protected void recallPreviousGrades() throws FileNotFoundException {
        /** Recalls all grades back to the student, and lets the student know
         *  there are no grades to recall if the file is black or does not exist.
         */
        String line;
        File gradeFile = new File("src/gradeBook" + studentFirstName + studentLastName + ".txt");


        try {
            if (!gradeFile.exists()) {
                //Ensures the program will not error when the user recalls grades when gradeBook file dosent exist
                System.out.println("There are no previously entered grades");
            }else{
                FileReader fileReader = new FileReader("src/gradeBook" + studentFirstName + studentLastName + ".txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                System.out.println(this.studentFirstName + " " + this.studentLastName);
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                FileReader nullfileReader = new FileReader("src/gradeBook" + studentFirstName + studentLastName + ".txt");
                BufferedReader nullbufferedReader = new BufferedReader(nullfileReader);
                if ((line = nullbufferedReader.readLine()) == null){
                    System.out.println("There are no previously entered grades");
                }
                nullbufferedReader.close();
                bufferedReader.close();
            }
        }catch (FileNotFoundException ex) {
            System.out.println("Error finding file '" + ex.getStackTrace() + "'");
        }catch (IOException e) {
            System.out.println("Error reading file '" + e.getStackTrace() + "'");
        }
    }
}
