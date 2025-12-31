#include <iostream>
using namespace std;

class Stack {
private:
    int arr[100];   // fixed size array
    int top;        // index of top element

public:
    Stack() { top = -1; }

    void push(int value);      // Task 1
    int pop();                 // Task 2
    void popUntil(int index);  // Task 3
    void reverse();            // Task 4
    void display();            // helper to show stack contents
};

int main() {
    Stack st;
    st.push(10);
    st.push(20);
    st.push(30);
    st.push(40);

    cout << "Stack contents:\n";
    st.display();

    cout << "\nPop one element:\n";
    st.pop();
    st.display();

    cout << "\nPop until index 1:\n";
    st.popUntil(1);
    st.display();

    cout << "\nReverse stack:\n";
    st.reverse();
    st.display();

    return 0;
}

// ===============================
// TODO: Implement Functions Below
// ===============================

// Task 1: Push
void Stack::push(int value) {
    // complete here
    if (top != sizeof(arr)) {
        top = top + 1;
        arr[top] = value;
    }
}

// Task 2: Pop
int Stack::pop() {
    // complete here
    if (top != -1) {
        int value = arr[top];
        top = top - 1;
        return value;
    }
}

// Task 3: Pop until index
void Stack::popUntil(int index) {
    // complete here
    while (top > index) {
        int value = pop();
        cout << "Popped: " << value << endl;
    }
}

// Task 4: Reverse
void Stack::reverse() {
    // complete here
    if (top > -1) {
        int size = top + 1;
        int tempArr[size];
    
        for (int index = 0; index < size; index++) {
            int value = pop();
            tempArr[index] = value;
        }

        for (int index = 0; index < size; index++) {
            push(tempArr[index]);
        }
    }
}

// Helper: Display stack
void Stack::display() {
    // complete here
    if (top > -1) {
        for (int index = 0; index < top+1; index++) {
            cout << arr[index] << " ";
        }
        cout << endl;
    }
}
