package binarysearchtree;

public class Application {
	
	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(10, "Ten");
		tree.insert(20, "Twenty");
		tree.insert(15, "Fifteen");
		
		
		System.out.println("The minimum value is: " + tree.findMin().value);
		
		System.out.println("The maximum value is: " + tree.findMax().value);
	}
}
