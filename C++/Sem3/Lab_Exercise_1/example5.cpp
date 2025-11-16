#include <iostream>
using namespace std;

int main() {
    int n = 10;
    int step = 0;

    for (int a = 1; a <= 10; a++) {
        ++step;
        for (int b = 1; b <= a; b++) {
            ++step;
            cout << "Example of step calculation";
            ++step;
        }
    }

    cout << "Steps: " << step;
}