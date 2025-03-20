#include <iostream>
#include <vector>
using namespace std;

int main() {

    int f = 0;
    cin >> f;

    if (f % 5 == 0)
        cout << f/5;
    else 
        cout << (f/5)+1;
    
    return 0;
}