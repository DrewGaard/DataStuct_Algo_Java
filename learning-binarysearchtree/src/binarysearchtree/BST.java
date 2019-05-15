package binarysearchtree;

public class BST {
	
	public Node root;
	
	public void insert(int key, String value) {
		
		Node newNode = new Node(key, value);
		
		if(root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;
			
			while(true) {
				parent = current;
				if(key < current.key) {
					current = current.leftChild;
					if(current == null) { // It's parent is the leaf node
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if(current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
		
	}
	
	public Node findMin() {
		Node current = root;
		Node last = null;
		
		while(current != null) {
			last = current;
			current = current.leftChild;
		}
		return last;
	}
	
	public Node findMax() {
		Node current = root;
		Node last = null;
		
		while(current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}
	
	public boolean remove(int key) {
		
		Node currentNode = root;
		Node parentNode = root;
		
		boolean isLeftChild = false;
		
		//Searching to find node with the key to delete
		while(currentNode.key != key) {
			parentNode = currentNode;
			if(key < currentNode.key) {
				isLeftChild = true;
				currentNode = currentNode.leftChild;
			} else {
				currentNode = currentNode.rightChild;
				isLeftChild = false;
			}
			if(currentNode == null) {
				return false;
			}
		}
		
		// found the node
		Node nodeToDelete = currentNode;
		
		
		// if node is a leaf
		if(nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			if(nodeToDelete == root) {
				root = null;
			} else if(isLeftChild) {
				parentNode.leftChild = null;
			} else {
				parentNode.rightChild = null;
			}
		} else if(nodeToDelete.rightChild == null) { // if node has one child on the left
			if(nodeToDelete == root) {
				root = nodeToDelete.leftChild;
			} else if(isLeftChild) {
				parentNode.leftChild = nodeToDelete.leftChild;
			} else {
				parentNode.rightChild = nodeToDelete.leftChild;
			}
		} else if(nodeToDelete.leftChild == null) { // if node has one child that is on the right
			if(nodeToDelete == root) {
				root = nodeToDelete.rightChild;
			} else if(isLeftChild) {
				parentNode.leftChild = nodeToDelete.rightChild;
			} else {
				parentNode.rightChild = nodeToDelete.rightChild;
			}
		} else { // if node has two children
			Node successor = getSuccessor(nodeToDelete);
			
			// connect parent of nodeToDelete to successor instead
			if(nodeToDelete == root) {
				root = successor;
			} else if(isLeftChild){
				parentNode.leftChild = successor;
			} else {
				parentNode.rightChild = successor;
			}
			
			successor.leftChild = nodeToDelete.leftChild;
		}
		
		
		return true;
	}
	
	
	private Node getSuccessor(Node nodeToDelete) {
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;
		
		Node current = nodeToDelete.rightChild; // go to the right child
		
		while(current != null) { // start going left down the tree until node has no left child
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		
		// if successor is not a right child
		if(successor != nodeToDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToDelete.rightChild;
		}
		return successor;
	}
	
	
	public void displayTree(Node root) {
		Node current = root;
		
		System.out.println(current.key);
		
		
			getLeftNode(current);
			getRightNode(current);
		
		
		
		
		
//		if(current.leftChild != null) {
//			System.out.print(current.leftChild.key);
//			displayTree(current.leftChild);
//		}
//		
//		if(current.rightChild != null) {
//			System.out.print(current.rightChild.key);
//			displayTree(current.rightChild);
//		}
		
		
//		int treeHeight = 0;
//		
//		// get the height of the tree
//		while(current.leftChild != null) {
//			current = current.leftChild;
//			treeHeight++;
//		}
//		
//		// print the left side
//		
//		current = root;
//		
//		String spaces = "";
//		
//		
//		// print the root node
//		System.out.println(current);
//		
//		
//		
//		
//		
//		if(root == null) {
//			System.out.println("Empty Binary Tree.");
//		}
//		if(current.leftChild != null){
//			System.out.println(current.leftChild.key);
//			current = current.leftChild;
//		}
//		if(current.rightChild != null){
//			System.out.println(current.rightChild.key);
//			current = current.rightChild;
//		}
//		
//		System.out.println(current.key + current.leftChild.key + current.rightChild.key);
		

	}
	
	private Node getLeftNode(Node current) {
		if(current.leftChild != null) {
			System.out.print(current.leftChild.key);
			getLeftNode(current.leftChild);
		}
		return current;
	}
	
	private Node getRightNode(Node current) {
		if(current.rightChild != null) {
			System.out.print(current.rightChild.key);
			getRightNode(current.rightChild);
		}
		return current;
	}
	

	
}
