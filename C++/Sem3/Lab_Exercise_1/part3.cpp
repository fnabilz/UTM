#include <iostream> 
using namespace std; 

void reverseString(string str, int index) { 
    if (index < 0) 
        return; 
    cout << index << ":" << str[index] << "\n";   
    reverseString(str, index - 1); 
} 

int main() { 
    string text = "ALGORITHM"; 
    cout << text.length();
    reverseString(text, text.length() - 1); 
    return 0; 
}