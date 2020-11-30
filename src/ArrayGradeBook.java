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
    public ArrayGradeBook(){}

    protected void addAssignment() throws IOException {
        /** Continuosly prompts the user to enter their grades for each assignment
         *  and stores grades in assignmentGrades ArrayList
         */

        Scanner scan = new Scanner(System.in);
        boolean gradeInput = true;
        System.out.println("PLEASE ENTER ONLY REAL NUMBERS (0.00 - 100.00) UP TO TWO DECIMAL PLACES.");
        System.out.println("Enter END to stop entering grades");
        while(gradeInput) {

            String assignmentName = scan.nextLine();
            if (assignmentName.toUpperCase().equals("END")) {
                gradeInput = false;
            } else {
                assignmentNames.add(assignmentName.toLowerCase());
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
        determineOverallGrade();
    }
    /*
    protected static void getAssignementGrade(){

    }
    */
    protected void writeToGradebook(String studentFirstName, String studentLastName) throws IOException {
        /** Writes all grades that the student has entered to
         * gradeBook.txt file for the current student.
         * @param studentFirstName
         * @param studentLastName
         */
        File gradeFile = new File("src/gradeBook" + studentFirstName + studentLastName + ".txt");

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

    protected void determineOverallGrade() throws IOException {
        /** Iterates through assignmentNames ArrayList and filters out assignment type.
         *  Takes a sum of grades for
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
        int numberOfQuizzes = 1;
        int numberOfExams = 1;
        int numberOfHomework = 1;
        int numberOfProjects = 1;


        for(int assignmentnum = 0; assignmentnum <= assignmentNames.size(); assignmentnum++){
            if (assignmentNames.get(assignmentnum).contains("quiz")){
                quizGrade += assignmentGrades.get(assignmentnum);
                numberOfQuizzes++;
            }else if (assignmentNames.get(assignmentnum).contains("exam")){
                examGrade += assignmentGrades.get(assignmentnum);
                numberOfExams++;
            }else if (assignmentNames.get(assignmentnum).contains("homework")){
                homeworkGrade += assignmentGrades.get(assignmentnum);
                numberOfHomework++;
            }else if (assignmentNames.get(assignmentnum).contains("project")){
                projectGrade += assignmentGrades.get(assignmentnum);
                numberOfProjects++;
            }
        }

        this.quizGrade /= numberOfQuizzes;
        this.projectGrade /= numberOfProjects;
        this.examGrade /= numberOfExams;
        homeworkGrade /= numberOfHomework;

        this.quizGrade *= quizWeight;
        this.projectGrade *= projectWeight;
        this.examGrade *= examWeight;
        this.homeworkGrade *= homeworkWeight;

        this.overallGrade = this.quizGrade + this.homeworkGrade + this.examGrade + this.projectGrade;

        Student.determineLetterGradeAndDifference(this.overallGrade);

    }
}
