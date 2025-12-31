#include <iostream>
using namespace std;

class Node {

public:
    int data;
    Node* next;

};


class LinkedList {

private:
    Node* head;

public:
    LinkedList() {
        head = nullptr;
    }

    ~LinkedList() {
        Node* currentNode = head;
        while (currentNode) {
            head = head->next;
            delete(currentNode);
            currentNode = head;
        }
    }

    bool isEmpty() {
        return (head == nullptr);
    }  

    Node* InsertNode(int data) {
        int currentIndex = 0;
        Node* currentNode = head;
        Node* previousNode = nullptr;
        while (currentNode && data > currentNode->data) {
            previousNode = currentNode;
            currentNode = currentNode->next;
            currentIndex++;
        }

        Node* newNode = new Node;
        newNode->data = data;
        if (currentIndex == 0) {
            newNode->next = nullptr;
            head = newNode;
        }
        else {
            previousNode->next = newNode;
            newNode->next = currentNode;
        }
        return newNode;
    }

    int FindNode(int data) {
        if (!isEmpty()) {
            Node* currentNode = head;
            int CurrentIndex = 0;
            while (currentNode && currentNode->data != data) {
                currentNode = currentNode->next;
                CurrentIndex++;
            }
            if (currentNode)
                return CurrentIndex;
            else
                return -1;
        }
    }

    int DeleteNode(int data) {
        Node* previousNode = nullptr;
        Node* currentNode = head;
        int currentIndex = 0;

        while (currentNode && currentNode->data != data) {
            previousNode = currentNode;
            currentNode = currentNode->next;
            currentIndex++;
        }

        if (currentNode) {
            if (previousNode) {
                previousNode->next = currentNode->next;
            }
            else {
                head = currentNode->next;
            }
            delete (currentNode);
            return currentIndex;
        }
        return -1;

    }

    void DisplayList() {
        Node* currentNode = head;
        while (currentNode) {
            cout << currentNode->data << " ";
            currentNode = currentNode->next;
        }
        cout << endl << endl;
    }

};

int main() {

    LinkedList list;

    list.InsertNode(1);
    list.InsertNode(2);
    list.InsertNode(3);
    list.InsertNode(4);
    list.InsertNode(5);

    list.DisplayList();

    int deleteData = 3;
    int dataIndex = list.DeleteNode(deleteData);

    cout << "Deleted " << deleteData << " at index " << dataIndex << endl;

    list.DisplayList();
    
    return 0;
}
