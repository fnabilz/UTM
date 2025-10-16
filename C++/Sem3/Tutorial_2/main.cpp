#include <iostream>
#include <fstream>
#include <string>

// Function to open a file with specified mode (text, binary, or random access)
bool openFile(std::fstream &file, const std::string &filename, std::ios_base::openmode mode) {
    file.open(filename, mode);
    if (!file) {
        std::cerr << "Error opening file: " << filename << std::endl;
        return false;
    }
    return true;
}

// Function to write to the file (for text files)
void writeToTextFile(std::fstream &file, const std::string &content) {
    if (file) {
        file << content << std::endl;
    } else {
        std::cerr << "File not open for writing (text)!" << std::endl;
    }
}

// Function to read from a text file
void readFromTextFile(std::fstream &file) {
    if (file) {
        file.seekg(0, std::ios::beg); // Move the file pointer to the beginning
        std::string line;
        while (std::getline(file, line)) {
            std::cout << line << std::endl;
        }
    } else {
        std::cerr << "File not open for reading (text)!" << std::endl;
    }
}

// Function to write to a binary file
void writeToBinaryFile(std::fstream &file, int number) {
    if (file) {
        file.write(reinterpret_cast<const char*>(&number), sizeof(number));
    } else {
        std::cerr << "File not open for writing (binary)!" << std::endl;
    }
}

// Function to read from a binary file
void readFromBinaryFile(std::fstream &file) {
    if (file) {
        file.seekg(0, std::ios::beg); // Move the file pointer to the beginning
        int number;
        while (file.read(reinterpret_cast<char*>(&number), sizeof(number))) {
            std::cout << "Read number: " << number << std::endl;
        }
    } else {
        std::cerr << "File not open for reading (binary)!" << std::endl;
    }
}

// Function for random access: write at a specific position
void writeToRandomAccessFile(std::fstream &file, int position, int value) {
    if (file) {
        file.seekp(position * sizeof(value), std::ios::beg);
        file.write(reinterpret_cast<const char*>(&value), sizeof(value));
    } else {
        std::cerr << "File not open for random access writing!" << std::endl;
    }
}

// Function for random access: read from a specific position
void readFromRandomAccessFile(std::fstream &file, int position) {
    if (file) {
        int value;
        file.seekg(position * sizeof(value), std::ios::beg);
        if (file.read(reinterpret_cast<char*>(&value), sizeof(value))) {
            std::cout << "Read value at position " << position << ": " << value << std::endl;
        } else {
            std::cerr << "Error reading at position " << position << std::endl;
        }
    } else {
        std::cerr << "File not open for random access reading!" << std::endl;
    }
}

// Function to close the file
void closeFile(std::fstream &file) {
    if (file) {
        file.close();
    }
}

int main() {
    std::fstream textFile, binaryFile, randomAccessFile;
    std::string textFilename = "C:\\Users\\User\\Documents\\Coding\\UTM\\C++\\Sem3\\Tutorial_2\\textfile.txt";
    std::string binaryFilename = "C:\\Users\\User\\Documents\\Coding\\UTM\\C++\\Sem3\\Tutorial_2\\binaryfile.bin";
    std::string randomAccessFilename = "C:\\Users\\User\\Documents\\Coding\\UTM\\C++\\Sem3\\Tutorial_2\\randomaccessfile.bin";

    // Open and write to a text file
    if (openFile(textFile, textFilename, std::ios::out | std::ios::app)) {
        writeToTextFile(textFile, "I love coding.");
        closeFile(textFile);
    }

    // Open and read from a text file
    if (openFile(textFile, textFilename, std::ios::in)) {
        std::cout << "\nReading from text file:\n";
        readFromTextFile(textFile);
        closeFile(textFile);
    }

    // Open and write to a binary file
    if (openFile(binaryFile, binaryFilename, std::ios::out | std::ios::binary | std::ios::app)) {
        writeToBinaryFile(binaryFile, 123);
        writeToBinaryFile(binaryFile, 456);
        closeFile(binaryFile);
    }

    // Open and read from a binary file
    if (openFile(binaryFile, binaryFilename, std::ios::in | std::ios::binary)) {
        std::cout << "\nReading from binary file:\n";
        readFromBinaryFile(binaryFile);
        closeFile(binaryFile);
    }

    // Open and write to a random access file
    if (openFile(randomAccessFile, randomAccessFilename, std::ios::in | std::ios::out | std::ios::binary | std::ios::app)) {
        writeToRandomAccessFile(randomAccessFile, 0, 1000); // Write 1000 at position 0
        writeToRandomAccessFile(randomAccessFile, 1, 2000); // Write 2000 at position 1
        closeFile(randomAccessFile);
    }

    // Open and read from a specific position in the random access file
    if (openFile(randomAccessFile, randomAccessFilename, std::ios::in | std::ios::binary)) {
        std::cout << "\nReading from random access file:\n";
        readFromRandomAccessFile(randomAccessFile, 0); // Read value at position 0
        readFromRandomAccessFile(randomAccessFile, 1); // Read value at position 1
        closeFile(randomAccessFile);
    }

    return 0;
}


