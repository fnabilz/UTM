#include <iostream>
using namespace std;

int main() {

    int t, n;

    cin >> t;

    int result[t] = {0};

    for (int i = 0; i < t; i++) {
        cin >> n;
        int array[n] = {0};
        int largest = 0;
        for (int j = 0; j < n; j++) {
            cin >> array[j];
            if (array[j] > largest) largest = array[j];
        }
        int lowest = array[0];
        for (int j = 0; j < n; j++) {
            if (array[j] < lowest) lowest = array[j];
        }
        result[i] = largest - lowest;
    }

    for (int i = 0; i < t; i++) {
        cout << result[i] << endl;
    }

    return 0;
}