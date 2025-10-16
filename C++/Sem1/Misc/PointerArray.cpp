#include <iostream>
using namespace std;

int main() {

    int vals[]={4,7,11}; 
    int *valptr = vals;

    valptr = vals; // points at 4
    valptr += 2;   // points at 11

    cout << *valptr;

    return 0;
}