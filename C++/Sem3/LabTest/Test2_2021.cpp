#include <iostream>
#include <cstdlib>

using namespace std;

struct node{
	int value;
	node *next;
};

class Stack{
	public:
		Stack();
		void push(int v);
		void pop();
		bool isEmpty();
		int stackTop();
	
	private:
		node *top;
};

Stack::Stack(){
	top=NULL;
}

bool Stack::isEmpty(){
	return (top== NULL);
}

void Stack::push(int v){
	node *nn = new node;
	nn->value = v;
	nn->next = top;
	top = nn;
}

void Stack::pop(){
	if (isEmpty()){
		cout<<"\nEmpty stack, unable to pop";
	} else {
		node *delNode = top;
		top = top->next;
		delete (delNode);
	}
}

int Stack::stackTop(){
	if (isEmpty()){
		cout<<"\nEmpty stack, unable to stackTop";
	} else {
		return top->value;
	}
}

void Q2a_answer(){
    string exp = "897-/2*";  
	cout<<"\nQ2a_answer";
	//Answer your Task 1 here	- print/cout the exp
	cout << "\nexp is : " << exp << endl;
	//Refer Task 1 for expected output - 2 marks
}

void Q2b_answer(){
    string exp = "897-/2*";  
	cout<<"\nQ2b_answer";
	//Answer your Task 2 here	- Create Stack s. Check s is empty or not
	cout << "\nexp is : " << exp << endl;
	Stack s;
	cout << endl << "Create a stack s" << endl
		<< "And test empty or not" << endl
		<< "Is the stack empty ? : " << s.isEmpty() << endl;
	//Refer Task 2 for expected output - 3 marks
}

void Q2c_answer(){
    string exp = "897-/2*";  
	cout<<"\nQ2c_answer";
	
	//You can use this code as reference, for tokenizing expression into individual character 
	cout << "\nexp is : " << exp << endl;
	for (int i=0; i<exp.length(); i++){
		if (isdigit(exp[i])){
			cout<<"\nexp["<<i<<"] : "<<exp[i]-'0';
		} else {
			//exp[i] is an operator. Do nothing
		}
	}
	//Answer your Task 3 here	- Create stack s. Check s is empty or not
	Stack s;
	cout << "\n\nCreate a stack s" << endl
		<< "And test empty or not" << endl
		<< "Is the stack empty ? : " << s.isEmpty() << endl;
	//Scan through the expression. If the character is operand then push 
	//it into stack s. If character is operator, just ignore.
	cout << "Push every operand into stack s" << endl 
		<< "Operands stored in stack s" << endl;
	for (int i=0; i<exp.length(); i++){
		if (isdigit(exp[i])){
			s.push(exp[i]-'0');
		} else {
			//exp[i] is an operator. Do nothing
		}
	}
	//Display the values stored in stack s
	while (!s.isEmpty()) {
		cout << s.stackTop() << endl;
		s.pop();
	}
	//Refer Task 3 for expected output - 8 marks
}

void Q2d_answer(){
    string exp = "897-/2*";  
	cout<<"\nQ2d_answer";
	
	//Answer your Task 4 here - Create Stack s. Check s is empty or not.
	//Scan through until end of the expression. If the character is operand then 
	//push it into stack s. If character is operator, get 2 operands from the stack s, 
	//perform the math operation, push back the result into stack s.
	//Finally, get and display the value stored by stack s. This is the final answer.

	cout << "\nexp is : " << exp << endl;
	//Answer your Task 3 here	- Create stack s. Check s is empty or not
	Stack s;
	cout << "\n\nCreate a stack s" << endl
		<< "And test empty or not" << endl
		<< "Is the stack empty ? : " << s.isEmpty() << endl;
	//Scan through the expression. If the character is operand then push 
	//it into stack s. If character is operator, just ignore.
	cout << "Push every operand into stack s" << endl 
		<< "Operands stored in stack s" << endl;
	for (int i=0; i<exp.length(); i++){
		if (isdigit(exp[i])){
			s.push(exp[i]-'0');
		} else {
			int operand1 = s.stackTop();
			s.pop();
			int operand2 = s.stackTop();
			s.pop();
			int sum = 0;
			if (exp[i] == '-') {
				sum = operand2 - operand1;
			}
			else if (exp[i] == '/') {
				sum = operand2 / operand1;
			}
			else {
				sum = operand2 * operand1;
			}
			s.push(sum);
			//exp[i] is an operator. Do nothing
		}
	}
	//Display the values stored in stack s
	cout << "\nFinal Answer is : " << s.stackTop();

	//Refer Task 4 for expected output - 12 marks
}

void Q2e_answer(){
    string exp;
	cout <<"\nQ2e_answer";

	cout << "\nPlease write the Postfix Expression, then press enter when done " << endl;
	cin >> exp;
	
	cout << "\nexp is : " << exp << endl;
	cout << "Length is : " << exp.length() << endl;

	cout << "\nCreate a stack s" << endl
		<< "Push every operand into stack s" << endl;

	Stack s;
	for (int i = 0; i < exp.length(); i++) {

		if (isdigit(exp[i])) {

			s.push(exp[i]-'0');

		}
		else {

			int operand1 = s.stackTop();
			s.pop();
			int operand2 = s.stackTop();
			s.pop();
			int sum = 0;
			if (exp[i] == '+') {
				sum = operand2 + operand1;
			}
			else if (exp[i] == '-') {
				sum = operand2 - operand1;
			}
			else if (exp[i] == '/') {
				sum = operand2 / operand1;
			}
			else {
				sum = operand2 * operand1;
			}
			s.push(sum);

		}

	}

	cout << "\nFinal Answer is : " << s.stackTop() << endl;
		
	
	//Answer your Task 5 here
	//Stack application - evaluate the postfix expression
	//Read the postfix expression from the user using keyboard
	//Evaluate and display the final result
	//Refer Task 5 for expected output - 5 marks
}


int main(){
	char selection;
	while (true){
		cout<<"\nAnswer for Question 'a' 'b' 'c' 'd' 'e' 'x' for exit\nSelection : ";
		cin>>selection;
		//system("CLS");
		switch (selection){
			case 'a': Q2a_answer(); break;
			case 'b': Q2b_answer(); break;
			case 'c': Q2c_answer(); break;
			case 'd': Q2d_answer(); break;
			case 'e': Q2e_answer(); break;
			case 'x': cout<<"\nThank You. Bye";exit(0); break;
			default : cout<<"\nInvalid selection";
		}
	}
	return 0;
}

