#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
};


class Stack {
private:
    Node* top;

public:
    Stack() {
        top = nullptr;
    }

    ~Stack() {
        while (!isEmpty()) {
            pop();
        }
    }

    bool isEmpty() {
        return (top == nullptr);
    }

    void push(int data) {
        Node* newNode = new Node;
        newNode->data = data;

        if (isEmpty()) {
            newNode->next = nullptr;
        }
        else {
            newNode->next = top;
        }
        top = newNode;
    }

    int pop() {
        if (!isEmpty()) {
            Node* currentNode = top;
            int value = currentNode->data;
            top = top->next;
            delete (currentNode);
            return value;
        }
        return -1;
    }

    void display() {
        Node* currentNode = top;
        cout << "Stack: ";
        while (currentNode) {
            cout << currentNode->data << " ";
            currentNode = currentNode->next;
        }
        cout << endl;
    }
};

int main() {

    Stack stackBaru;

    stackBaru.push(1);
    stackBaru.push(2);
    stackBaru.push(3);
    stackBaru.push(4);
    stackBaru.push(5);

    stackBaru.display();

    int keluar = stackBaru.pop();
    cout << "\nNombor yang keluar: " << keluar << endl;
    stackBaru.display();

    keluar = stackBaru.pop();
    cout << "\nNombor yang keluar: " << keluar << endl;
    keluar = stackBaru.pop();
    cout << "\nNombor yang keluar: " << keluar << endl;
    stackBaru.display();

    stackBaru.push(10);
    stackBaru.push(11);
    stackBaru.push(12);
    stackBaru.push(67);
    stackBaru.display();

    keluar = stackBaru.pop();
    cout << "\nNombor yang keluar: " << keluar << endl;
    stackBaru.display();

    return 0;
}