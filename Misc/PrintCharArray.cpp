#include <iostream>
#include <iomanip>
using namespace std;

int main() {

    char name[] = {'H', 'e', 'n', 'r', 'y','\0'};

    cout << setw(3) << name;

    return 0;
}

