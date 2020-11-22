import java.util.*;

public class HashGradebook {
    public static Map<String,Double> hashGradeBook = new Hashtable<>();

    public static void addAssignment(){
        ArrayList<String> assignmentNames = new ArrayList<>();
        ArrayList<Double> assignmentGrades = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean gradeInput = true;
        while(gradeInput) {
            System.out.println("PLEASE ENTER ONLY REAL NUMBERS (0.00 - 100.00) UP TO TWO DECIMAL PLACES.");

            String assignmentName = scan.nextLine();
            if (assignmentName.toUpperCase().equals("END")) {
                gradeInput = false;
            } else {
                assignmentNames.add(assignmentName);

                double assignementGrade = scan.nextDouble();
                scan.nextLine();
                assignmentGrades.add(assignementGrade);
            }
        }
        for(int i = 0; i< assignmentNames.size(); i++){
            hashGradeBook.put(assignmentNames.get(i), assignmentGrades.get(i));
        }
    }
}
