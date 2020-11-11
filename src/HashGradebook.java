import java.util.*;

public class HashGradebook {
    public static Map<String,Double> hashGradeBook = new Hashtable<>();

    public static void addAssignment(){
        Scanner scan = new Scanner(System.in);
        String assignmentName = scan.nextLine();
        while(!assignmentName.equals("END")){
            double assignmentGrade = scan.nextDouble();
            hashGradeBook.put(assignmentName, assignmentGrade);
        }
    }
}
