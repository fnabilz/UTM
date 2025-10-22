#include <iostream> 
#include <string> 
using namespace std; 
 
// Define the Device class 
class Device { 
private: 
    string name; 
    float price; 
    int quantity; 
 
public: 
    // Constructor to initialize the attributes 
    Device(string n, float p, int q) { 
        name = n; 
        price = p;
        quantity = q; 
    }

    // Method to calculate the total value of the device 
    float getValue() const { 
        return price * quantity;  
    } 
 
    // Method to display device information 
    void display() const { 
        cout << "Device: " << name  
             << ", Price: " << price  
             << ", Quantity: " << quantity 
             << endl; 
    } 
 
    // Method to update the details of the device 
    void updateDetails(string n, float p, int q) { 
        name = n; 
        price = p; 
        quantity = q; 
    } 
}; 
 
// Function to calculate the total value of the inventory 
float calculateTotalValue(Device device[], int size) { 
    float total = 0; 
    for (int i = 0; i < size; ++i) { 
        total += device[i].getValue(); 
    } 
    return total; 
} 
 
// Function to update a device using a pointer 
void updateDevice(Device *device, string n, float p, int q) { 
    (*device).updateDetails(n, p, q); 
}

int main() { 
    // Create an array of Device objects 
    Device devices[3] = { 
        Device("Laptop", 1500, 10), 
        Device("Phone", 800, 15), 
        Device("Tablet", 600, 8) 
    }; 
 
    // Display all devices 
    cout << "Initial Inventory:\n"; 
    for (int i = 0; i < 3; ++i) { 
        devices[i].display(); // Fill in the blank to call the display method 
    } 
 
    // Calculate and display the total inventory value 
    float totalValue = calculateTotalValue(devices, 3); // Fill in the blank with arguments 
    cout << "\nTotal Inventory Value: " << totalValue << endl; 
 
    // Update the first device 
    updateDevice(&devices[0], "Gaming Laptop", 2000, 5); 
 
    // Display all devices again after the update 
    cout << "\nAfter updating the first device:\n"; 
    for (int i = 0; i < 3; ++i) { 
        devices[i].display(); // Fill in the blank to call the display method 
    } 
 
    return 0; 
}