#include <iostream>
using namespace std;

class Node{
public:
    char data;
    Node* next;
};

class LinearQueue{
private:
    Node* frontPtr;
    Node* backPtr;

public:
    LinearQueue() {
        frontPtr = nullptr;
        backPtr = nullptr;
    }

    ~LinearQueue() {
        Node* tempPtr = frontPtr;
        while (tempPtr != nullptr) {
            frontPtr = frontPtr->next;
            delete tempPtr;
            tempPtr = frontPtr;
        }
    }

    bool isEmpty() {
        if (frontPtr == nullptr && backPtr == nullptr)
            return true;
        return false;
    }

    char getFront() {
        if (isEmpty() == false) {
            return frontPtr->data;
        }
        return ' ';
    }
    
    char getRear() {
        if (isEmpty() == false) {
            return backPtr->data;
        }
        return ' ';
    }

    void enqueue(char item) {
        Node* newPtr = new Node();
        newPtr->data = item;
        newPtr->next = nullptr;

        if (isEmpty()) {
            frontPtr = backPtr = newPtr;
        }
        else {
            backPtr->next = newPtr;
            backPtr = newPtr;
        }
    }

    void dequeue() {
        if (!isEmpty()) {
            Node* tempPtr = frontPtr;
            frontPtr = frontPtr->next;
            cout << "\nDequeue: " << tempPtr->data;
            delete tempPtr;

            if (frontPtr == nullptr) {
                backPtr = nullptr;
            }
        }
        else {
            cout << "\nCan't remove data, Linked List Linear Queue is empty!" << endl;
        }
    }

    void print() {
        if (isEmpty() == false) {
            Node* tempPtr = frontPtr;
            cout << "\nLinked List Linear Queue:";
            while (tempPtr != nullptr) {
                cout << " " << tempPtr->data;
                tempPtr = tempPtr->next;
            } 
        } else {
            cout << "\nLinked List Linear Queue is empty!" << endl;
        }
    }

};

class CircularQueue{
private:
    Node* backPtr;

public:
    CircularQueue() {
        backPtr = nullptr;
    }

    ~CircularQueue() {
        if (isEmpty() == false) {
            Node* tempPtr = backPtr->next;
            backPtr->next = nullptr;
            while (tempPtr) {
                Node* deletePtr = tempPtr;
                tempPtr = tempPtr->next;
                delete deletePtr;
            }
        }
    }

    bool isEmpty() {
        if (backPtr == nullptr)
            return true;
        return false;
    }

    char getFront() {
        if (isEmpty() == false) {
            return backPtr->next->data;
        }
        return ' ';
    }
    
    char getRear() {
        if (isEmpty() == false) {
            return backPtr->data;
        }
        return ' ';
    }

    void enqueue(char item) {
        Node* newPtr = new Node();
        newPtr->data = item;

        if (isEmpty()) {
            newPtr->next = newPtr;
            backPtr = newPtr;
        }
        else {
            newPtr->next = backPtr->next;
            backPtr->next = newPtr;
            backPtr = newPtr;
        }
    }

    void dequeue() {
        if (isEmpty() == false) {
            Node* tempPtr = backPtr->next;
            backPtr->next = tempPtr->next;
            if (tempPtr == backPtr)
                backPtr = nullptr;
            cout << "\nDequeue: " << tempPtr->data;
            delete tempPtr;
        }
        else {
            cout << "\nCan't remove data, Linked List Circular Queue is empty!" << endl;
        }
    }

    void print() {
        if (isEmpty() == false) {
            Node* tempPtr = backPtr->next;
            cout << "\nLinked List Circular Queue:";
            do {
                cout << " " << tempPtr->data;
                tempPtr = tempPtr->next;
            } while (tempPtr != backPtr->next);
        } else {
            cout << "\nLinked List Circular Queue is empty!" << endl;
        }
    }
};

int main(){

    LinearQueue lq;

    lq.enqueue('A');
    lq.enqueue('B');
    lq.enqueue('C');
    lq.print();

    cout << "\nFront Node: " << lq.getFront();
    cout << "\nBack Node: " << lq.getRear();

    lq.dequeue();
    lq.dequeue();
    lq.print();

    lq.dequeue();
    lq.dequeue();
    lq.print();

    CircularQueue cq;

    cq.enqueue('D');
    cq.enqueue('E');
    cq.enqueue('F');
    cq.print();

    cout << "\nFront Node: " << cq.getFront();
    cout << "\nBack Node: " << cq.getRear();

    cq.dequeue();
    cq.dequeue();
    cq.print();

    cq.dequeue();
    cq.dequeue();
    cq.print();

    return 0;

}