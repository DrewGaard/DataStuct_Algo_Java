package algo.quicksort;
import java.util.Arrays;

public class App {
	
	public static void main(String[] args) {
		int[] inputArray = {12, 81, 74, 43, 1098, 0, 8, 92, 17, 754, 912, 0, 6, 4};
		quickSort(inputArray, 0, inputArray.length-1);
		
		System.out.println(Arrays.toString(inputArray));
	}
	
	
	public static void quickSort(int [] inputArray, int start, int end) {
		if(start < end) {
			int q = Partition(inputArray, start, end); // index position of the correctly placed value in the array 
			quickSort(inputArray, start, q-1); // sorts the left half of the range
			quickSort(inputArray, q+1, end); // sorts the right half of the range
		}
	}
	
	public static int Partition(int [] inputArray, int start, int end) {
		int x = inputArray[end];
		
		int i = start - 1;
		
		for(int j = start; j <= end - 1; j++) {
			if(inputArray[j] <= x) {
				i = i + 1;
				// we are swapping below
				int placeHolder = inputArray[i];
				inputArray[i] = inputArray[j];
				inputArray[j] = placeHolder;
			}
		}
		// put the pivot value (x) in the correct slot next
		int placeHolder = inputArray[end];
		inputArray[end] = inputArray[i + 1];
		inputArray[i + 1] = placeHolder;
		return i + 1;
	}
}
