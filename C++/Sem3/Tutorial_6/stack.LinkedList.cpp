#include <iostream>
using namespace std;

struct Node {
    char data;
    Node* next;
};

class StackLinkedList {
private:
    Node* top;

public:
    void createStack() {
        top = nullptr;
    }

    bool isEmpty() {
        return top == nullptr;
    }

    void push(char item) {
        Node* newNode = new Node();
        newNode->data = item;
        newNode ->next = top;
        top = newNode;
    }

    void pop() {
        if (isEmpty()) {
            cout << "Stack Underflow!" << endl;
            return;
        }

        Node* temp = top;
        top = top->next;
        delete temp;
    }

    char stackTop() {
        if (isEmpty()) {
            cout << "Stack is Empty!" << endl;
            return '\0';
        }
        return top->data;
    }
};

int main() {
    StackLinkedList stack;

    stack.createStack();

    stack.push('A');
    stack.push('B');

    cout << "Top of stack: " << stack.stackTop() << endl;

    stack.pop();
    cout << "Top of stack after pop: " << stack.stackTop() << endl;
    stack.pop();

    if (stack.isEmpty()) {
        cout << "The stack is empty." << endl;
    } else {
        cout << "The stack is not empty." << endl;
    }

    return 0;
}