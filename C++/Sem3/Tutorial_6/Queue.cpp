#include <iostream>
using namespace std;
const int SIZE = 5;

class LinearQueue{
private:
    int data[SIZE] = {0};
    int front;
    int back;
public:
    LinearQueue()  {front = 0; back = -1;}

    bool isEmpty() {return back < front;}

    bool isFull() {return back == SIZE - 1;}

    void enqueue(int item) {
        if (isFull()) {
            cout << "Cannot insert data. Linear queue is full!" << endl;
        }
        else {
            back++;
            data[back] = item;
        }
    }

    void dequeue() {
        if (isEmpty()) {
            cout << "Cannot remove data. Linear queue is empty!" << endl;
        }
        else {
            int deletedItem  = data[front];
            cout << "Dequeued: " << deletedItem << endl;
            data[front] = 0;
            front++;
        }
    }

    void print() {
        if (isEmpty()) {
            cout << "\nLinear Queue is Empty!" << endl;
        }
        else {
            cout << "\nLinear Queue Data:";
            for (int index = 0; index < SIZE; index++) {
                if (data[index] > 0)
                    cout << " " << data[index];
            }
            cout << endl;
        }
    }
};

class CircularQueue{
private:
    int data[SIZE] = {0};
    int front;
    int back;
    int count;
public:
    CircularQueue()  {front = 0; back = SIZE - 1; count = 0;}

    bool isEmpty() {return count == 0;}

    bool isFull() {return count == SIZE;}

    void enqueue(int item) {
        if (isFull()) {
            cout << "Cannot insert data. Circular queue is full!" << endl;
        }
        else {
            back = (back + 1) % SIZE;
            data[back] = item;
            count++;
        }
    }

    void dequeue() {
        if (isEmpty()) {
            cout << "Cannot remove data. Circular queue is empty!" << endl;
        }
        else {
            int deletedItem  = data[front];
            cout << "Dequeued: " << deletedItem << endl;
            data[front] = 0;
            front = (front + 1) % SIZE;
            count--;
        }
    }

    void print() {
        if (isEmpty()) {
            cout << "\nCircular Queue is Empty!" << endl;
        }
        else {
            cout << "\nCircular Queue Data:";
            for (int index = 0; index < SIZE; index++) {
                if (data[index] > 0)
                    cout << " " << data[index];
            }
            cout << endl;
        }
    }
};

int main(){
    LinearQueue lq;
    lq.enqueue(5);
    lq.enqueue(15);
    lq.print();
    lq.dequeue();
    lq.print();
    lq.dequeue();
    lq.print();
    lq.dequeue();
    lq.print();

    
    CircularQueue cq;
    cq.enqueue(1);
    cq.enqueue(2);
    cq.enqueue(3);
    cq.enqueue(4);
    cq.enqueue(5);
    cq.print();
    cq.enqueue(6);
    cq.dequeue();
    cq.print();
    cq.dequeue();
    cq.print();
    cq.dequeue();
    cq.print();
    cq.dequeue();
    cq.print();
    cq.dequeue();
    cq.print();
    cq.dequeue();
    cq.print();
}