public class TestStudent{
    
    public static void main(String[] args) {
        Student student = new Student();
        String name = args[0];
        double carryMark = Double.parseDouble(args[1]);
        double finalExam = Double.parseDouble(args[2]);
        student.setName(name);
        student.setMarks(carryMark, finalExam);
        student.printResult();

        /*Student student2 = new Student();
        student2.setName("Abdul");
        student2.setMarks(40, 24);
        student2.printResult();*/
    }
}