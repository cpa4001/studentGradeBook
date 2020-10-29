import java.io.*;
import java.util.Scanner;
public class Student {

    public String studentFirstName;
    public String studentLastName;
    public double overallGrade;
    int studentCommand;

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

            /* determineLetterGrade will take in the final grade in decimal format
             * and determine the letter grade for that student. It will also calculate
             * the percentage needed to earn the next highest grade
             * double overallGrade: the students final grade in decimal format
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
        String line;
        // FileReader fileReader = new FileReader("src/temp.txt");
        File gradeFile = new File("src/gradebook.txt");

        if(!gradeFile.exists()){
            gradeFile.createNewFile();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(gradeFile, true));
            writer.write("Overall grade for "+ this.studentFirstName +
                         this.studentLastName + String.valueOf(this.overallGrade));
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

    protected void getCategoryGrades() throws IOException {
        Scanner scan = new Scanner(System.in);
        double quizWeight = 0.2;
        double examWeight = 0.3;
        double homeworkWeight = 0.25;
        double projectWeight = 0.25;
        int maxTotalPoints = 700;

        System.out.print("What was your overall quiz grade? ");
        double quizGrade = scan.nextDouble();
        scan.nextLine();
        quizGrade *= quizWeight;

        System.out.print("What was your overall exam grade? ");
        double examGrade = scan.nextDouble();
        scan.nextLine();
        examGrade *= examWeight;

        System.out.print("What was your overall homework grade? ");
        double homeworkGrade = scan.nextDouble();
        scan.nextLine();
        homeworkGrade *= homeworkWeight;

        System.out.print("What was your overall project grade? ");
        double projectGrade = scan.nextDouble();
        scan.nextLine();
        projectGrade  *= projectWeight;

        this.overallGrade = quizGrade + examGrade + homeworkGrade + projectGrade;
        determineLetterGradeAndDifference();
        writeFile();
    }
}
