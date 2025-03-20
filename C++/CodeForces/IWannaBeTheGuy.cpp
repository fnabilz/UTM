#include <iostream>
using namespace std;

int main() {

    int n = 0, p = 0, q = 0, g = 0, r = 0;

    cin >> n;

    int l[n] = {0};

    cin >> p;
    for (int i = 0; i < p; i++) {
        int t = 0;
        cin >> t;
        l[t-1] = t;
    }

    cin >> q;
    for (int i = 0; i < q; i++) {
        int t = 0;
        cin >> t;
        l[t-1] = t;
    }

    for (int i = 0; i < n; i++) {
        g += i+1;
        r += l[i];
    }

    if (r == g) cout << "I become the guy.";
    else cout << "Oh, my keyboard!";
    

    return 0;
}