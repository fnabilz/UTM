#include <iostream>
using namespace std;

int main() {

    int steps = 0;
    int n = 4;

    int counter = 0;
    //++steps;
    for (int i = 1; i <= n; i++) {
        //++steps;
        for (int j = 1; j <= n-i; j++) {
           //++steps;
            for (int k = j; k <= n; k++) {
                ++steps;
                counter++;
                //++steps;
            }
        }
    }

    cout << "\nTotal Steps: " << steps << endl;

    return 0;
}