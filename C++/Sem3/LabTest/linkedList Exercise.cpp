#include <iostream>
#include <string>
using namespace std;

struct Ticket {
    int ticketNo;
    string passenger;
    double fare;
    Ticket* prev;
    Ticket* next;
};

class TicketSystem {
private:
    Ticket* front;
    Ticket* back;

public:
    TicketSystem() : front(nullptr), back(nullptr) {}
    ~TicketSystem() {
        Ticket* deleteTicket = front;
        while (deleteTicket) {
            front = front->next;
            delete (deleteTicket);
            deleteTicket = front;
        }
    }; // Task 1

    void addTicket(int ticketNo, string passenger, double fare) {
        Ticket* prevTicket = nullptr;
        Ticket* currentTicket = front;
        while (currentTicket) {
            prevTicket = currentTicket;
            currentTicket = currentTicket->next;
        }

        Ticket* newTicket = new Ticket;
        newTicket->ticketNo = ticketNo;
        newTicket->passenger = passenger;
        newTicket->fare = fare;

        if (front == nullptr) {
            newTicket->prev = nullptr;
            newTicket->next = nullptr;
            front = back = newTicket;
        }
        else {
            newTicket->prev = prevTicket;
            newTicket->next = prevTicket->next;
            prevTicket->next = newTicket;
            back = newTicket;
        }

    }

    void showTicketsFromFront() {
        Ticket* currentTicket = front;
        while (currentTicket) {
            cout << currentTicket->ticketNo << " "
                    << currentTicket->passenger << " "
                    << currentTicket->fare << endl;
            currentTicket = currentTicket->next;
        }
    }   // Task 2

    void showTicketsFromBack() {
        Ticket* currentTicket = back;
        while (currentTicket) {
            cout << currentTicket->ticketNo << " "
                    << currentTicket->passenger << " "
                    << currentTicket->fare << endl;
            currentTicket = currentTicket->prev;
        }
    }    // Task 3

    Ticket* findTicket(int ticketNo) {
        Ticket* currentTicket = front;
        while (currentTicket && currentTicket->ticketNo != ticketNo) {
            currentTicket = currentTicket->next;
        }
        return currentTicket;
    }   // Task 4
};

/* 
void TicketSystem::addTicket(int ticketNo, string passenger, double fare) {
void TicketSystem::showTicketsFromFront() {}
void TicketSystem::showTicketsFromBack() {}
Ticket* TicketSystem::findTicket(int ticketNo) {}
*/

int main() {
    TicketSystem ts;
    ts.addTicket(501, "Abu", 25.5);
    ts.addTicket(502, "Fatimah", 30.0);
    ts.addTicket(503, "Ali", 28.0);

    cout << "Tickets from front:\n";
    ts.showTicketsFromFront();

    cout << "\nTickets from back:\n";
    ts.showTicketsFromBack();

    cout << "\nSearching for ticket 502:\n";
    Ticket* result = ts.findTicket(502);
    if(result) cout << "Found: " << result->passenger << endl;
    else cout << "Not found.\n";

    return 0;
}
