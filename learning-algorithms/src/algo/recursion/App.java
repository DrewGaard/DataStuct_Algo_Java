package algo.recursion;

public class App {

	public static void main(String[] args) {
		reduceByOne(10);

	}
	
	public static void reduceByOne(int n) {
		if(n >= 0) {
			reduceByOne(n-1);
		}
		
		System.out.println("Completed Call: " + n);
	}
	
	public static int recursiveLinearSearch(int [] a, int i, int x) {
		int n = a.length - 1;
		if(i > n) {
			return -1;
		} else if(a[i] == x) {
			return i;
		} else {
			return recursiveLinearSearch(a, i+1, x);
		}
	}
}
