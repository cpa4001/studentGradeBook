import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Student {

    public String studentFirstName;
    public String studentLastName;
    public double overallGrade;
    int studentCommand;

    public Student(String studentFirstName, String studentLastName){
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    public Student(){
        this.overallGrade = 0;
        studentFirstName = "NULL";
        studentLastName = "NULL";
    }

    public Student(String studentName){
        String[] studentNameArray = studentName.split(" ");
        this.studentFirstName = studentNameArray[0];
        this.studentLastName = studentNameArray[1];
    }

    protected void determineOverallGrade(){

            /* determineLetterGrade will take in the final grade in decimal format
             * and determine the letter grade for that student.
             * double overallGrade: the students final grade in decimal format
             */
            if(overallGrade > 89.00){
                System.out.println("Your overall grade was an A!");
            }else if (overallGrade > 79.00){
                System.out.println("Your overall grade was a B");
            }else if (overallGrade > 69.00){
                System.out.println("Your overall grade was a C");
            } else if(overallGrade > 59.00){
                System.out.println("Your overall grade was a D");
            }else {
                System.out.println("Your overall grade was a F");
            }
    }
    public static boolean validateGradeWeight(double assignmentGrade, double assignmentWeight){
        if(assignmentGrade > 100 || assignmentGrade < 0 || assignmentWeight > 100 || assignmentWeight < 0 ){
            return false;
        }
        return true;
    }
    public static void writeFile() throws IOException {
        String line;
        // FileReader fileReader = new FileReader("src/temp.txt");
        File gradeFile = new File("src/gradefile.csv");

        if(!gradeFile.exists()){
            gradeFile.createNewFile();
        }
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(gradeFile, true));
            writer.write("");
            writer.close();
        } catch (IOException writerex){
            System.out.println(writerex.getStackTrace());
        }
        /*
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

         */
    }
    public static void addGrades(){
        Scanner scan = new Scanner(System.in);
        double quizWeight = 0.2;
        double examWeight = 0.3;
        double homeworkWeight = 0.25;
        double projectWeight = 0.25;
        int maxTotalPoints = 700;

        System.out.println("What was your overall quiz grade?");
        double quizGrade = scan.nextDouble();
        scan.nextLine();
        quizGrade *= quizWeight;

        System.out.println("What was your overall exam grade?");
        double examGrade = scan.nextDouble();
        scan.nextLine();
        examGrade *= examWeight;

        System.out.println("What was your overall homework grade?");
        double homeworkGrade = scan.nextDouble();
        scan.nextLine();
        homeworkGrade *= homeworkWeight;

        System.out.println("What was your overall project grade?");
        double projectGrade = scan.nextDouble();
        scan.nextLine();
        projectGrade  *= projectWeight;

        double overallGrade = quizGrade + examGrade + homeworkGrade + projectGrade;
        //determineLetterGrade(overallGrade);
    }
}
