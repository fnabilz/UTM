#include <iostream>
using namespace std;

// Define a simple class called "Car"
class Car {
private:
    string model;
    int year;

public:
    // Constructor
    Car(string model, int year) : model(model), year(year) {}

    // Method to display car information
    void displayInfo() const {
        cout << "Model: " << model << ", Year: " << year << endl;
    }

    // Method to set a new year
    void setYear(int newYear) {
        year = newYear;
    }
};

// Function that takes a Car object by value
void showCarByValue(Car car) {
    cout << "Pass by Value:" << endl;
    car.displayInfo();
    car.setYear(2022);
    car.displayInfo();
}

void showCarByReference(Car &car) {
    cout << "Pass by Reference" << endl;
    car.displayInfo();
    car.setYear(2023);
    car.displayInfo();
}

void showCarByConstReference(const Car &car) {
    cout << "Pass by Const Reference: " << endl;
    car.displayInfo();
}


int main() {
    Car car1("Toyota", 2020);

    showCarByValue(car1);
    cout << "Original after pass by value: ";
    car1.displayInfo();

    showCarByReference(car1);
    cout << "Original after pass by reference: ";
    car1.displayInfo();

    showCarByConstReference(car1);
    cout << "Original after pass by const reference: ";
    car1.displayInfo();

    return 0;
}