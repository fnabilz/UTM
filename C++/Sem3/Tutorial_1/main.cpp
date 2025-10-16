#include <iostream>
using namespace std;

// Define a classs "AboutMe"
class AboutMe {
private:
    // Attributes
    string name;
    int age;
    string matricNumber;
    string address;

public:
    /// Constructor
    AboutMe(string name, int age, string matricNumber, string address) {
        this->name = name;
        this->age = age;
        this->matricNumber = matricNumber;
        this->address = address;
    }

    // Method to display information
    void displayInfo() {
        cout << "Name: " << name << "\n"
             << "Age: " << age << "\n"
             << "Matric Number: " << matricNumber << "\n" 
             << "Address: " << address << endl;
    }


};


int main() {
    // Create an object of the AboutMe class
    AboutMe person1("Ahmad Fikri Nabil", 20, "A24CS0035", "Kajang, Selangor");

    // Call the method to display the information
    person1.displayInfo();

    return 0;
}