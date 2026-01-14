#include <iostream>
using namespace std;

// ====== BST Node Definition ====== 
struct Node { 
    int data; 
    Node* left; 
    Node* right; 
}; 
 
// ====== Function Prototypes ====== 
Node* createNode(int value); 
Node* insert(Node* root, int value); 
Node* deleteNode(Node* root, int key); 
bool search(Node* root, int key); 
void inorder(Node* root); 
 
// ====== MAIN FUNCTION ====== 
int main() { 
    Node* root = nullptr; 
 
    // Step 1: Build the initial BST 
    int initialValues[] = {20, 10, 5, 8, 9, 15, 12, 13, 30, 25, 40, 35, 45}; 
    for (int v : initialValues) { 
        root = insert(root, v); 
    } 
 
    cout << "Initial BST (Inorder): "; 
    inorder(root); 
    cout << endl; 
 
    // Step 2: Insert additional values 
    int insertValues[] = {18, 16, 19, 33, 43}; 
    for (int v : insertValues) { 
        root = insert(root, v); 
    } 
 
    cout << "BST after insertions (Inorder): "; 
    inorder(root); 
    cout << endl; 
 
    // Step 3: Delete nodes in sequence 
    int deleteValues[] = {25, 20, 10}; 
    for (int v : deleteValues) { 
        root = deleteNode(root, v); 
        cout << "BST after deleting " << v << " (Inorder): "; 
        inorder(root); 
        cout << endl; 
    } 
 
    // Step 4: Retrieve values 
    cout << "Search 40: " << (search(root, 40) ? "Found" : "Not Found") << endl; 
    cout << "Search 50: " << (search(root, 50) ? "Found" : "Not Found") << endl; 
 
    return 0; 
} 
 
// ====== Function Definitions ====== 
// TODO: Implement createNode() 
Node* createNode(int value) {
    Node* newNode = new Node();
    newNode->data = value;
    newNode->left = nullptr;
    newNode->right = nullptr;
    //cout << value << " ";
    return newNode;
}

// TODO: Implement insert() 
Node* insert(Node* root, int value) {
    if (root == nullptr)
        return createNode(value);
    else if (value < root->data) {
        root->left = insert(root->left, value);
        return root;
    }
    else {
        root->right = insert(root->right, value);
        return root;
    }
}

// TODO: Implement deleteNode() 
Node* deleteNode(Node* root, int key) {
    if (root == nullptr)
        return root;

    if (key < root->data)
        root->left = deleteNode(root->left, key);
    else if (key > root->data) 
        root->right = deleteNode(root->right, key);
    else {
        if (root->left == nullptr) {
            Node* tempNode = root->right;
            delete root;
            return tempNode;
        }
        if (root->right == nullptr) {
            Node* tempNode = root->left;
            delete root;
            return tempNode;
        }

        Node* successor = root->right;
        while (successor != nullptr && successor->left != nullptr) 
            successor = successor->left;
        root->data = successor->data;
        root->right = deleteNode(root->right, successor->data);
    }

    return root;
}


// TODO: Implement search() 
bool search(Node* root, int key) {
    if (root != nullptr) {
        if (key == root->data)
            return true;
        else if (key < root->data) 
            return search(root->left, key);
        else
            return search(root->right, key);
    }
   return false;
}


// TODO: Implement inorder()
void inorder(Node* root) {
    if (root != nullptr) {
        inorder(root->left);
        cout << root->data << " ";
        inorder(root->right);
    }
}