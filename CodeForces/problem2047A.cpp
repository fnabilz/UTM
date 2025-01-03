#include <iostream>
#include <cmath>
using namespace std;

int main() {

    int t = 0;

    cin >> t;

    int result[t] = {0};

    for (int i = 0; i < t; i++) {
        int n = 0;
        cin >> n;
        int array[n] = {0};
        int total = 0;
        for (int j = 0; j < n; j++) {
            cin >> array[j];
        }
        
        int layer = 0;
        for (int j = 0; j < n; j++) {
            layer += array[j];
            int r = sqrt(layer);
            if (r * r == layer) {
                if (r % 2 != 0) {
                    ++total;
                }
            }
        }
        
        result[i] = total;
    }

    for (int i = 0; i < t; i++) {
        cout << result[i] << endl;
    }

    return 0;
}