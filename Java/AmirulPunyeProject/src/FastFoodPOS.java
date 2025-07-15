
class Staff{
    private String staffID;
    private String staffName;

    public Staff (String staffID, String staffName){
        this.staffID = staffID;
        this.staffName = staffName;
    }

    public String getStaffID(){
        return this.staffID;
    }
}

class Customer{
    private String custName;
    private String phoneNum;
    private String address;

    public Customer (String custName, String phoneNum, String address){
        this.custName = custName;
        this.phoneNum = phoneNum;
        this.address = address;
    }

    public String custDetails(){
        return "Name: " + custName + "\nPhone: " + phoneNum + "\nAddress: " + address; 
    }
}

abstract class MenuItem{
    private int itmID;
    private String itmName;
    private double itmPrice;

    public MenuItem (int itmID, String itmName, double itmPrice){
        this.itmID = itmID;
        this.itmName = itmName;
        this.itmPrice = itmPrice;
    }

    public int getItemID(){
        return this.itmID;
    }

    public String getItemName(){
        return this.itmName;
    }

    public double getItemPrice(){
        return this.itmPrice;
    }

    public void displayMenu(){
        System.out.printf(getItemID() + "  " + getItemName() + " - RM &.2f" + getItemPrice());
    }
}

class Food extends MenuItem{  
    private String foodType;

    public Food(int itmID, String itmName, String foodType, double itmPrice){
        super(itmID, itmName, itmPrice);
        this.foodType = foodType;
    }

    public String getFoodType(){
        return this.foodType;
    }

    // Output  
    // 
    public void displayMenu(){
        super.displayMenu();
        System.out.print();
    }
}

//class Drink
class Drink extends MenuItem{
    private String drinkType;

    public Drink(int itmID, String itmName, String drinkType, double itmPrice){
        super(itmID, itmName, itmPrice);
        this.drinkType = drinkType;
    }

    public String getDrinkType(){
        return this.drinkType;
    }
}

//class SideDish 
class SideDish extends MenuItem{

    public SideDish(int itmID, String itmName, double itmPrice){
        super(itmID, itmName, itmPrice);
    }
}

//class Combo

//class Order
class Order {
    private MenuItem menuItm;
    private int quantity;
    

    public 
}

//class OrderManager

public static void main(String [] args) {

}