/*bool openFile(std::fstream &file, const std::string &filename, std::ios_base::openmode mode) {
    file.open(filename, mode);
    if (!file) {
        std::cerr << "Error opening file: " << filename << std::endl;
        return false;
    }
    return true;
}

void writeToTextFile(std::fstream &file, const std::string &content) {
    if (file) {
        file << content << std::endl;
    } else {
        std::cerr << "File not open for writing (text)!" << std::endl;
    }
}

void readFromTextFile(std::fstream &file) {
    if (file) {
        file.seekg(0, std::ios::beg);
        std::string line;
        while (std::getline(file, line)) {
            std::cout << line << std::endl;
        }
    } else {
        std::cerr << "File not open for reading (text)!" << std::endl;
    }
}

void writeToBinaryFile(std::fstream &file, int number) {
    if (file) {
        file.write(reinterpret_cast<const char*>(&number), sizeof(number));
    } else {
        std::cerr << "File not open for writing (binary)!" << std::endl;
    }
}

void readFromBinaryFile(std::fstream &file) {
    if (file) {
        file.seekg(0, std::ios::beg);
        int number;
        while (file.read(reinterpret_cast<char*>(&number), sizeof(number))) {
            std::cout << "Read number: " << number << std::endl;
        }
    } else {
        std::cerr << "File not open for reading (binary)!" << std::endl;
    }
}

void writeToRandomAccessFile(std::fstream &file, int position, int value) {
    if (file) {
        file.seekp(position * sizeof(value), std::ios::beg);
        file.write(reinterpret_cast<const char*>(&value), sizeof(value));
    } else {
        std::cerr << "File not open for random access writing!" << std::endl;
    }
}


void readFromRandomAccessFile(std::fstream &file, int position) {
    if (file) {
        int value;
        file.seekg(position * sizeof(value), std::ios::beg);
        if (file.read(reinterpret_cast<char*>(&value), sizeof(value))) {
            std::cout << "Read value at position " << position << ": " << value << std::endl;
        } else {
            std::cerr << "Error reading at position " << position << std::endl;
        }
    } else {
        std::cerr << "File not open for random access reading!" << std::endl;
    }
}

void closeFile(std::fstream &file) {
    if (file) {
        file.close();
    }
}

int main() {
    std::fstream textFile, binaryFile, randomAccessFile;
    std::string textFilename = "textfile.txt";
    std::string binaryFilename = "binaryfile.bin";
    std::string randomAccessFilename = "randomaccessfile.bin";

    if (openFile(textFile, textFilename, std::ios::out | std::ios::app)) {
        //writeToTextFile(textFile, "I love coding.");
        closeFile(textFile);
    }

    if (openFile(textFile, textFilename, std::ios::in)) {
        std::cout << "\nReading from text file:\n";
        readFromTextFile(textFile);
        closeFile(textFile);
    }

    if (openFile(binaryFile, binaryFilename, std::ios::out | std::ios::binary | std::ios::app)) {
        writeToBinaryFile(binaryFile, 123);
        writeToBinaryFile(binaryFile, 456);
        closeFile(binaryFile);
    }

    if (openFile(binaryFile, binaryFilename, std::ios::in | std::ios::binary)) {
        std::cout << "\nReading from binary file:\n";
        readFromBinaryFile(binaryFile);
        closeFile(binaryFile);
    }

    if (openFile(randomAccessFile, randomAccessFilename, std::ios::in | std::ios::out | std::ios::binary | std::ios::app)) {
        writeToRandomAccessFile(randomAccessFile, 0, 1000);
        writeToRandomAccessFile(randomAccessFile, 1, 2000);
        closeFile(randomAccessFile);
    }

     if (openFile(randomAccessFile, randomAccessFilename, std::ios::in | std::ios::binary)) {
        std::cout << "\nReading from random access file:\n";
        readFromRandomAccessFile(randomAccessFile, 0);
        readFromRandomAccessFile(randomAccessFile, 1);
        closeFile(randomAccessFile);
    }

    return 0;
}**/
