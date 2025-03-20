#include <iostream>
#include <string>
using namespace std;


int main() {

    int n = 0;

    cin >> n;

    string array = "";
    int score[3] = {0};
    int total = 0;

    cin >> array;

    bool c = false;
    for (int i = 0; i < n; i++) {
        if (array[i] == 'A')
            ++score[0];
        else if (array[i] == 'I')
            ++score[1];
        else 
            ++score[2];
    }

    if (score[0] > 0) {
        if (score[1] == 0) 
            total = score[0];
    }
    if (score[1] == 1) {
        total = 1;
    }

    cout << total << endl;

    return 0;
}