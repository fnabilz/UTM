#include <iostream>
#include <string>
using namespace std;

void BubbleSort(int data[], int listSize) {
    int pass, tempValue;

    for (pass = 1; pass < listSize; pass++) {
        cout << "Integer Array Pass " << pass << ":\n";
        for (int x = 0; x < listSize - pass; x++) {
            cout << " Comparing " << data[x] << " and " << data[x+1] << ": ";
            if (data[x] > data[x+1]) {
                tempValue = data[x];
                data[x] = data[x+1];
                data[x+1] = tempValue;
                cout << "Swapped\n";
            }
            else {
                cout << "No Swap\n";
            }
        }

        for (int k = 0; k < listSize; k++) {
            cout << data[k] << " ";
        }
        cout << "\n\n";
    }
}

void BubbleSort(string data[], int listSize) {
    int pass; 
    string tempValue;

    for (pass = 1; pass < listSize; pass++) {
        cout << "Integer Array Pass " << pass << ":\n";
        for (int x = 0; x < listSize - pass; x++) {
            cout << " Comparing " << data[x] << " and " << data[x+1] << ": ";
            if (data[x] > data[x+1]) {
                tempValue = data[x];
                data[x] = data[x+1];
                data[x+1] = tempValue;
                cout << "Swapped\n";
            }
            else {
                cout << "No Swap\n";
            }
        }

        for (int k = 0; k < listSize; k++) {
            cout << data[k] << " ";
        }
        cout << "\n\n";
    }
}

int main() {
    int intArr[] = {64, 25, 12, 22, 11};
    int intSize = sizeof(intArr) / sizeof(intArr[0]);
    cout << "Sorting Integer Array:\n";
    BubbleSort(intArr, intSize);

    string strArr[] = {"apple", "orange", "banana", "grape", "cherry"};
    int strSize = sizeof(strArr) / sizeof(strArr[0]);
    cout << "Sorting String Array:\n";
    BubbleSort(strArr, strSize);

    return 0;
}