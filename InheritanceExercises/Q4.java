package InheritanceExercises;

// Write a program to implement stack of integer numbers.

public class Q4 {
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(1);
		stack.displayStack();
		stack.push(2);
		stack.displayStack();
		stack.push(3);
		stack.displayStack();
		stack.pop();
		stack.displayStack();
	}
}

class Stack {
	private int arr[];
	private int top;
	private int size;
	
	Stack(int size) {
		arr = new int[size];
		this.size = size;
		top = -1;
	}
	
	// Insert an element to the top of the stack
	public void push(int element) {
		if(isFull()) {
			System.out.println("Overflow");
			System.exit(1);
		}
		System.out.println("Inserting " + element);
		arr[++top] = element;
	}
	
	// Remove the top element
	public int pop() {
		if(isEmpty()) {
			System.out.println("Empty");
			System.exit(1);
		}
		int element = arr[top];
		top--;
		System.out.println("Removing " + element);
		return element;
	}
	
	// Check if the stack is empty
	public Boolean isEmpty() {
		return top == -1;
	}
	
	// Check if the stack is full
	public Boolean isFull() {
		return top == this.size - 1;
	}
	
	// Print the stack
	public void displayStack() {
		for(int i = top; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}
}
