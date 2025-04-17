public class Student{

    String name;
    double carryMark;
    double finalExam;

    public void setName(String name){
        this.name = name;
    }

    public void setMarks(double carryMark, double finalExam){
        this.carryMark = carryMark;
        this.finalExam = finalExam;
    }

    public double getTotalMark(double carryMark, double finalExam){
        double totalMark = carryMark + finalExam;
        return totalMark;
    }

    public String getGrade(double totalMark){
        String grade = null;
        if (totalMark >= 50){
            grade = "PASS";
        }
        else{
            grade = "FAIL";
        }
        return grade;
    }

    public void printResult(){
        double totalMark = getTotalMark(carryMark, finalExam);
        System.out.println("Test Student Class");
        System.out.println("Name: " + name);
        System.out.println("Total Mark: " + totalMark);
        System.out.println("Grade: " + getGrade(totalMark) + "\n");
    }
}