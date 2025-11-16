#include <iostream>
using namespace std;

const int MAX_SIZE = 100;

void printSublist(int theArray[], int start, int end) {
    cout << "[ ";
    for (int i = start; i <= end; i++) {
        cout << theArray[i] << " ";
    }
    cout << "]";
}

void merge(int theArray[], int first, int mid, int last) {
    int tempArray[MAX_SIZE];
    int first1 = first;
    int last1 = mid;
    int first2 = mid + 1;
    int last2 = last;
    int index = first1;

    cout << "Merging ";
    printSublist(theArray, first, mid);
    cout << " and ";
    printSublist(theArray, mid + 1, last);
    cout << " -> ";

    while (first1 <= last1 && first2 <= last2) {
        if (theArray[first1] < theArray[first2]) {
            tempArray[index++] = theArray[first1++];
        }
        else {
            tempArray[index++] = theArray[first2++];
        }
    }

    while (first1 <= last1) {
        tempArray[index++] = theArray[first1++];
    }

    while (first2 <= last2) {
        tempArray[index++] = theArray[first2++];
    }

    for (index = first; index <= last; ++index) {
        theArray[index] = tempArray[index];
    }

    printSublist(theArray, first, last);
    cout << endl;
}

void mergeSort(int theArray[], int first, int last) {
    if (first < last) {
        int mid = (first + last) / 2;
        
        cout << "Dividing ";
        printSublist(theArray, first, last);
        cout << " at index " << mid << " into ";
        printSublist(theArray, first, mid);
        cout << " and ";
        printSublist(theArray, mid + 1, last);
        cout << endl;

        mergeSort(theArray, first, mid);
        mergeSort(theArray, mid + 1, last);
        merge(theArray, first, mid, last);
    }
}

int main() {
    int arr[] = {38, 27, 43, 3, 9, 82, 10};
    int size = 7;

    cout << "Original Array:\n";
    printSublist(arr, 0, size - 1);
    cout << "\n\n";

    mergeSort(arr, 0, size - 1);

    cout << "\nSorted Array:\n";
    printSublist(arr, 0, size - 1);
    cout << endl;

    return 0;
}