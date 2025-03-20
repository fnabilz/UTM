#include <iostream>
#include <string>
using namespace std;

int main() {

    bool c = false;
    string s1, s2;

    cin >> s1;
    cin >> s2;

    int m = 0;
    if (s1.size() > s2.size()) m = s1.size();
    else m = s2.size();
 
    for (int i = 0; i < m; i++) {
        if (s1[i] == s2[m-1-i]) c = true;
        else {c = false; break;}
    }

    if (c) cout << "YES";
    else cout << "NO";

    return 0;
}