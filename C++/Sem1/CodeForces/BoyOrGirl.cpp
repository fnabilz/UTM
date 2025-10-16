#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {

    string s = "";
    int t = 0;

    getline(cin, s);
    
    sort(s.begin(), s.end());

    for (int i = 0; i < s.size(); i++) {
        if (s[i] != s[i+1]) 
            ++t;   
    }

    if (t%2 == 0)
        cout << "CHAT WITH HER!";
    else
        cout << "IGNORE HIM!";

    return 0;
}