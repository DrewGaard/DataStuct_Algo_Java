package ds.doublylinkedlist;

public class DoublyLinkedList {
	private Node first;
	private Node last;
	
	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void insertFirst(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			last = newNode; // if empty, last will refer to the new Node being created
		} else {
			first.previous = newNode;
		}
		
		newNode.next = first; // the new node's next field will point to the old first
		this.first = newNode;
	}
	
	public void insertLast(int data) {
		Node newNode = new Node();
		newNode.data = data;
		
		if(isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode; // assign old last to newnode
			newNode.previous = last; // the old last will be the newnodes previous
		}
		
		this.last = newNode; // the linkedList's last field should point to the new node
	}
	
	// assume non-empty list
	public Node deleteFirst() {
		Node temp = first;
		if(first.next == null) { // there is only one item in the list
			last = null;
		} else {
			first.next.previous  = null;
		}
		
		first = first.next; // we are assigning the reference of the node following the old first node to the first field in the linkedList object
		return temp; // return the deleted old first node
	}
	
	public Node deleteLast() {
		Node temp = last;
		if(first.next == null) { // only one node in the list
			first = null;
		} else {
			last.previous.next = null; // the last node's previous node's next field will point to null
		}
		
		last = last.previous;
		return temp;
	}
	
	// assume non-empty list
	public boolean insertAfter(int key, int data) {
		Node current = first; // we start from the beginning of the list
		while(current.data != key) { // as long as we have not found the key in a particular node
			current = current.next;
			if(current ==  null) {
				return false;
			}
		}
		
		Node newNode = new Node();
		newNode.data = data;
		
		if(current == last) {
			current.next = null;
			last = newNode;
		} else {
			newNode.next = current.next; // newNode's last field should point to the node ahead of the current node
			current.next.previous = newNode; // the node ahead of current previous field should point to the new node
		}
		
		newNode.previous = current;
		current.next = newNode;
		
		return true;
	}
	
	// assume non-empty list
	public Node deleteKey(int key) {
		Node current = first; // start from the beginning
		while(current.data != key) {
			current = current.next;
			if(current == null) {
				return null;
			}
		}
		
		if(current == first) {
			first = current.next; // make the first field point to the node following current since current will be deleted
		} else {
			current.previous.next = current.next;
		}
		
		if(current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		
		return current;
	}
	
	public void displayForward() {
		System.out.println("List (first --> last): ");
		Node current = first; // start from the beginning
		while(current != null) {
			current.displayNode(); // call the display method of the node
			current = current.next; // move to the next node
		}
		System.out.println();
	}
	
	public void displayBackward() {
		System.out.println("List (last --> first): ");
		Node current = last; // start from the end
		while(current != null) {
			current.displayNode(); // call the display method of the node
			current = current.previous; // move to the next node
		}
		System.out.println();
	}
}
