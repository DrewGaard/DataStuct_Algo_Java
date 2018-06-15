package adt;

public class Counter {
	
	int counter = 0; 
	String counterStr;
	private String name = null;
	
	public Counter(String str) {
		this.name = str;
	}
	
	public void increment() {
		counter++;
	}
	
	public int getCurrentValue() {
		return counter;
	}
	
	public String toString() {
		counterStr = name + " " + counter;
		return counterStr;
	}
}
