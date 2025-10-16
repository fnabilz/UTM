#include <iostream>
#include <fstream>
#include <string>

bool openFile(std::fstream &file, const std::string &filename, std::ios_base::openmode mode) {
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
        writeToTextFile(textFile, "I love coding.");
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
}
