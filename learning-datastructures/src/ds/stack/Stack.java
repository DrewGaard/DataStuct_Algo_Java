package ds.stack;

public class Stack {
	
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public Stack(int size) {
		this.maxSize = size;
		this.stackArray = new char[maxSize];
		this.top = -1;
	}

	public void push(char j) {
		if(top < maxSize - 1) {
			top++;
			stackArray[top] = j;
		}
		else {
			System.out.println("You're attempting to add too many items to the stack!");
		}
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("The stack is already empty");
			return 'n';
		}
		else {
			int old_top = top;
			top--;
			return stackArray[old_top];
		}
	}
	
	public char peak() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (maxSize-1 == top);
	}
}
