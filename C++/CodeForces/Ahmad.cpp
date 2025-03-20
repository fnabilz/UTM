#include <iostream>
#include <string>
using namespace std;

int main(){
    int n = 0, k = 0;
    cin >> n >> k;
    string trail;
    cin >> trail;
    bool c = false;
    int i = 0;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < k; j++) {
            if (trail[i+j+1] == '.') {
                i = i+j;
                c = true;
                break;
            }
            else c = false;
        }
        if (!c) break;
    }
    
    if (c) cout << "YES";
    else cout << "NO";

    return 0;
}