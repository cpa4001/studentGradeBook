public class Teacher {
    protected String teacherFirstName;
    protected String teacherLastName;
 // public String teacherId;
    public String className;

    public Teacher() {
        this.teacherFirstName = "Josiah";
        this.teacherLastName = "Greenwell";
   //   this.teacherId = "0015";
        this.className = "COP 2006";
    }
    public Teacher(String teacherFirstName, String teacherLastName){
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.className = "COP 2006";
    }
    public Teacher(String teacherFirstName, String teacherLastName, String className){
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
      //this.teacherId = teacherId;
        this.className = className;
    }
    protected void teacherDecision(int input){
        switch(input){
            case 1:
                printAllStudentNames();
                break;
            case 2:
                //printGradeMatrix
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }

    }
    protected void printAllStudentNames() {
        for (String name : Classroom.students) {
            System.out.println(name);
        }
    }
    protected void printGradeMatrix(){
        for(int i = 0; i <= Classroom.students.size(); i++){
            System.out.println(Classroom.students.get(i) + " " + Classroom.gradeMatrix.get(i));
        }
    }
    /*
    protected void addAssignment(String assignmentName, String assignmentWeight){

    }

     */
}
