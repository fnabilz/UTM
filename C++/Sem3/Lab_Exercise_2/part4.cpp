#include <iostream>
using namespace std;

int main() {

    int steps = 0;
    int n = 4;

    int sum = 0;
    ++steps;
    for (int i = 1; i <= n; i++) {
        ++steps;
        for (int j = i; j <= n; j+=i) {
            sum += j;
            ++steps;
            cout << sum << endl;
            ++steps;
        }
    }

    cout << "\nTotal Steps: " << steps << endl;

    return 0;
}