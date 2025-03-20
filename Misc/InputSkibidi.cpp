#include <iostream>
#include <fstream>

using namespace std;

int main() {

    ifstream inFile;

    string skibidi;

    inFile.open("skibidi.txt");

    if (!inFile)
        cout << "Error opening file!" << endl;
    
    while (inFile >> skibidi) {
        cout << skibidi;
    }

    return 0;
}