import java.util.ArrayList;

public class Medic {

    public static void main(String[] args) { 
        Hospital hosp = new Hospital(); 
        hosp.setHospitalName("HSA");      

        Doctors doc1 = new Doctors(1980,12,1); 
        doc1.setDoctorName("Dr.Abu Ali");   
        Doctors doc2 = new Doctors(1981,1,1); 
        doc2.setDoctorName("Dr.Kim Lee");      
        Doctors doc3 = new Doctors(1985,12,12); 
        doc3.setDoctorName("Dr.Nadela A/P Ram");       

        ArrayList<Doctors> doctorList = new ArrayList<>();     
        doctorList.add(doc1);   
        doctorList.add(doc2);   
        doctorList.add(doc3);   


        hosp.setDoctor(doctorList);  

        System.out.println("");
        System.out.println("Size of list: " + doctorList.size());  
        System.out.println(hosp.getDoctors() +" are Doctors of"+  hosp.getHospName());  


        doctorList.remove(1);   
        System.out.println("Display list:" + doctorList);   

        Doctors newDoc1= new Doctors(1984,5,8); 
        newDoc1.setDoctorName("Dr.Badariah");   
        doctorList.add(0,newDoc1);   
        Doctors newDoc2= new Doctors(1982,22,5); 
        newDoc2.setDoctorName("Dr.Zang Yu");  
        doctorList.add(3,newDoc2);      

        System.out.println("Display list: "+ doctorList);    

        System.out.println("Doctor list and their birthday: "); 
        System.out.println("First doctor: " +  doctorList.get(1) + " " + doctorList.get(1).getBday());    
        System.out.println("Second doctor: " + doctorList.get(2) + " " + doctorList.get(2).getBday());      
        System.out.println("Third doctor : " + doctorList.get(0) + " " + doctorList.get(0).getBday());      
        System.out.println("Forth doctor: " + doctorList.get(3) + " " + doctorList.get(3).getBday());   
        System.out.println();
    }

} // Medic

class Hospital {
    private String hospitalName;
    ArrayList<Doctors> doctors = new ArrayList<>();

    public Hospital() {}

    public String getHospName() {
        return hospitalName;
    }

    public void setHospitalName(String hospName) {
        hospitalName = hospName;
    }

    public ArrayList<Doctors> getDoctors() {
        return doctors;
    }

    public void setDoctor(ArrayList<Doctors> doc) {
        doctors = doc;
    }

} // Hospital

class Doctors {
    private String doctorName;

    private Birthday bday;   

    public Doctors(int y, int m, int d){ 
        this.bday = new Birthday(y, m, d); 
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String docName) {
        doctorName = docName;
    }

    @Override
    public String toString() {
        return doctorName;
    }

    public Birthday getBday() {
        return this.bday;
    }
} // Doctors

class Birthday {
    int year, month, day;

    public Birthday(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s", year, month, day);
    }
}// Birthday
