/** Student class will handle grade input, calculating a student's overall grade,
 *  writing to a gradebook text file, and recalling previous grades.
 *  Author: Christian Apostoli
 *  Date: 11/02/2020
 */

import java.io.*;
import java.util.Scanner;
public class Student {

    private String studentFirstName;
    private String studentLastName;
    private double overallGrade;
    int studentCommand;
    private double quizGrade;
    private double examGrade;
    private double homeworkGrade;
    private double projectGrade;

    public Student(String studentFirstName, String studentLastName){
        /** Constructs a student object using passed name.
         * @param studentFirstName
         * @param studentLastName
         */
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    public Student(){
        /** Constructs a student object if no information is given.
         */
        studentFirstName = "NULL";
        studentLastName = "NULL";
    }
    protected void determineLetterGradeAndDifference(){
        /** Determines the letter grade for the student. Calculates
             * the percentage needed to earn the next highest grade
             */
        double gradeDifference;
            if(this.overallGrade >= 90.00){
                System.out.println("Congratulations, your overall grade is an A for this course.");

            }else if (this.overallGrade >= 80.00){
                System.out.println("Your overall grade is a B for this course.");
                gradeDifference = 90.00 - this.overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from an A");

            }else if (this.overallGrade >= 70.00){
                System.out.println("Your overall grade is a C for this class.");
                gradeDifference = 80.00 - this.overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from a B");

            } else if(this.overallGrade >= 60.00){
                System.out.println("Your overall grade is a D");
                gradeDifference = 70.00 - this.overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from a C");

            }else {
                System.out.println("Your overall grade is an F");
                gradeDifference = 60.00 - this.overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from a D");
                System.out.println("You might want to consider withdrawing from the course.");
            }
    }
    protected void writeToGradebook() throws IOException{
        /** Writes the overall category grades to
         * gradeBook.txt file.
         */
        File gradeFile = new File("src/gradeBook.txt");

        if(!gradeFile.exists()){
            gradeFile.createNewFile();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(gradeFile, true));
            writer.write("Quiz Grade: " + String.format("%.2f", this.quizGrade) +"\n");
            writer.write("Exam Grade: " + String.format("%.2f", this.examGrade) + "\n");
            writer.write("Homework Grade: " + String.format("%.2f", this.homeworkGrade) + "\n");
            writer.write("Project Grade: " + String.format("%.2f", this.projectGrade) + "\n");
            writer.write("Overall grade: " + String.format("%.2f", this.overallGrade) + "\n");
            writer.close();
        } catch (IOException writerex){
            System.out.println(writerex.getStackTrace());
        }
    }
    protected void writeNameToGradebook() throws IOException{
        /** Writes the overall category grades to
         * gradeBook.txt file.
         */
        File gradeFile = new File("src/gradeBook.txt");

        if(!gradeFile.exists()){
            gradeFile.createNewFile();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(gradeFile, true));
            writer.write("Grades for " + this.studentFirstName + " " + studentLastName + "\n");
            writer.close();
        } catch (IOException writerex){
            System.out.println(writerex.getStackTrace());
        }
    }
    protected void recallPreviousGrades() throws FileNotFoundException {
        String line;
        File gradeFile = new File("src/gradeBook.txt");


        try {
            if(gradeFile.exists()) {
                FileReader fileReader = new FileReader("src/gradeBook.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                if((line = bufferedReader.readLine()) == null) {
                    //Lets the user know they have not entered grades if the text file is empty
                    System.out.println("There are no previously entered grades.");
                    bufferedReader.close();
                }else{
                    System.out.println(line);
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    bufferedReader.close();
                }
            }
            else{
                //Ensures the program will not error when the user recalls grades when gradeBook file dosent exist
                System.out.println("There are no previously entered grades");
            }

        }
        catch(FileNotFoundException ex) {
            System.out.println("Error finding file '" + ex.getStackTrace() + "'");
        }
        catch(IOException e) {
            System.out.println("Error reading file '" + e.getStackTrace() + "'");
        }
    }
    protected void setCategoryGrades() throws IOException {
        /** Prompts the student to enter their grades for each category.
         *  Calculates the weighted grade and overall class grade
         *  Calls the determineLetterGradeAndDifference() and
         *  writeFile() methods
         */

        /*
        Assignment Weights
        Quizzes: 20% (225)
        Homework: 25% (100)
        Project: 25% (125)
        Maximum Points: 700
        */

        Scanner scan = new Scanner(System.in);
        double quizWeight = 0.2;
        double examWeight = 0.3;
        double homeworkWeight = 0.25;
        double projectWeight = 0.25;

        System.out.println("PLEASE ENTER ONLY REAL NUMBERS (0.00 - 100.00) UP TO TWO DECIMAL PLACES.");

        System.out.print("What was your overall quiz grade? ");
        this.quizGrade = scan.nextDouble();
        scan.nextLine();
        while(this.quizGrade > 100 || this.quizGrade < 0){
            System.out.print("Invalid Grade, please enter a correct grade: ");
            this.quizGrade = scan.nextDouble();
            scan.nextLine();
        }
        double quizWeightedGrade = this.quizGrade;
        quizWeightedGrade *= quizWeight;

        System.out.print("What was your overall exam grade? ");
        this.examGrade = scan.nextDouble();
        scan.nextLine();
        while(this.examGrade > 100 || this.examGrade < 0){
            System.out.print("Invalid Grade, please enter a correct grade: ");
            this.examGrade = scan.nextDouble();
            scan.nextLine();
        }
        double examWeightedGrade = this.examGrade;
        examWeightedGrade *= examWeight;

        System.out.print("What was your overall homework grade? ");
        this.homeworkGrade = scan.nextDouble();
        scan.nextLine();
        while(this.homeworkGrade > 100 || this.homeworkGrade < 0){
            System.out.print("Invalid Grade, please enter a correct grade: ");
            this.homeworkGrade = scan.nextDouble();
            scan.nextLine();
        }
        double homeworkWeightedGrade = this.homeworkGrade;
        homeworkWeightedGrade *= homeworkWeight;

        System.out.print("What was your overall project grade? ");
        this.projectGrade = scan.nextDouble();
        scan.nextLine();
        while(this.projectGrade > 100 || this.projectGrade < 0){
            System.out.print("Invalid Grade, please enter a correct grade: ");
            this.projectGrade = scan.nextDouble();
            scan.nextLine();
        }
        double projectWeightedGrade = this.projectGrade;
        projectWeightedGrade  *= projectWeight;

        this.overallGrade = quizWeightedGrade + examWeightedGrade + homeworkWeightedGrade + projectWeightedGrade;
        determineLetterGradeAndDifference();
        writeToGradebook();
    }
}
