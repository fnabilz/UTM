// BuildingManagementAppAns.java
// SKILL BASED TEST - Question 2
// SCSE1224 2024/2025-2
// Name: ???
// Matric No.: ???

import java.util.ArrayList;

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

// Main class to run the program
public class BuildingManagementApp {
  public static void main(String[] args) {
    System.out.println("---- FACULTY BUILDING MANAGEMENT APP --------");
    // Checkpoint #1
    System.out.println("\nCheckpoint #1");
    // CREATE 2 PERSON
    Person person1 = new Person("Ahmad Zolkafli", "017-7018088");
    Person person2 = new Person("Samad Abu", "013-9705090");
    System.out.println("using toString()");
    System.out.println(person1.toString());
    System.out.println(person2.toString());

    // Checkpoint #2
    System.out.println("\nCheckpoint #2");
    // CREATE 3 EQUIPMENTS
    Equipment computer1 = new Equipment("Computer for teacher in MPK1",
                                       "Electronics");
    Equipment projector = new Equipment("Projector in Dewan Kejora",
                                        "Visual");
    Equipment paSystem = new Equipment("Dewan Kejora PA Audio System",
                                       "Audio Equipment");
    System.out.println("using toString()");
    System.out.println(projector.toString());
    System.out.println(computer1.toString());
    System.out.println(paSystem.toString());
    System.out.println("using displayEquipmentDetails()");
    computer1.displayEquipmentDetails();
    projector.displayEquipmentDetails();
    paSystem.displayEquipmentDetails();

    // Checkpoint #3
    System.out.println("\nCheckpoint #3");
    // CREATE A BUILDING (N28a - Faculty Computing)
    Building fcBuilding = new Building("N28a Faculty Computing");
    System.out.println(fcBuilding.toString());
    // Display Building Details
    fcBuilding.displayBuildingDetails();//Print N28a with empty room

    // ADD 2 ROOMS: MPK1 & Dewan Kejora to fc building-(composition)
    fcBuilding.addComputerLab("MPK01", 50, 25);
    fcBuilding.addLectureHall("Dewan Kejora", 250, "U-shape");
    fcBuilding.displayBuildingDetails();

    // Checkpoint #4
    System.out.println("\nCheckpoint #4");
    // ASSIGN PERSON-IN-CHARGE TO ROOM (association)
    // Ahmad Zolkafli is in-charge of MPK1
    person1.assignRoom(fcBuilding.rooms.get(0));
    // Samad Abu is in-charge of Dewan Kejora
    person2.assignRoom(fcBuilding.rooms.get(1));
    person1.viewAssignedRoom();
    person2.viewAssignedRoom();

    // Checkpoint #5
    System.out.println("\nCheckpoint #5");
    // ADD EQUIPMENT TO ROOM (aggregation)
    // Add equipment to MPK1
    fcBuilding.rooms.get(0).addEquipment(computer1);
    // Add 2 equipments to Dewan Kejora
    fcBuilding.rooms.get(1).addEquipment(projector);
    fcBuilding.rooms.get(1).addEquipment(paSystem);
  }
}