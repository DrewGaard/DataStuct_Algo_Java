package ds.queue;

public class Queue {
	
	private int maxSize; // initializes the set number of slots
	private long[] queArray; //slots to main the data
	private int front; //the index position for the element in the front
	private int rear; //the index position for the element at the back of the line
	private int nItems; //number of items in the queue
	
	public Queue(int size) {
		this.maxSize = size;
		this.queArray = new long[size];
		front = 0; //index position of the first slot of the array
		rear = -1; //there is no item in the array yet to be considered the last item
		nItems = 0; //counter to maintain the number of items in our queue - none yet
	}
	
	public void insert(long j) {
		rear++;
		queArray[rear] = j;
		nItems++;
	}
	
	public void remove() { //remove item from the front of the queue
		long temp = queArray[front];
		front++;
		if(front == maxSize) {
			front = 0; //set front back to 0 so we can utilize the entire array again
		}
		nItems --;
		return temp;
	}
	
	public void view() {
		System.out.print("[ ");
		for(int i = 0; i < queArray.length; i++) {
			System.out.print(queArray[i]+ " ");
		}
		System.out.println("]");
	}
}
