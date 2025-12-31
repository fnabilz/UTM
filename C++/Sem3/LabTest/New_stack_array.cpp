#include <iostream>
using namespace std;
#define SIZE 10

class Stack {
private:
    int theArray[SIZE];
    int top;

public:

    Stack() {
        top = -1;
    }

    bool isFull() {
        return (top == SIZE-1);
    }

    bool isEmpty() {
        return (top == -1);
    }

    int StackTop() {
        if (!isEmpty()) {
            return theArray[top];
        }
        return -1;
    }

    void push(int data) {
        if (!isFull()) {
            top = top + 1;
            theArray[top] = data;
        }
    }

    int pop() {
        if (!isEmpty()) {
            int value = theArray[top];
            top = top - 1;
            return value;
        }
        return -1;
    }

    void display() {
        if (!isEmpty()) {
            int max = top + 1;
            cout << "Stack: ";
            for (int index = 0; index < max; index++) {
                cout << theArray[index] << " ";
            }
            cout << endl;
        }
    }
};

int main() {

    Stack stack_baru;

    stack_baru.push(1);
    stack_baru.push(2);
    stack_baru.push(3);
    stack_baru.push(4);
    stack_baru.push(5);

    stack_baru.display();

    int poppy = stack_baru.pop();
    cout << "\nNombor yang keluar: " << poppy << endl;

    stack_baru.display();

    poppy = stack_baru.pop();
    cout << "\nNombor yang keluar: " << poppy << endl;
    poppy = stack_baru.pop();
    cout << "\nNombor yang keluar: " << poppy << endl;

    stack_baru.display();

    return 0;
}