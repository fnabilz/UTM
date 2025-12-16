#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

// --- Class 1: Admin ---


struct BookingRecord {
    string id;
    string date;
    string title;
    int seat_row;
    char seat_col;
    double price;
    string status;

    // Optional: Method to display the record
    void display()
    {
        cout << "ID: " << id << ", Date: " << date << ", Title: " << title
            << ", Seat: " << seat_row << seat_col << ", Price: $" << price
            << ", Status: " << status << "\n";
    }
};

// --- Class 2: Booking ---
class Booking
{
private:
    string BookingID;
    string BookingDate; // Could be a more complex Date type in a real system
    double TotalAmount;
    string PaymentStatus;

public:
    // Constructor
    Booking(std::string id, std::string date, double amount, std::string status)
        : BookingID(id), BookingDate(date), TotalAmount(amount), PaymentStatus(status) {}

    //Getters
    string getBookingID() { return BookingID; }
    string getBookingDate() { return BookingDate; }
    double getTotalAmount()  {return TotalAmount; }
    string getPaymentStatus() { return PaymentStatus; }
    //Setters
    void setBookingID(string &id) { BookingID = id; }
    void setBookingDate(string &date) { BookingDate = date; }
    void setTotalAmount(double amount) { TotalAmount = amount; }
    void setPaymentStatus(string &status) { PaymentStatus = status; }
    
    // Operation (Method)
    void displayBooking()
    {
        std::cout << "\n--- Booking Details ---\n";
        std::cout << "  ID: " << BookingID << "\n";
        std::cout << "  Date: " << BookingDate << "\n";
        std::cout << "  Amount: $" << TotalAmount << "\n";
        std::cout << "  Status: " << PaymentStatus << "\n";
    }

    // Getters for potential use by other classes
    std::string getBookingID()
    {
        return BookingID;
    }
    double getTotalAmount()
    {
        return TotalAmount;
    }
};

class Admin
{
private:
    string AdminID;
    string AdminName;
    vector<Booking> bookings;

public:
    //Constructor
    Admin(std::string adminID, std::string adminName)
        : AdminID(adminID), AdminName(adminName) {}

    // Getters
    string getAdminID() { return AdminID; }
    string getAdminName() { return AdminName; }

    // Setters
    void setAdminID(string &id) { AdminID = id; }
    void setAdminName(string &name) { AdminName = name; }

    // Operations (Methods)
    void loadFromBookingFile()
    {
        ifstream infile("BOOKING_FILE.txt");
        if (!infile.is_open()) {
            cerr << "Error: Could not open file BOOKING_FILE.txt" << endl;
            return;
        }

        string line;
        while (getline(infile, line)) {
            if (line.empty()) continue;
            
            // Create stringstream inside the loop
            stringstream ss(line);  // Remove 'std::' since we have 'using namespace std'
            BookingRecord record;
            
            // Parse the line
            if (ss >> record.id >> record.date >> record.title >> record.seat_row >> record.seat_col >> record.price >> record.status) {
                bookings.push_back(record);
            }
        }
        infile.close();
        cout << "Loaded " << bookings.size() << " bookings from file.\n";
    }


    void searchBooking(string bookingID)
    {
        int array_size;
        cout << "Admin " << AdminName << " searching for booking ID: " << bookingID << ".\n";
        bool found = false;
        int index = -1;
        int middle, left = 0, right = bookings.size() - 1;

        while ((left <= right) && (!found))
        {
            middle = (left + right) / 2;
            if (bookings[middle].getBookingID() == bookingID)
            {
                index = middle;
                found = true;
            }
            else if (bookings[middle].getBookingID() > bookingID)
            {
                right = middle - 1;
            }
            else
                left = middle + 1;
        }

        if(found){
            cout << "Booking found! : " << bookingID << endl;
        }
        else{
            cout << "Booking not found" << endl;
        }
    }

    void sortBooking(){
        cout << "Admin " << AdminName << " sorting all bookings.\n";
        // In a real system, this would contain sorting logic.

        partition(bookings, 0, bookings.size() - 1);
        quickSort(bookings, 0, bookings.size() - 1);
        
        
    }

    int partition(vector<Booking>& bookings, int low, int high){
        int index;
        int pivot = index;
        bookings[index].getBookingID();
        int i = low - 1;
            
        for (int j = low; j < high; j++){
            if(bookings[j].getBookingID() < bookings[index].getBookingID()){
                i++;
                swap(bookings[i], bookings[j]);
            }
        }
        swap(bookings[i + 1], bookings[high]);
        return i + 1;
    }

    void quickSort(vector<Booking> &bookings, int low, int high){
        if (low < high) {
            int p = partition(bookings, low, high);

            quickSort(bookings, low, p - 1);
            quickSort(bookings, p + 1, high);
        }
    }


    void listAllBooking()
    {
        cout << "\nAdmin " << AdminName << " listing all bookings (" << bookings.size() << "):\n";
        if (bookings.empty()) {
            cout << "No bookings available.\n";
            return;
        }
        for (Booking r : bookings) {
            r.displayBooking();
        }
    }
};

// --- Class 3: Customer ---
class Customer
{
private:
    string CustID;
    string CustName;
    string CustNo; // Assuming this is a phone number/contact number
    string CustEmail;

    vector<Booking> customerBookings; // To store multiple bookings
    
public:
    // Constructor
    Customer(std::string id, std::string name, std::string number, std::string email)
        : CustID(id), CustName(name), CustNo(number), CustEmail(email) {}

        
    //Getter
    string getCustID() { return CustID; }
    string getCustName() { return CustName; }
    string getCustNo() { return CustNo; }
    string getCustEmail() { return CustEmail; }

    //Setter
    void setCustID(string &id) { CustID = id; }
    void setCustName(string &name) { CustName = name; }
    void setCustNo(string &number) { CustNo = number; }
    void setCustEmail(string &email) { CustEmail = email; }

    // Operations (Methods)
    void addBooking(Booking &newBooking)
    {
        customerBookings.push_back(newBooking);
        std::cout << "SUCCESS: Customer " << CustName
                    << " added booking ID " << newBooking.getBookingID() << ".\n";
    }

    void listBookings()  {
        std::cout << "\n--- Bookings for " << CustName << " (" << CustID << ") ---\n";
        if (customerBookings.empty()) {
            std::cout << "No bookings found.\n";
            return;
        }
        for (Booking booking : customerBookings) {
            booking.displayBooking();
        }
    }

    std::string getName() {return CustName;}

    std::string getEmail() {return CustEmail;}
};

// --- Example Usage (main function) ---
int main()
{
    // 1. Create Instances
    Customer alice("C101", "Alice Johnson", "555-0001", "alice@email.com");
    Admin bob("A001", "Bob The Manager");
    Booking b1("B202301", "2023-10-27", 25.50, "Paid");

    // 2. Perform Operations
    std::cout << "--- Customer Actions ---\n";
    alice.addBooking(b1);
    b1.displayBooking();
    std::cout << "Customer name: " << alice.getName() << "\n";

    std::cout << "\n--- Admin Actions ---\n";
    bob.listAllBooking();
    bob.searchBooking("B202301"); // Example with dummy data
    bob.sortBooking();

    return 0;
}