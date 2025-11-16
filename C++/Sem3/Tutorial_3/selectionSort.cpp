#include <iostream>
#include <string>
using namespace std;

void swapInt(int &x, int &y) {
    int temp = x;
    x = y;
    y = temp;
}

void selectionSortInt(int Data[], int n) {
    for (int last = n - 1; last >= 1; --last) {
        int largestIndex = 0;
        for (int p = 1; p <= last; ++p) {
            if (Data[p] > Data[largestIndex])
                largestIndex = p;
        }
        swapInt(Data[largestIndex], Data[last]);
    }
}

void swapStr(string &x, string &y) {
    string temp = x;
    x = y;
    y = temp;
}

void selectionSortStr(string Data[], int n) {
    for (int last = n - 1; last >= 1; --last) {
        int largestIndex = 0;
        for (int p = 1; p <= last; ++p) {
            if (Data[p] > Data[largestIndex])
                largestIndex = p;
        }
        swapStr(Data[largestIndex], Data[last]);
    }
}

int main() {
    int marks[] = {85, 74, 92, 67, 89};
    int n = sizeof(marks) / sizeof(marks[0]);
    selectionSortInt(marks, n);
    cout << "Sorted Integer Array:\n";
    for (int i = 0; i < n; i++) cout << marks[i] << " ";
    cout << "\n";

    string names[] = {"Li Wei", "Amit", "Hiroshi", "Nguyen", "Siti"};
    int m = sizeof(names) / sizeof(names[0]);
    selectionSortStr(names, m);
     cout << "Sorted String Array:\n";
    for (int i = 0; i < n; i++) cout << names[i] << " ";
    cout << "\n";

    return 0;
}