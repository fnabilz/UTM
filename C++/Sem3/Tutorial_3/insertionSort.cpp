#include <iostream>
#include <string>
using namespace std;

void insertionSort(int data[], int n) {
    int item, insertIndex;

    for (int pass = 1; pass < n; pass++) {
        item = data[pass];
        insertIndex = pass;

        while ((insertIndex > 0) && (data[insertIndex - 1] > item)) {
            data[insertIndex] = data[insertIndex - 1];
            insertIndex--;
        }
        data[insertIndex] = item;

        cout << "\nAfter pass " << pass << ": \n";
        for (int i = 0; i < n; i++) {
            cout << data[i] << " ";
        }
    }
}

void insertionSort(string data[], int n) {
    string item;
    int insertIndex;

    for (int pass = 1; pass < n; pass++) {
        item = data[pass];
        insertIndex = pass;

        while ((insertIndex > 0) && (data[insertIndex - 1] > item)) {
            data[insertIndex] = data[insertIndex - 1];
            insertIndex--;
        }
        data[insertIndex] = item;
    }
}

int main() {
    int scores[] = {7, 4, 5, 2};
    int scoreSize = sizeof(scores) / sizeof(scores[0]);
    insertionSort(scores, scoreSize);
    cout << "Sorted Scores:\n";
    for (int i = 0; i < scoreSize; i++) {
        cout << scores[i] << " ";
    }
    cout << "\n\n";

    /*
    string names[] = {"Zara", "Ali", "John", "Bella", "Ming"};
    int nameSize = sizeof(names) / sizeof(names[0]);
    insertionSort(names, nameSize);
    cout << "Sorted Names:\n";
    for (int i = 0; i< nameSize; i++) {
        cout << names[i] << " ";
    }
    cout << "\n";
    */

    return 0;
}

