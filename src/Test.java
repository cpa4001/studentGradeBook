import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Test {
    protected String testName;
    protected double testWeight;
    //Gets current local date
    LocalDate date = LocalDate.now();
    //Formats date to dd-MM-yyyy
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Test(){
        //testWeight
        this.testName = "Midterm " + date.format(formatter);
        this.testWeight = 0.30;
    }
    public Test(String testName){
        this.testName = testName;
        this.testWeight = 0.30;
        //Classroom.assignmentsAndTests.add(testName);
    }
}
