#include <iostream>
using namespace std;

class Node {
public:
    double data;
    Node* next;
};

class List {
public:
    // constructor
    List () { head = nullptr; }

    // destructor
    ~List() {
        Node* currNode = head;
        Node* nextNode = nullptr;

        while (currNode != nullptr) {
            nextNode = currNode->next;
            delete currNode;
            currNode = nextNode;
        }
        head = nullptr;
    }

    // check if list is empty
    bool IsEmpty() {return head == nullptr;}

    // insert new node
    Node* InsertNode(double x);

    // find a node by its value, return index
    int FindNode(double x);

    // delete a node by its value, return index
    int DeleteNode(double x); 

    // display the linked list
    void DisplayList();


private:
    Node* head;

};

// function implementation/definition
Node* List::InsertNode(double x) {
    Node* newNode = new Node();
    newNode->data = x;
    newNode->next = nullptr;

    if (!head || x < head->data) {
        newNode->next = head;
        head = newNode;
    }
    else {
        Node* curr = head;
        while (curr->next && curr->next->data < x) {
            curr = curr->next;
        }
        newNode->next = curr->next;
        curr->next = newNode;
    }
    return newNode;
}

int List::FindNode(double x) {
    Node* current = head;
    int index = 1;

    while (current) {
        if (current->data == x) return index;
        current = current->next;
        index++;
    }
    return 0;
}

int List::DeleteNode(double x) {
    Node* prevNode = nullptr;
    Node* currNode = head;
    int currIndex = 1;

    while (currNode && currNode->data != x) {
        prevNode = currNode;
        currNode = currNode->next;
        currIndex++;
    }

    if (currNode) {

        if (prevNode) {
            prevNode->next = currNode->next;
        }
        else {
            head = currNode->next;
        }
        delete currNode;
        return currIndex;
    }

    return 0;
}

void List::DisplayList() {
    Node* temp = head;
    while (temp) {
        cout << temp->data << " -> ";
        temp = temp->next;
    }
    cout << "nullptr" << endl;
}

int main() {
    List myList;

    myList.InsertNode(4.5);
    myList.InsertNode(5.5);
    myList.InsertNode(6.7);
    myList.InsertNode(8.6);

    cout << "Initial List: ";
    myList.DisplayList();

    double valueToFind = 6.7;
    int index = myList.FindNode(valueToFind);
    if (index) {
        cout << "Value " << valueToFind << " found at index " << index << endl;
    }
    else {
        cout << "Value " << valueToFind << " not found in the list." << endl;
    }

    cout << "Deleting 5.5: ";
    int deleteIndex = myList.DeleteNode(5.5);
    if (deleteIndex) {
        cout << "Deleted at index " << deleteIndex << endl;
    }
    else {
        cout << "Value not found." << endl;
    }

    cout << "Updated List: ";
    myList.DisplayList();

    return 0;
}
