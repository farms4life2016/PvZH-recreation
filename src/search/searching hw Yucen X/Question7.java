
/*
 * Yucen Xie
 * ICS4U7
 * A special type of binary search. See the method lowerBinarySearch(...) 
 * for more details.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Question7 { 

	//getting input using buffered reader
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] fastInput = new String[1];
	static int pointer = 1;
	
	
	public static void main(String[] args) throws IOException {
		
		
	}
	
	/**
	 * Modified binary search
	 * @param arr A pre-sorted array in ascending order
	 * @param target The value to be searched for
	 * @return Returns the index of {@code target} if found.
	 * If not found, returns the index of the number that is closest
	 * to {@code target}. If there is a tie, the smaller index
	 * is returned
	 */
	static int lowerBinarySearch(int[] arr, int target) {
		
		int high = arr.length, low = 0, mid = 1;
		
		//if target is outside of range, return respective end point
		if (target >= arr[arr.length-1]) return arr.length-1;
		else if (target <= arr[0]) return 0;
		
		while (low <= high) {
			mid = (high + low)/2;
			
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] < target) low = mid + 1;
			else high = mid - 1;
		}
		
		
		int x = Math.abs(target - arr[low]);
		int y = Math.abs(  target - arr[high] );
		
		if (x < y) return low;
		else return high;
		
	}
	
	
	/*
	 * Template functions
	 */
	
	/**
	 * Gets user input from the console.
	 * @return The double that the user inputed. 
	 * @throws IOException
	 */
	static double nextDouble() throws IOException {
		
		return Double.parseDouble(nextInput());
	}
	
	/**
	 * Gets user input from the console.
	 * @return The int that the user inputed. 
	 * @throws IOException
	 */
	static int nextInt() throws IOException {
		
		return Integer.parseInt(nextInput());
	}
	
	/**
	 * Gets user input from the console.
	 * @return The string that the user inputed. 
	 * @throws IOException
	 */
	static String nextString() throws IOException {
		
		return (nextInput());
	}
	
	
	/**
	 * Gets user input from the console.
	 * @return The boolean that the user inputed. 
	 * @throws IOException
	 */
	static boolean nextBoolean() throws IOException {
		
		return Boolean.parseBoolean(nextInput());
		
	}
	
	/**
	 * a shorthand for <code>br.readLine()</code>
	 * @return reads the next line from the console
	 * @throws IOException
	 */
	static String nextLine() throws IOException {
		return br.readLine();
	}
	
	
	/**
	 * My replacement for StringTokenizer. Essentially, the program reads an entire line from the input
	 * and splits the input into individual "words." Calling this function will return the next
	 * word from the input as a String. When there are no more words left on that line, the program
	 * will read the next line of input and perform the same process.
	 * @return 
	 * @throws IOException
	 */
	private static String nextInput() throws IOException {
		
		if (pointer == fastInput.length) {
			pointer = 0;
			fastInput = br.readLine().trim().split(" ");
			
		} 
		
		pointer++;
		return fastInput[pointer-1];
		
	}
	
}

