#include <iostream>
using namespace std;

void merge(int theArray[], int first, int mid, int last, int size) {
    int tempArray[size];
    int first1 = first;
    int last1 = mid;
    int first2 = mid + 1;
    int last2 = last;
    int index = first1;

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

}

void mergeSort(int theArray[], int first, int last, int size) {
    if (first < last) {
        int mid = (first + last) / 2;

        mergeSort(theArray, first, mid, size);
        mergeSort(theArray, mid + 1, last, size);
        merge(theArray, first, mid, last, size);
    }
}

int linearSearch(int arr[], int size, int keySearch, int& comparisons) {

    int index = -1;

    for (int i = 0; i < size; i++) {
        ++comparisons;
        if (keySearch < arr[i]) 
            break;
        else if (keySearch == arr[i]) {
            index = i;
            break;
        }
    }

    return index;
}


int binarySearch(int arr[], int size, int keySearch, int& comparisons) {
    
    int index = -1;
    int middle;
    int left = 0;
    int right = size - 1;

    while (left <= right) {
        middle = (left + right) / 2;
        ++comparisons;
        if (keySearch == arr[middle]) {
            index = middle;
            break;
        }
        else if (keySearch > arr[middle]) {
            left = middle + 1;
        }
        else {
            right = middle - 1;
        }
    }

    return index;
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        cout << arr[i] << " ";
    }
    cout << endl;
}

void printResult(string title, int index, int comparisons) {
    cout << title << endl
        << "Found at index " << index << endl
        << "Comparisons made: " << comparisons << endl;
}

int main() {

    const int arraySize = 10;

    int studentId[arraySize] = {105, 312, 87, 521, 199, 403, 278, 156, 489, 301};

    cout << "\n\nUnsorted Student IDs:\n";
    printArray(studentId, arraySize);

    mergeSort(studentId, 0, arraySize - 1, arraySize);

    cout << endl;
    
    cout << "Sorted Student IDs:\n";
    printArray(studentId, arraySize);

    
    int keySearch = 0;

    cout << "\nEnter Student ID to search: ";
    cin >> keySearch;

    while (keySearch != -1) {
        int linearComparisons = 0, linearIndex = 0;
        int binaryComparisons = 0, binaryIndex = 0;

        linearIndex = linearSearch(studentId, arraySize, keySearch, linearComparisons);
        binaryIndex = binarySearch(studentId, arraySize, keySearch, binaryComparisons);

        printResult("\n--- Linear Search ---", linearIndex, linearComparisons);
        printResult("\n--- Binary Search ---", binaryIndex, binaryComparisons);

        cout << "\nDo you want to search another ID? (type any number, or -1 to quit): ";
        cin >> keySearch;
    }

    cout << "\nThank you! Goodbye.";
    return 0;
}