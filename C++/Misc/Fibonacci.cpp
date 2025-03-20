// Sequence: 0, 1, 1, 2, 3, 5, 8,...

#include <iostream>
using namespace std;

int f(int n) {
    if (n == 0)
        return 0;
    if (n == 1)
        return 1;
    return f(n - 2) + f(n - 1);
}

int main() {

    for (int n = 0; n < 7; n++) {
        cout << f(n) << ",\n";
    }

    return 0;
}