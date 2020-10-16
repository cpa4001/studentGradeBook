import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Assignment {
    protected String assignmentName;
    protected double assignmentWeight;
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Assignment(){
        this.assignmentName = "Class Assignment" + date.format(formatter);
        this.assignmentWeight = 0.30;
        Classroom.assignmentsAndTests.add(assignmentName);
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
