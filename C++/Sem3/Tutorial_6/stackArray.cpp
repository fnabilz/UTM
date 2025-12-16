#include <iostream>
#define MAX 100
using namespace std;

class StackArray {
private:
    char arr[MAX];
    int top;

public:
    void createStack() {
        top = -1;
    }

    bool isEmpty() {
        return top == -1;
    }

    bool isFull() {
        return top == MAX - 1;
    }

    void push(char item) {
        if (isFull()) {
            cout << "Stack Overflow!" << endl;
            return;
        }
        arr[++top] = item;
    }

    void pop() {
        if (isEmpty()) {
            cout << "Stack Underflow!" << endl;
            return;
        }
        top--;
    }

    char stackTop() {
        if (isEmpty()) {
            cout << "Stack is Empty!" << endl;
            return '\0';
        }
        return arr[top];
    }

};

int main() {
    StackArray stack;

    stack.createStack();

    stack.push('X');
    stack.push('Y');

    cout << "Top of stack: " << stack.stackTop() << endl;

    stack.pop();
    cout << "Top of stack after pop: " << stack.stackTop() << endl;
    stack.pop();

    if (stack.isEmpty()) {
        cout << "The stack is empty." << endl;
    }
    else {
        cout << "The stack is not empty." << endl;
    }

    return 0;
}