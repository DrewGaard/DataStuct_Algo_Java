package linkedlists;

public class App {

	public static void main(String[] args) {
		Node nodeA = new Node();
		nodeA.nodeData = 4;
		
		Node nodeB = new Node();
		nodeB.nodeData = 3;
		
		Node nodeC = new Node();
		nodeB.nodeData = 7;
		
		Node nodeD = new Node();
		nodeB.nodeData = 8;
		
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		
		System.out.println(listLength(nodeA)); // 4
		System.out.println(listLength(nodeB)); // 3
	}
	
	public static int listLength(Node aNode) {
		int length = 0;
		Node curNode = aNode;
		while(curNode != null)
		{
			curNode = curNode.next;
			length++;
		}
		return length;
	}
}
