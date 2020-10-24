import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Assignment {
    protected String assignmentName;
    protected double assignmentWeight;
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    /*
        Assignment Weights
        Quizzes: 20% (225)
        Homework: 25% (100)
        Project: 25% (125)
        Maximum Points: 700
     */

    public Assignment(){
        //If no assignment name is given, name will be generated for current date
        this.assignmentName = "Class Assignment" + date.format(formatter);
    }
    public Assignment(String assignmentName){
        //We will keep the weight all 25%
        this.assignmentName = assignmentName;
        this.assignmentWeight = 0.30;
        Classroom.assignmentsAndTests.add(assignmentName);
    }
    /*
    public Assignment(String assignmentName, double assignmentWeight){
        this.assignmentName = assignmentName;
        this.assignmentWeight = assignmentWeight;
    }

     */
}
