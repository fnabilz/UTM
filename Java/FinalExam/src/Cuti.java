class Vacation { 
  private String destination; 
  int duration; 
 
  public Vacation() { 
    System.out.println("Welcome To"); 
  } 
 
  public Vacation(String destination, int duration ) { 
    this.destination = destination; 
    this.duration=duration; 
    System.out.println("Enjoy your trip"); 
  } 
} 
 
class Beach extends Vacation { 
  private String travelAirline; 
 
  public Beach() { 
    this("AirAsia"); 
    System.out.println("Have a wonderful trip"); 
  } 
 
  public Beach(String travelAirline, String destination) { 
    this(travelAirline); 
    System.out.println(destination); 
  } 
 
  public Beach(String travelAirline) { 
    this.travelAirline = travelAirline; 
    System.out.println(travelAirline); 
  } 
} 
 
public class Cuti { 
  public static void main(String[] args) { 
    Beach myVacation = new Beach("MAS", "Maldives"); 
  } 
}