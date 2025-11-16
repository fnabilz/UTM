#include <iostream>
using namespace std;

int partition(int arrayT[], int first, int last) {
    int pivot = arrayT[first];
    int bottom = first + 1;
    int top = last;

    while (true) {
        while (top >= bottom && arrayT[top] > pivot) {
            top--;
        }

        while (bottom <= top && arrayT[bottom] < pivot) {
            bottom++;
        }

        if (bottom >= top) {
            break;
        }

        swap(arrayT[bottom], arrayT[top]);
    }

    swap(arrayT[first], arrayT[top]);

    cout << "After partitioning with pivot " << pivot << ":\n";
    for (int i = 0; i < last + 1; i++) {
        if (i == top) {
            cout << "[" << arrayT[i] << "] ";
        }
        else {
            cout << arrayT[i] << " ";
        }
    }
    cout << "\n\n";

    return top;
}

void quickSort(int arrayT[], int first, int last) {
    if (first < last) {
        int cut = partition(arrayT, first, last);
        cout << "Subarray sorting: [" << first << ", " << cut - 1 << "] and [" << cut + 1 << ", " << last << "]\n\n";
        quickSort(arrayT, first, cut - 1);
        quickSort(arrayT, cut + 1, last);
    }
}

void swap(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

void displayArray(int array[], int size) {
    for (int i = 0; i < size; i++) {
        cout << array[i] << " ";
    }

    cout << endl;
}

int main() {
    int arrayT[] = {29, 10, 14, 37, 13};
    int size = sizeof(arrayT) / sizeof(arrayT[0]);

    cout << "Original array:\n";
    displayArray(arrayT, size);

    quickSort(arrayT, 0, size - 1);

    cout << "\nSorted array:\n";
    displayArray(arrayT, size);
    

    return 0;
}