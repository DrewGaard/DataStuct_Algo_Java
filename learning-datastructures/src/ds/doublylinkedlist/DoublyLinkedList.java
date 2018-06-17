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
			last.next.previous = null; // the last node's previous node's next field will point to null
		}
		
		last = last.previous;
		return temp;
	}
}
