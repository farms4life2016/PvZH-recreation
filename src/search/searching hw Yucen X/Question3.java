
/*
 * Yucen Xie
 * ICS4U7
 * A modified sequential search that makes it faster to search
 * for an item if that item is searched for more often
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Question3 { 

	//getting input using buffered reader
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] fastInput = new String[1];
	static int pointer = 1;
	
	
	public static void main(String[] args) throws IOException {
		
		//vars
		int[] arr = null;
		int input = 1; //reuse this variable to save memory
		
		//get input for array creation
		System.out.println("What is the length of the array?");
		input = nextInt();
		if (input <= 0) { //bad input
			System.out.println("Arrays with negative length or zero length are not allowed.\n"
					+ "Please restart the program and enter good data.");
			System.exit(0);
		}
		
		//create array and populate
		arr = new int[input];
		System.out.printf("Please enter %d integers to populate the array:%n", input);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = nextInt();
		}
		
		System.out.println("Your array initially looks like:\n" + Arrays.toString(arr));
		
		//loop until the user enters 0
		while (input != 0) {
			
			//get input
			System.out.println("Enter an integer to search for in your array (or enter 0 to quit the program):");
			input = nextInt();
		
			//break condition
			if (input == 0) break;
			
			//output new array
			if (seqSearchM(arr, input)) {
				System.out.println("Your array currently looks like:\n" + Arrays.toString(arr));
			} else {
				System.out.println("We could not find your number in your array. No elements were swapped.");
			}
			
		} //end while
		
		//bye bye message
		System.out.println("End of program. Your array ended up looking like:\n" + Arrays.toString(arr));
		
	}
	
	/*
	 * Part (c)
	 * This modification improves the efficiency of the sort if there is a single
	 * item that is constantly searched for. Since sequential search scans from
	 * one end of the array to the other, items placed at the starting end are checked 
	 * first. If the commonly searched-for item gets moved to the front
	 * of the array, less time is required to find the item in the array.
	 */
	
	/**
	 * Part (a)
	 * the method name stands for Sequential Search (Modified). This method
	 * only searches for the first occurrence of a specific value, instead
	 * of searching for every occurrence
	 * @param arr the array to search in
	 * @param target the specific value to search for
	 * @return whether or not we could find <code>target</code> in <code>arr</code>
	 */
	static boolean seqSearchM(int[] arr, int target) {
		
		boolean found = false;
		
		//search from index 0
		for (int i = 0; i < arr.length; i++) {
			
			//find target
			if (arr[i] == target) {
				found = true;
				if (i == 0) break; //can't swap if target is already at the front
				else {
					
					//swap otherwise
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
					break;
				}
			}
			
		} //end for
		
		return found;
		
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

