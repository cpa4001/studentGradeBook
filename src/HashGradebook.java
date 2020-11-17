import java.util.*;

public class HashGradebook {
    public static Map<String,Double> hashGradeBook = new Hashtable<>();

    public static void addAssignment(){
        ArrayList<String> assignmentNames = new ArrayList<>();
        ArrayList<Double> assignmentGrades = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean gradeInput = true;
        while(gradeInput){
            double assignmentGrade = scan.nextDouble();
        }

        for(int i = 0; i< assignmentNames.size(); i++){
            hashGradeBook.put(assignmentNames.get(i), assignmentGrades.get(i));
        }
    }
}
