package ds.hashtable;

public class App {
	
	public static void main(String[] args) {
		
		HashTable table = new HashTable(19);
		table.insert("Apple");
		table.insert("Microsoft");
		table.insert("Intel");
		table.insert("Facebook");
		table.insert("HP");
		table.insert("Compaq");
		
		
		
		System.out.println("-----------FIND ELEMENTS-----------");
		System.out.println(table.find("Apple"));
		System.out.println(table.find("Microsoft"));
		System.out.println(table.find("Intel"));
		System.out.println(table.find("HP"));
		System.out.println(table.find("Not in Table"));
		
		table.displayTable();
	
	}
}
