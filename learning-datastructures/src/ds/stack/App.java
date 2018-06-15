package ds.stack;

public class App {

	public static void main(String[] args) {
		//Stack theStack = new Stack(3);
		
		System.out.println(reverseString("Hello"));
		
	}
	
	public static String reverseString(String str) {
		Stack theStack = new Stack(str.length());
		
		for(int j = 0; j < str.length(); j++) {
			char ch = str.charAt(j);
			theStack.push(ch);
		}
		
		
		String result = "";
		while(!theStack.isEmpty()) {
			char value = theStack.pop();
			result = result + value;
		}
		
		return result;
	}
}
