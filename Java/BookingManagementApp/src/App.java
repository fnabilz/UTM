/*
 * Name: AHMAD FIKRI NABIL BIN ZAMRI
 * Matric ID: A24CS0035
 * 
 */

import java.util.ArrayList;
import java.util.Scanner;

class Person {
  String name;
  String contactNum;
  Room roomAssigned;

  public Person(String name, String contactNum) {
    this.name = name;
    this.contactNum = contactNum;
  }

  public void assignRoom(Room newRoom) {
    this.roomAssigned = newRoom;
    System.out.println("Room assigned!");
  }

  @Override
  public String toString() {
    return "[ Name : " + name + " Contact Number : " + contactNum + " ]";
  }

  public void viewAssignedRoom() {
    System.out.println("--- Person In-Charge ----");
    System.out.println("Name :" + this.name);
    System.out.println("...room ....");
    this.roomAssigned.displayRoomDetails();
  }

}

class Room {
  String roomName;
  int capacity;
  ArrayList<Equipment> equipmentList = new ArrayList<>();
  ArrayList<Booking> bookings = new ArrayList<>();

  public Room(String roomName, int capacity) {
    this.roomName = roomName;
    this.capacity = capacity;
  }

  public void addEquipment(Equipment tool) {
    equipmentList.add(tool);
  }

  public void displayRoomDetails() {
    System.out.println("Room Name :" + this.roomName);
    System.out.println("Capacity :" + this.capacity);
  }

   public void createBooking(Lecturer lecturer, String dateTime) {
      this.bookings.add(new Booking(lecturer, dateTime, "ACTIVE"));
      System.out.println("Booking created.");
   }

   public void cancelBooking(Lecturer lecturer, String dateTime) {
      this.bookings.add(new Booking(lecturer, dateTime, "CANCELLED"));
      System.out.println("Booking cancellation recorded.");
   }

   public void listBookings() {
      if (this.bookings.isEmpty()) {
         System.out.println("No bookings for room " + this.roomName);
      } else {
         System.out.println("Bookings for room " + this.roomName + ":");
         for (int i = 0; i < bookings.size(); i++) {
          System.out.println(bookings.get(i).toString());
         }
      }

   }

}

class ComputerLab extends Room {
  int numofComputer;

  public ComputerLab(String roomName, int capacity, int numofComputer) {
    super(roomName, capacity);
    this.numofComputer = numofComputer;
  }
}

class LectureHall extends Room {
  String seatingLayout;

  public LectureHall(String roomName, int capacity, String seatingLayout) {
    super(roomName, capacity);
    this.seatingLayout = seatingLayout;
  }


}

class Equipment {
  String name;
  String type;

  public Equipment(String name, String type) {
    this.name = name;
    this.type = type;
  }

  @Override
  public String toString() {
    return "[ Name : " + name + " Type : " + type + " ]";
  }

  public void displayEquipmentDetails() {
    System.out.println("Equipment Name: " + name);
    System.out.println("Equipment Type: " + type);
  }

}
class Building {
  String name;
  ArrayList<Room> rooms = new ArrayList<>();

  public Building(String name) {
    this.name = name;
  }

  public void addComputerLab(String roomName, int capacity, int numofComputer) {
    ComputerLab newLab = new ComputerLab(roomName, capacity, numofComputer);
    rooms.add(newLab);
  }

  public void addLectureHall(String roomName, int capacity, String seatingLayout) {
    LectureHall newHall = new LectureHall(roomName, capacity, seatingLayout);
    rooms.add(newHall);
  }

  public void displayBuildingDetails() {
    System.out.println("Building name : " + this.name);
      if (this.rooms.size() == 0) {
         System.out.println("No room in this building...");
      } else {
         System.out.println("List of rooms :");

         for(int i = 0; i < this.rooms.size(); ++i) {
            System.out.printf("\nRoom (%d) : Name : %s and Capacity : %d\n", i, ((Room)this.rooms.get(i)).roomName, ((Room)this.rooms.get(i)).capacity);
         }
      }
  }

}

class Lecturer extends Person {
  String dept;
  
  public Lecturer(String name, String contactNum, String dept) {
    super(name, contactNum);
    this.dept = dept;
  }

  @Override
  public String toString() {
    return "[ Name : " + super.name + " Contact Number : " + super.contactNum + " ]";
  }
}

class Booking {
  Lecturer lecturer;
  String dateTime;
  String status;

  public Booking(Lecturer lecturer, String dateTime, String status) {
    this.lecturer = lecturer;
    this.dateTime = dateTime;
    this.status = status;
  }

  @Override
  public String toString() {
    if (this.status.equals("ACTIVE")) {
      return "ACTIVE BOOKING - Lecturer: " + this.lecturer.name + ", DateTime: " + this.dateTime;
    }
    return "CANCELLED BOOKING - Lecturer: " + this.lecturer.name + ", DateTime: " + this.dateTime;
  }

}

public class App {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      ArrayList<Person> personList = new ArrayList<>();
      ArrayList<Lecturer> lecturerList = new ArrayList<>();

      Person person1 = new Person("Ahmad Zolkafli", "017-7018088");
      Person person2 = new Person("Samad Abu", "013-9705090");
      personList.add(person1);
      personList.add(person2);

