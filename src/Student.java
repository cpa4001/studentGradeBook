import java.io.*;
import java.util.Scanner;
import java.lang.Math;
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
        this.overallGrade = 0;
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
                System.out.println("Your overall grade is a F");
                gradeDifference = 60.00 - this.overallGrade;
                System.out.println("You are " + String.format("%.2f",gradeDifference) + " percent from a D");
                System.out.println("You might want to consider withdrawing from the course.");
            }
    }
    public static boolean validateGradeWeight(double assignmentGrade, double assignmentWeight){
        if(assignmentGrade > 100 || assignmentGrade < 0){
            return false;
        }
        return true;
    }
    public void writeFile() throws IOException {
        /** Writes the overall category grades to
         * gradebook.txt file.
         */
        String line;
        // FileReader fileReader = new FileReader("src/temp.txt");
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
            writer.close();
        } catch (IOException writerex){
            System.out.println(writerex.getStackTrace());
        }
    }
    protected void readFile() throws FileNotFoundException {
        String line;
        FileReader fileReader = new FileReader("src/gradebook.txt");
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
        int maxTotalPoints = 700;

        System.out.print("What was your overall quiz grade? ");
        this.quizGrade = scan.nextDouble();
        scan.nextLine();
        quizGrade *= quizWeight;

        System.out.print("What was your overall exam grade? ");
        this.examGrade = scan.nextDouble();
        scan.nextLine();
        examGrade *= examWeight;

        System.out.print("What was your overall homework grade? ");
        this.homeworkGrade = scan.nextDouble();
        scan.nextLine();
        homeworkGrade *= homeworkWeight;

        System.out.print("What was your overall project grade? ");
        this.projectGrade = scan.nextDouble();
        scan.nextLine();
        projectGrade  *= projectWeight;

        this.overallGrade = quizGrade + examGrade + homeworkGrade + projectGrade;
        determineLetterGradeAndDifference();
        writeFile();
    }
}
