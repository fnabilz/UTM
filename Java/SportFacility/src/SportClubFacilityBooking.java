// SportClubFacilityBooking.java 
// TEST 2 - Question 2 
// SECJ2154 - 2022/2023-2 
// Name: AHMAD FIKRI NABIL BIN ZAMRI
// Matric No.: A24CS0035
 
import java.util.ArrayList; 
 
class Person { 
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + "]";
    }
} 
 
class Address { 
    private String streetName, postCode;

    public Address(String streetName, String postCode) {
        this.streetName = streetName;
        this.postCode = postCode;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public String getPostcode() {
        return this.postCode;
    }
} 
 
class ClubMember extends Person { 
    private ArrayList<Booking> bookings = new ArrayList<>();
    private Address address;

    public ClubMember(String name, Address address) {
        super(name);
        this.address = address;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    
    public void displayBookings() {
        if (bookings.size() == 0) {
            System.out.println("No booking made by " + super.getName());
        }
        else {
            System.out.println("Booking for member: " + super.getName());
            for (int i = 0; i < bookings.size(); i++) {
                bookings.get(i).displayBookingDetails();
            }
        }
    }

    public void displayAddress() {
        System.out.println("Address: " + address.getStreetName() + ", " + address.getPostcode());
    }
} 

class ClubStaff extends Person { 
    private ArrayList<Booking> bookings = new ArrayList<>();

    public ClubStaff(String name) {
        super(name);
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void displayBookings() {
        if (bookings.size() == 0) {
            System.out.println("No booking made by " + super.getName());
        }
        else {
            System.out.println("Booking for staff: ");
            for (int i = 0; i < bookings.size(); i++) {
                bookings.get(i).displayBookingDetails();
            }
        }
    }
} 
 

 
class SportClubFacility { 
    private String name, location;

    public SportClubFacility(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public String getLocation() {
        return this.location;
    }

    @Override
    public String toString() {
        return "SportClubFacility [name=" + this.name + ", location=" + this.location + "]";
    }
} 
 
class Booking { 
    private SportClubFacility facility;
    private Person bookedBy;
    private String bookedDay;

    public Booking(SportClubFacility facility, Person bookedBy, String bookedDay) {
        this.facility = facility;
        this.bookedBy = bookedBy;
        this.bookedDay = bookedDay;
    }

    public SportClubFacility getFacility() {
        return this.facility;
    }

    public Person getBookedBy() {
        return this.bookedBy;
    }

    public String getBookedDay() {
        return this.bookedDay;
    }

    public void displayBookingDetails() {
        System.out.println("Booking Details: ");
        System.out.println("Facility: " + this.facility.getName());
        System.out.println("Booked By: " + this.bookedBy.getName());
        System.out.println("Booked Day: " + this.bookedDay + "\n");
    }
} 
 
public class SportClubFacilityBooking { 
    public static void main(String[] args) { 
        System.out.println("\n\nLab Test - SportClub Facility Booking System\n"); 
    
        // checkpoint #1 - Create 2 sportclub facilities 
        System.out.println("Checkpoint #1"); 
        SportClubFacility facility1 = new SportClubFacility("Futsal Court","Taman U Sport Centre"); 
        SportClubFacility facility2 = new SportClubFacility("Swimming Pool","Taman Tun Aquatic Center"); 
        System.out.println(facility1.toString()); 
        System.out.println(facility2.toString()); 
    
        // checkpoint #2 - Create 1 club member 
        System.out.println("\nCheckpoint #2"); 
        Address clubmemberAddress1 = new Address("No 45 Kolej Tun Dr Ismail","81300"); 
        ClubMember clubMember1 = new ClubMember("Karim Marwari", clubmemberAddress1); 
        System.out.println(clubMember1.toString()); 
        clubMember1.displayAddress(); 
        clubMember1.displayBookings(); 
    
        // checkpoint #3 - Create 1 club staff 
        System.out.println("\nCheckpoint #3"); 
        ClubStaff clubStaff1 = new ClubStaff("Famdari Akhazi"); 
        System.out.println(clubStaff1.toString()); 
        clubStaff1.displayBookings(); 
    
        // checkpoint #4 - Create 2 bookings 
        System.out.println("\nCheckpoint #4"); 
        Booking booking1 = new Booking(facility1, clubMember1,"Sunday: 2023-06-11"); 
        Booking booking2 = new Booking(facility2, clubStaff1,"Thursday: 2023-06-15"); 
        Booking booking3 = new Booking(facility1, clubStaff1,"Friday: 2023-06-16"); 
        booking1.displayBookingDetails(); 
        booking2.displayBookingDetails(); 
        booking3.displayBookingDetails(); 

        // checkpoint #5 - assign and display bookings by  
        // club members and club staff 
        System.out.println("\nCheckpoint #5"); 
        clubMember1.addBooking(booking1); 
        clubStaff1.addBooking(booking2); 
        clubStaff1.addBooking(booking3); 
        clubMember1.displayBookings(); 
        clubStaff1.displayBookings(); 
    } 
}