#include <iostream>
using namespace std;

int power(int a, int b);

int main() {

    int base = 2, exponent = 4;

    cout << base << "^" << exponent << " = " << power(base, exponent);

    return 0;
}

int power(int base, int exponent) {
    if (exponent == 0) 
        return 1;
    else 
        return base * power(base, exponent - 1);
}