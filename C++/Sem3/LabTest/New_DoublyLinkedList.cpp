#include <iostream>
using namespace std;

class Node {
public:
    int data;
    Node* next;
    Node* prev;

};

class DoublyLinkedList {
private:
    Node* front;
    Node* back;

public:
    DoublyLinkedList() {
        front = nullptr;
        back = nullptr;
    }

    ~DoublyLinkedList() {
        Node* currentNode = front;
        while (currentNode) {
            front = front->next;
            delete(currentNode);
            currentNode = front;
        }
    }

    bool isEmpty() {
        return (front == nullptr);
    }

    Node* InsertNode(int data) {
        Node* newNode = new Node;
        newNode->data = data;

        if (!front) {
            newNode->next = nullptr;
            newNode->prev = nullptr;
            front = back = newNode;
        } 
        else {
            newNode->next = nullptr;
            newNode->prev = back;
            back->next = newNode;
            back = newNode;
        }

        return newNode;
    }

    int DeleteNode(int data) {
        int currentIndex = 0;
        Node* currentNode = front;
        Node* prevNode = nullptr;
        while (currentNode && currentNode->data != data) {
            prevNode = currentNode;
            currentNode = currentNode->next;
            currentIndex++;
        }

        if (currentNode) {
            Node* nextNode = currentNode->next;
            prevNode->next = nextNode;
            nextNode->prev = prevNode;
            delete(currentNode);
            return currentIndex;
        }
        else {
            return -1;
        }
    }

    int FindNode(int data) {
        int currentIndex = 0;
        Node* currentNode = front;
        while (currentNode && currentNode->data != data) {
            currentNode = currentNode->next;
            currentIndex++;
        }

        if (currentNode) {
            return currentIndex;
        }
        else {
            return -1;
        }
    }

    void DisplayFromFront() {
        Node* currentNode = front;
        cout << "\nFrom Front: ";
        while (currentNode) {
            cout << currentNode->data << " ";
            currentNode = currentNode->next;
        }
        cout << endl;
    }


     void DisplayFromBack() {
        Node* currentNode = back;
        cout << "\nFrom back: ";
        while (currentNode) {
            cout << currentNode->data << " ";
            currentNode = currentNode->prev;
        }
        cout << endl;
    }
};

int main() {

    DoublyLinkedList dList;

    dList.InsertNode(1);
    dList.InsertNode(2);
    dList.InsertNode(3);
    dList.InsertNode(4);
    dList.InsertNode(5);

    dList.DisplayFromFront();
    dList.DisplayFromBack();

    int ToDeleteValue = 4;
    int IndexValue = dList.DeleteNode(ToDeleteValue);
    cout << "\nDeleted " << ToDeleteValue << " at index " << IndexValue << endl;

    dList.DisplayFromFront();
    dList.DisplayFromBack();

    return 0;
}