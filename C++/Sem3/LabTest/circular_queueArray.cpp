#include <iostream>
using namespace std;
#define max_queue 5

class Queue {

private:
    int front;
    int back;
    int items[max_queue];
    int count;

public:
    Queue() {
        count = 0;
        front = 0;
        back = max_queue - 1;
    }

    bool isEmpty() {
        if (count == 0) 
            return true;
        return false;
    }

    bool isFull() {
        if (count == max_queue) 
            return true;
        return false;
    }

    void enQueue(int data) {
        if (!isFull()) {
            back = (back + 1) % max_queue;
            items[back] = data;
            ++count;
        }
        else {
            cout << "Cannot insert new item. Queue is full!" << endl;
        }
    }

    void deQueue() {
        if (!isEmpty()) {
            int deletedItem = items[front];
            cout << "Deleted item: " << deletedItem << endl;
            front = (front + 1) % max_queue;
            --count;
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
       if (!isEmpty()) {
            cout << "\nArray: ";
            int tempIndex = front;
            for (int index = 0; index < count; index++) {
                cout << "[" << items[tempIndex] << "] ";
                tempIndex = (tempIndex + 1) % max_queue;
            }
            cout << endl;
       }
       else {
            cout << "Cannot display items. Queue is empty!" << endl;
       }
    }
};

int main() {

    Queue newArray;

    newArray.display();

    newArray.enQueue(10);
    newArray.enQueue(10);
    newArray.enQueue(20);
    newArray.enQueue(20);
    newArray.enQueue(20);
    newArray.enQueue(20);

    newArray.display();

    newArray.deQueue();
    newArray.deQueue();
    newArray.deQueue();

    newArray.display();

    newArray.enQueue(30);

    newArray.display();

    return 0;
}