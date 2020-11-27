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
    public ArrayGradeBook(){};

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
                }catch (NumberFormatException e) { //if user doesn't input a number, this will catch the error
                    System.out.println("Error: Not a valid grade");
                }
            }
        }
        System.out.println(assignmentNames);
        //determineGrade
        //writeToGradebook();
        //Student.determineLetterGradeAndDifference(overallGrade)
    }
    /*
    protected static void getAssignementGrade(){

    }
    */
    protected static void writeToGradebook() throws IOException {
        /** Writes the overall category grades to
         * gradeBook.txt file.
         */
        File gradeFile = new File("src/gradeBook.txt");

        if (!gradeFile.exists()){
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
        }catch (IOException writerex){
            System.out.println(writerex.getStackTrace());
        }
    }

    protected static void determineOverallGrade(){
        /*
        for(int assignmentnum = 0; assignmentnum <= assignmentNames.size(); assignmentnum++){
        }

         */
        /*
        Assignment Weights
        Quizzes: 20% (225)
        Exams: 30% (100)
        Homework: 25% (100)
        Project: 25% (125)
        Maximum Points: 700
        */

        double quizWeight = 0.2;
        double examWeight = 0.3;
        double homeworkWeight = 0.25;
        double projectWeight = 0.25;

        double quizGrade;
        for (String assignmentname : assignmentNames){
            if (assignmentname.contains("Quiz")) {
                quizGrade = 0;
            }
        }


       /*
        while(this.quizGrade > 100 || this.quizGrade < 0){
            System.out.print("Invalid Grade, please enter a correct grade: ");
            this.quizGrade = scan.nextDouble();
            scan.nextLine();
        }
        this.quizGrade
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

        overallGrade = quizWeightedGrade + examWeightedGrade + homeworkWeightedGrade + projectWeightedGrade;

        */
    }
}