      Lecturer lecturer1 = new Lecturer("Ali Lecturer", "011-2233445", "SE Dept");
      Lecturer lecturer2 = new Lecturer("Fatimah Lecturer", "012-9988776", "Com Network Dept");
      lecturerList.add(lecturer1);
      lecturerList.add(lecturer2);

      Equipment equi1 = new Equipment("Computer for teacher in MPK1", "Electronics");
      Equipment equi2 = new Equipment("Projector in Dewan Kejora", "Visual");
      Equipment equi3 = new Equipment("Dewan Kejora PA Audio System", "Audio Equipment");

      Building fcBuilding = new Building("N28a Faculty Computing");
      fcBuilding.addComputerLab("MPK01", 50, 25);
      fcBuilding.addLectureHall("Dewan Kejora", 250, "U-shape");

      person1.assignRoom((Room)fcBuilding.rooms.get(0));
      person2.assignRoom((Room)fcBuilding.rooms.get(1));

      ((Room)fcBuilding.rooms.get(0)).addEquipment(equi1);
      ((Room)fcBuilding.rooms.get(1)).addEquipment(equi2);
      ((Room)fcBuilding.rooms.get(1)).addEquipment(equi3);

      int choice;
      do {
        System.out.println("\n---- FACULTY BUILDING MANAGEMENT MENU ----");
        System.out.println("1. View all persons");
        System.out.println("2. View all equipment");
        System.out.println("3. View building & rooms");
        System.out.println("4. Assign person to room");
        System.out.println("5. View person's assigned room");
        System.out.println("6. Add equipment to room");
        System.out.println("7. Make a room booking");
        System.out.println("8. Cancel a room booking");
        System.out.println("9. View room bookings");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");

        choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                System.out.println("");
                for (int i = 0; i < personList.size(); ++i) {
                    System.out.println(personList.get(i).toString());
                }

                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;
            case 2:
                System.out.println("");
                for (Room room : fcBuilding.rooms) {
                    
                    for (Equipment equi : room.equipmentList) {
                        equi.displayEquipmentDetails();
                    }

                }

                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;

            case 3:
                System.out.println("");
                fcBuilding.displayBuildingDetails();

                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;

            case 4:
                System.out.println("");
                System.out.println("Assign person...");

                for(int i = 0; i < personList.size(); ++i) {
                    System.out.println("" + i + ": " + personList.get(i).name);
                }

                int personIndex = scan.nextInt();
                scan.nextLine();
                fcBuilding.displayBuildingDetails();
                System.out.print("Select Room: ");
                int roomChose = scan.nextInt();
                scan.nextLine();
                personList.get(personIndex).assignRoom(fcBuilding.rooms.get(roomChose));

                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;

            case 5:
                System.out.println("");
                for (int i = 0; i < personList.size(); ++i) {
                personList.get(i).viewAssignedRoom();
                }

                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;

            case 6:
                System.out.println("");
                fcBuilding.displayBuildingDetails();
                System.out.print("Select Room: ");
                int roomIndex = scan.nextInt();
                scan.nextLine();

                System.out.print("Enter Equipment Name: ");
                String equiName = scan.nextLine();
                System.out.print("Enter Equipment Type: ");
                String equiType = scan.nextLine();

                Equipment newEqui = new Equipment(equiName, equiType);
                fcBuilding.rooms.get(roomIndex).addEquipment(newEqui);

                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;

            case 7:
                System.out.println("");
                fcBuilding.displayBuildingDetails();
                System.out.print("Select Room: ");
                int roomChosen = scan.nextInt();
                scan.nextLine();

                for (int i = 0; i < lecturerList.size(); i++) {
                    System.out.println("" + i + ": " + lecturerList.get(i).name);
                }

                System.out.print("Select Lecturer: ");
                int lecturerIndex = scan.nextInt();
                scan.nextLine();

                System.out.print("Enter DateTime: ");
                String dateTime = scan.nextLine();
                
                fcBuilding.rooms.get(roomChosen).createBooking(lecturerList.get(lecturerIndex), dateTime);
                
                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;
            case 8:
                System.out.println("");
                fcBuilding.displayBuildingDetails();
                System.out.print("Select Room: ");
                int bilik = scan.nextInt();
                scan.nextLine();

                 for (int i = 0; i < lecturerList.size(); i++) {
                    System.out.println("" + i + ": " + lecturerList.get(i).name);
                }

                 System.out.print("Select Lecturer: ");
                int pensyarah = scan.nextInt();
                scan.nextLine();


                System.out.print("Enter DateTime to cancel: ");
                String tarikh = scan.nextLine();

                fcBuilding.rooms.get(bilik).cancelBooking(lecturerList.get(pensyarah), tarikh);

                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;
            case 9:
                System.out.println("");
                fcBuilding.displayBuildingDetails();
                System.out.print("Select Room: ");
                int room1 = scan.nextInt();
                scan.nextLine();
                fcBuilding.rooms.get(room1).listBookings();

                System.out.println("Press any key to continue...");
                scan.nextLine();
                break;

            case 10:
                System.out.println("");
                System.out.println("Exiting...");

                break;

            default:
                System.out.println("");
                System.out.println("Invalid choice.");
                System.out.println("Press any key to continue...");
                scan.nextLine();

        }
      } while(choice != 10);

      scan.close();
   }
}