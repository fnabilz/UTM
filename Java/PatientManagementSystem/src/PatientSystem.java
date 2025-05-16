import java.util.ArrayList;

public class PatientSystem {
    public static void main(String[] args) {

        /*
            Define an ArrayList to dynamically store objects of Patient
        */
        ArrayList<Patient> patientList = new ArrayList<>();
        
        /*
            Initialize the Patient and Address objects based on the information given in the Table
            Then, add the Patient objects into the ArrayList 
        */
        System.out.println("");
        Address address1 = new Address("Jalan Pahlawan", "Skudai", 81300, "Johor");
        Patient patient1 = new Patient("P0001", "Akmal", "Adnan", "Male", address1, 180, 82);

        Address address2 = new Address("Jalan Flora", "Skudai", 81300, "Johor");
        Patient patient2 = new Patient("P0002", "Syafiq", "Yusof", "Male", address2, 186, 80);
        
        Address address3 = new Address("Jalan Bakti", "Skudai", 81300, "Johor");
        Patient patient3 = new Patient("P0003", "Mei Ling", "Koh", "Female", address3, 168, 45);

        patientList.add(patient1);
        patientList.add(patient2);
        patientList.add(patient3);

         /*
            Invoke the displayRecord function to display the list of patients
        */
        displayRecord(patientList);
        
        /*
            Remove the 2nd patient in the list
        */
        patientList.remove(1);

         /*
            Invoke the displayRecord function again to display the list of patients
        */
        displayRecord(patientList);

        System.out.println("");
    }



    /*
        This function display the record of the patient. This function is INCOMPLETE.
        Please complete the function to display the output as shown in Figure 2.
    */
    public static void displayRecord(ArrayList <Patient> pL) {

        System.out.println("\nPatient Record Management System");
        System.out.println("================================");
        System.out.printf("%-5s%-10s%-25s%-10s%-50s%-10s%-10s%-10s\n", "No", "PatientID", "Name", "Gender", "Address", "Height", "Weight", "BMI");
        System.out.printf("%-5s%-10s%-25s%-10s%-50s%-10s%-10s%-10s\n", "--", "---------", "----", "------", "-------", "------", "------", "---");


        //To display the list of patients based on output given in Figure 2
        for(int i = 0; i < pL.size(); i++) {
            System.out.printf("%-5d%-10s%-25s%-10s%-50s%-10d%-10d%-10.2f\n", (i+1), 
                                pL.get(i).getPatientID(), 
                                pL.get(i).getFullName(), 
                                pL.get(i).getGender(), 
                                pL.get(i).getAddress().getAddress(), 
                                pL.get(i).getHeight(), 
                                pL.get(i).getWeight(), 
                                pL.get(i).getBMI()
                              );
        }

        System.out.println("\n-------------------");
        System.out.println("Total Patients: "+ pL.size());
    }
}