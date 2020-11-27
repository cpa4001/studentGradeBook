import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ArrayGradeBook {
    private static ArrayList<String> assignmentNames = new ArrayList<>();
    private static ArrayList<Double> assignmentGrades = new ArrayList<>();

    private double overallGrade;
    private double quizGrade;
    private double examGrade;
    private double homeworkGrade;
    private double projectGrade;

    public static void addAssignment(){

        Scanner scan = new Scanner(System.in);
        boolean gradeInput = true;
        while(gradeInput) {
            System.out.println("PLEASE ENTER ONLY REAL NUMBERS (0.00 - 100.00) UP TO TWO DECIMAL PLACES.");
            System.out.println("Enter END to stop entering grades");

            String assignmentName = scan.nextLine();
            if (assignmentName.toUpperCase().equals("END")) {
                gradeInput = false;
            } else {
                assignmentNames.add(assignmentName);

                double assignementGrade = scan.nextDouble();
                scan.nextLine();
                assignmentGrades.add(assignementGrade);
            }
        }
    }

    protected void writeToGradebook() throws IOException {
        /** Writes the overall category grades to
         * gradeBook.txt file.
         */
        File gradeFile = new File("src/gradeBook.txt");

        if(!gradeFile.exists()){
            gradeFile.createNewFile();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(gradeFile, true));
            for(int assignmentnum = 0; assignmentnum <= assignmentNames.size(); assignmentnum++){
                writer.write(assignmentNames.get(assignmentnum) + " " + assignmentGrades.get(assignmentnum));
            }
            writer.close();
            /*
            The arrays are being cleared since they need to be used for different classes
             */
            assignmentNames.clear();
            assignmentGrades.clear();
        } catch (IOException writerex){
            System.out.println(writerex.getStackTrace());
        }
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
}
