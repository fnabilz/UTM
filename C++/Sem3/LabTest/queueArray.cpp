#include <iostream>
using namespace std;
#define MAX_QUEUE 5

class Queue {
private:
    int front;
    int back;
    int items[MAX_QUEUE];

public:
    Queue() {
        front = 0;
        back = -1;
    }


    bool isEmpty() {
        if (back < front) {
            return true;
        }
        return false;
    }

    bool isFull() {
        if (back == MAX_QUEUE - 1) {
            return true;
        }
        return false;
    }

    void enQueue(int data) {
        if (!isFull()) {
            back++;
            items[back] = data;
        }
        else {
            cout << "Cannot insert new item. Queue is full!" << endl;
        }
    }

    void deQueue() {
        if (!isEmpty()) {
            int deletedData = items[front];
            cout << "Deleted item: " << deletedData << endl;
            front++;
        }
        else {
            cout << "Cannot delete item. Queue is empty!" << endl;
        }
    }

    int getFront() {
        return items[front];
    }

    int getRear() {
        return items[back];
    }

    void display() {
        cout << "\nArray: ";
        for (int index = front; index < back + 1; index++) {
            cout << "[" << items[index] << "] ";
        }
        cout << endl;
    }
};

int main() {

    Queue newArray;
    newArray.enQueue(10);
    newArray.enQueue(20);
    newArray.enQueue(30);
    newArray.enQueue(40);
    newArray.enQueue(50);
    //newArray.enQueue(60);

    newArray.display();

    newArray.deQueue();
    newArray.deQueue();

    newArray.display();

    newArray.deQueue();
    newArray.deQueue();
    newArray.deQueue();
    newArray.deQueue();

    newArray.enQueue(50);

    
    return 0;
}
