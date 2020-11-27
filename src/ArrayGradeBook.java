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
    public static void addAssignment() throws IOException {

        Scanner scan = new Scanner(System.in);
        boolean gradeInput = true;
        System.out.println("PLEASE ENTER ONLY REAL NUMBERS (0.00 - 100.00) UP TO TWO DECIMAL PLACES.");
        System.out.println("Enter END to stop entering grades");
        while(gradeInput) {

            String assignmentName = scan.nextLine();
            if (assignmentName.toUpperCase().equals("END")) {
                gradeInput = false;
            } else {
                assignmentNames.add(assignmentName);
                try{
                    double assignementGrade = scan.nextDouble();
                    scan.nextLine();
                    while(assignementGrade > 100 || assignementGrade < 0){
                        System.out.print("Invalid Grade, please enter a correct grade: ");
                        assignementGrade = scan.nextDouble();
                        scan.nextLine();
                    }
                    assignmentGrades.add(assignementGrade);
                }catch(NumberFormatException e) { //if user doesn't input a number, this will catch the error
                    System.out.println("Error: Not a valid grade");
                }
            }
        }
        System.out.println(assignmentNames);
        //determineGrade
        //writeToGradebook();
        //Student.determineLetterGradeAndDifference(overallGrade)
    }
    protected static void getAssignementGrade(){

    }

    protected static void writeToGradebook() throws IOException {
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

    protected static void determineOverallGrade(){
        for(int assignmentnum = 0; assignmentnum <= assignmentNames.size(); assignmentnum++){
        }
    }
}
