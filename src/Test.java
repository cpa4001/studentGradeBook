import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Test {
    protected String testName;
    protected double testWeight;
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Test(){
        this.testName = "Midterm " + date.format(formatter);
        this.testWeight = 0.70;
        Classroom.assignmentsAndTests.add(testName);
    }
    public Test(String testName){
        this.testName = testName;
        this.testWeight = 0.70;
        Classroom.assignmentsAndTests.add(testName);
    }
    public  Test(String testName, double testWeight){
        this.testName = testName;
        this.testWeight = testWeight;
    }
}
