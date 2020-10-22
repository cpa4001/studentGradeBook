import java.util.Scanner;
public class Student {

    public String studentFirstName;
    public String studentLastName;
    public double overallGrade;
    int studentCommand;

    public Student(String studentFirstName, String studentLastName){
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        Classroom.students.add(studentFirstName + " " + studentLastName);

    }

    public Student(){
        this.overallGrade = 0;
        studentFirstName = "NULL";
        studentLastName = "NULL";
    }

    protected void studentAction(){
        Scanner scan  = new Scanner(System.in);
        System.out.println("-----------------------");
        System.out.println("Please enter a command (1-6)");
        System.out.println("(1) Show individual grades.");
        System.out.println("(2) Show overall grade.");
        this.studentCommand = scan.nextInt();
        scan.nextLine();
        System.out.println("-----------------------");

        boolean validCommand = false;
        while(!validCommand){
            if (this.studentCommand > 7 || this.studentCommand < 1){
                System.out.println("Not a valid command, please enter a number (1-7): ");
                this.studentCommand = scan.nextInt();
                scan.nextLine();
            }else if (this.studentCommand != 7) {
                studentSwitch();
            }else{
                validCommand = true;
                System.out.println("Have a nice day Professor.");
            }
        }
    }

    protected void studentSwitch(){
        switch(this.studentCommand){
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
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


}
