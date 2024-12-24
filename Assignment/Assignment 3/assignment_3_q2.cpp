/*
    Assignment 3: Question 2
    Code by: Ahmad Fikri Nabil bin Zamri
    Matrics ID: A24CS0035
    Date: 23/12/2024
*/

#include <iostream>
#include <iomanip>
#include <fstream>
using namespace std;

void getInput();  // get input from input file
int calTotal(int array[]); // calculate total of values inside an array that is passed into the function
int getLowest(int array[]); // find the lowest value stored inside the array
int getHighest(int array[]); // find the highest value stored inside the array
void postOutput(int, int, int, float, float, float, int, int, int, int, int ,int, int, int, int); // send all the values and display the output into the output file

ifstream inFile; // to open input file
ofstream outFile; // to open output file

int i = 0; // use for loop
const int numUni = 20; // max number of university
int inUni[numUni], enrolUni[numUni], outUni[numUni]; // each array for intake, enrolment and output
string uniName[numUni]; // array to keep the university name

int main() {

    int totalIn = 0, totalEnrol = 0, totalOut = 0;
    float avgIn = 0.0, avgEnrol = 0.0, avgOut = 0.0;

    int lowestInId, lowestEnrolId, lowestOutId;
    int highestInId, highestEnrolId, highestOutId;

    int rangeIn = 0, rangeEnrol = 0, rangeOut = 0;

    getInput();

    totalIn = calTotal(inUni);
    totalEnrol = calTotal(enrolUni);
    totalOut = calTotal(outUni);
    avgIn = totalIn / 20.0;
    avgEnrol = totalEnrol / 20.0;
    avgOut = totalEnrol / 20.0;

    lowestInId = getLowest(inUni);
    lowestEnrolId = getLowest(enrolUni);
    lowestOutId = getLowest(outUni);
    highestInId = getHighest(inUni);
    highestEnrolId = getHighest(enrolUni);
    highestOutId = getHighest(outUni);

    rangeIn = inUni[highestInId] - inUni[lowestInId];
    rangeEnrol = enrolUni[highestEnrolId] - enrolUni[lowestEnrolId];
    rangeOut = outUni[highestOutId] - outUni[lowestOutId];

    postOutput(totalIn, totalEnrol, totalOut, avgIn, avgEnrol, avgOut, lowestInId, lowestEnrolId, lowestOutId, highestInId, highestEnrolId, highestOutId, rangeIn, rangeEnrol, rangeOut);

    return 0;
}

void getInput() {
    string var;
    int data1, data2, data3;

    inFile.open("input.txt");
    if (inFile) { // check if input file successfully opened
        i = -1;
        while (!inFile.eof()) { // read the input file line by line
            inFile >> var >> data1 >> data2 >> data3; // keep the value from the input file into a temporary variable
            ++i; // to start store the value in the array, we will start with i = 0
            uniName[i] = var;
            inUni[i] = data1;
            enrolUni[i] = data2;
            outUni[i] = data3;
        }
        inFile.close();
    }
    else {
        cout << "\nError: Failed to open input file.\n" << endl;
        inFile.close();
        exit(1);
    }
}

void postOutput(int totalIn, int totalEnrol, int totalOut, float avgIn, float avgEnrol, float avgOut, int lowestInId, int lowestEnrolId, int lowestOutId, int highestInId, int highestEnrolId, int highestOutId, int rangeIn, int rangeEnrol, int rangeOut) {

    outFile.open("output.txt");
    if (outFile) {
        outFile << "\n" << setw(55) << "NUMBER OF STUDENTS' INTAKE, ENROLMENT AND OUTPUT\n" << setw(44) << "IN PUBLIC UNIVERSITIES (2015)\n" << endl
                << "---------------------------------------------------------------" << endl
                << right << setw(12) << "UNIVERSITY" << setw(17) << "INTAKE" <<  setw(16) << "ENROLMENT" << setw(12) << "OUTPUT"  << endl
                << "---------------------------------------------------------------" << endl;
        for (i = 0; i < numUni; i++) {
            outFile << left << setw(5) << "" << setw(18) << uniName[i]
                    << right << setw(6) << inUni[i] << setw(14) << enrolUni[i] << setw(14) << outUni[i] << endl;
        }
        outFile << "---------------------------------------------------------------" << endl
                << left << setw(5) << "" << setw(18) << "TOTAL"
                << right << setw(6) << totalIn << setw(14) << totalEnrol << setw(14) << totalOut << endl
                << left << setw(5) << "" << setw(17) << "AVERAGE"
                << fixed << setprecision(2) 
                << right << setw(6) << avgIn << setw(14) << avgEnrol << setw(14) << avgOut << endl
                << "---------------------------------------------------------------" << endl
                << "\nTHE LOWEST NUMBER OF STUDENTS' INTAKE    = " << inUni[lowestInId] << " (" << uniName[lowestInId] << ")" << endl
                << "THE LOWEST NUMBER OF STUDENTS' ENROLMENT = " << enrolUni[lowestEnrolId] << " (" << uniName[lowestEnrolId] << ")" << endl
                << "THE LOWEST NUMBER OF STUDENTS' OUTPUT    = " << outUni[lowestOutId] << " (" << uniName[lowestOutId] << ")" << endl
                << "\nTHE HIGHEST NUMBER OF STUDENTS' INTAKE    = " << inUni[highestInId] << " (" << uniName[highestInId] << ")" << endl
                << "THE HIGHEST NUMBER OF STUDENTS' ENROLMENT = " << enrolUni[highestEnrolId] << " (" << uniName[highestEnrolId] << ")" << endl
                << "THE HIGHEST NUMBER OF STUDENTS' OUTPUT    = " << outUni[highestOutId] << " (" << uniName[highestOutId] << ")" << endl
                << "\nTHE RANGE OF NUMBER OF STUDENTS' INTAKE    = " << rangeIn << endl
                << "THE RANGE OF NUMBER OF STUDENTS' ENROLMENT = " << rangeEnrol << endl
                << "THE RANGE OF NUMBER OF STUDENTS' OUTPUT    = " << rangeOut << endl
                << "\n---------------------------------------------------------------" << endl;
        outFile.close();
        exit(1);
    }
    else  {
        cout << "Error: Failed to open output file." << endl;
        outFile.close();
        exit(1);
    }

}

int calTotal(int array[]) {

    int total = 0;

    for (i = 0; i < numUni; i++) {
        total = total + array[i];
    }

    return total;
}

int getLowest(int array[]) {
    int arrayIndex = 0;
    int lowest = array[arrayIndex];

    for (i = 0; i < numUni; i++) {
        if (array[i] < lowest) {
            arrayIndex = i;
            lowest = array[arrayIndex];
        }   
    }

    return arrayIndex;
}

int getHighest(int array[]) {
    int arrayIndex = 0;
    int highest = array[arrayIndex];

    for (i = 0; i < numUni; i++) {
        if (array[i] > highest) {
            arrayIndex = i;
            highest = array[arrayIndex];
        }   
    }

    return arrayIndex;
}