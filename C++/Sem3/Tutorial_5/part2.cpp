#include <iostream>
using namespace std;

class Node {
public:
    long long ISBNno;
    double price;
    Node* next;
};

class List {
public:
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
    Node* InsertNode(long long isbn, double price);

    // find a node by its value, return index
    int FindNode(long long isbn);

    // delete a node by its value, return index
    int DeleteNode(long long isbn); 

    // display the linked list
    void DisplayList();

private:
    Node* head;
};

Node* List::InsertNode(long long isbn, double price) {
    Node* newNode = new Node();
    newNode->ISBNno = isbn;
    newNode->price = price;
    newNode->next = nullptr;

    if (!head) 
        head = newNode;
    else {
        Node* curr = head;
        while (curr->next) {
            curr = curr->next;
        }
        curr->next = newNode;
    }

    return newNode;
}

int List::FindNode(long long isbn) {
    Node* current = head;
    int index = 1;

    while (current) {
        if (current->ISBNno == isbn) 
            return index;
        current = current->next;
        index++; 
    }

    return 0;
}

int List::DeleteNode(long long isbn) {
    Node* prevNode = nullptr;
    Node* currNode = head;
    int currIndex = 1;

    while (currNode && currNode->ISBNno != isbn) {
        prevNode = currNode;
        currNode = currNode->next;
        currIndex++;
    }

    if (currNode) {
        if (prevNode)
            prevNode->next = currNode->next;
        else
            head = currNode->next;
        delete currNode;
        return currIndex;
    }
    return 0;
}

void List::DisplayList() {
    Node* temp = head;
    while (temp) {
        cout << "ISBN: " << temp->ISBNno << ", Price: " << temp->price << endl;
        temp = temp->next;
    }
}

int main() {
    List myList;
    
    myList.InsertNode(9781111111, 45.50);
    myList.InsertNode(9782222222, 50.00);
    myList.InsertNode(9783333333, 60.75);

    cout << "Initial List:" << endl;
    myList.DisplayList();

    long long ibsnToFind = 9782222222;
    int index = myList.FindNode(ibsnToFind);
    if (index) {
        cout << "Book with ISBN " << ibsnToFind << " found at index " << index << endl;
    }
    else {
        cout << "Book with ISBN " << ibsnToFind << " not found in the list. " << endl;
    }

    cout << "Deleting book with ISBN 9782222222..." << endl;
    int deleteIndex = myList.DeleteNode(9782222222);
    if (deleteIndex) {
        cout << "Book deleted at index " << deleteIndex << endl;
    }
    else {
        cout << "Book not found." << endl;
    }

    cout << "Updated List:" << endl;
    myList.DisplayList();

    return 0;


}