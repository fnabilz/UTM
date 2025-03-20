#include <iostream>
#include <algorithm>
using namespace std;

int main() {

    int n = 0;

    cin >> n;

    int array[n] = {0};
    int c = 0;
    int choice = 0, total = 0;
    int l = 0;

    for (int i = 0; i < n; i++) {
        cin >> array[i];
        total += array[i];
    }

    sort(array, array + n);

    for (int i = n-1; i >= 0; i--) {
        choice += array[i];
        ++c;
        if (choice > (total - choice)) break;
    }

    cout << c;
    return 0;
}