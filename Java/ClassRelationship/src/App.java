/*
    Name: Ahmad Fikri Nabil bin Zamri
    MatricID: A24CS0035
 */

import java.util.ArrayList;

class Owner {
    String name;
    House house;

    public Owner(String ownerName) {
        this.name = ownerName;
    }

    public void setOwnership(House houseObj) {
        this.house = houseObj;
    }

    public void displayInfo() {
        System.out.println("Owner name: " + name);
        System.out.println("House owned: " + house.address);
    }

}

class House {
    String address;
    ArrayList<Room> roomList = new ArrayList<>();
    Owner ownsBy;

    public House (String addressName) {
        this.address = addressName;
        // Room diningRoom = new Room();
    }

    public void addRoom(String type) {
        Room newRoom = new Room(type);
        this.roomList.add(newRoom);
    }

    public void ownedBy(Owner ownerObj) {
        this.ownsBy = ownerObj;
    }

    public void displayInfo() {
        System.out.println("Address: " + address);
        System.out.println("Owned by: " + ownsBy.name);
        System.out.println("Room list: ");
        for (int i = 0; i < roomList.size(); i++) {
            Room currentRoom = roomList.get(i);
            System.out.println((i+1) + "- " + currentRoom.roomType);
        }
        System.out.println("");
    }

}

class Room {
    String roomType;

    public Room(String type) {
        this.roomType = type;
    }

    @Override
    public String toString() {
        return roomType;
    }
}

class Furniture {
    String location;
}


public class App {
    public static void main(String[] args) throws Exception {
        
        Owner owner1 = new Owner("Abu");
        Owner owner2 = new Owner("Saleha");

        House house1 = new House("Teratak Cantik, No 22, Indah Street");
        House house2 = new House("Teratak Indah, No 21, Cantik Road");

        house1.addRoom("Dining Room");
        house1.addRoom("Master Bedroom");

        house2.addRoom("Main Hall");
        house2.addRoom("Dining Room");
        house2.addRoom("Kitchen");
        house2.addRoom("Master Bedroom");
        house2.addRoom("Guest Bedroom");
        house2.addRoom("Bedroom #2");
        house2.addRoom("Bedroom #3");
        house2.addRoom("Bathroom");

        owner1.setOwnership(house1);
        house1.ownedBy(owner1);
        owner2.setOwnership(house2);
        house2.ownedBy(owner2);

        System.out.println("");
        owner1.displayInfo();
        house1.displayInfo();

        owner2.displayInfo();
        house2.displayInfo();

        Owner owner3 = new Owner("Nabila");
        House house3 = new House("Villa Baru");

        owner3.setOwnership(house3);
        house3.ownedBy(owner3);

        owner3.displayInfo();
        house3.displayInfo();
    }
}
