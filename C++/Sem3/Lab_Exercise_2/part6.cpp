#include <iostream>
using namespace std;

int main() {
    int steps = 0;
    int n = 4;

    int count = 0;
    ++steps;

    for (int i = 1; i <= n; i++) {
        ++steps;

        int operations = 1;
        ++steps;

        for (int j = 1; j <= i; j++) {
            ++steps;

            operations *= 2;
            ++steps;

            for (int k = 1; k <= operations; k++) {
                ++steps;

                count++;
                ++steps;
            }
        }

    }

    cout << "\nSteps: " << steps << endl;

    return 0;
}