#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main() {

    int n = 0;

    cin >> n;

    char s[n][11];
    char s0[11] = "codeforces";
    int r[n] = {0};

    for (int i = 0; i < n; i++) {
        cin >> s[i];
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 10; j++) {
            if (s[i][j] != s0[j]) ++r[i];
        }
    }
    for (int i = 0; i < n; i++) {
        cout << r[i] << endl;
    }

    return 0;
}