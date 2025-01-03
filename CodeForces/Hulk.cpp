#include <iostream>
#include <string>
using namespace std;

int main() {

    int n;
    string h = "I hate ";
    string l = "that I love ";

    cin >> n;
    
    for (int i = 0; i < n; i++) {
        int m = i+1;
        if (m%2 == 1) {
            if (m != 1) cout << "that " << h;
            else cout << h;
        }
        else cout << l;
    }
    cout << "it";

    return 0;
}