#include <iostream>
using namespace std;

class Student {
    private:
    string name;
    int age;

    public:
    Student() : name("Unknown"), age(0) {}

    Student(string n, int a) : name(n), age(a) {}

    void displayInfo() const {
        cout << "Name: " << name << ", Age: " << age << endl;
    }

    void setDetails(string n, int a) {
        name = n;
        age = a;
    }
};

void displayStudents(const Student* students, int size) {
    for (int i = 0; i < size; i++) {
        cout << " Student " << i + 1 << ": ";
        students[i].displayInfo();
    }
}

int main() {
    Student students[3] = {
        Student("Upin", 20), Student("Mei Mei", 22), Student("Jarjit" , 19)
    };

    Student* ptr = students;

    for (int i = 0; i < 3; i++){
        cout << "Student " << i + 1 << ": ";
        ptr->displayInfo();
        ptr++;
    }

    ptr = students;

    ptr->setDetails("Mail",21);

    cout << "\nAfter modifying the first student's details:\n";
    displayStudents(students,3);

    return 0;
}