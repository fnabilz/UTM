#include <iostream>
#include <string>
using namespace std;

int main() {

    int u = 0, l = 0;

    string s;
    cin >> s;

    for (int i = 0; i < s.size(); i++) {
        if (isupper(s[i])) 
            ++u;
        else
            ++l;
    }

     for (int i = 0; i < s.size(); i++) {
        if (u > l) {
            if (islower(s[i])) 
                s[i] = toupper(s[i]);
        }
        else {
            if (isupper(s[i]))
                s[i] = tolower(s[i]);
        }
    }

    cout << s << endl;


    return 0;
}