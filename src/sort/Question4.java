package sort;

/*
 * Programmer: Yucen X 
 * Course: ICS4U7
 * Description:
 * A modified selection sort that only sorts the last k values of an array in ascending order.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Question4 { 

	//getting input using buffered reader
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] fastInput = new String[1];
	static int pointer = 1;
	
	
	public static void main(String[] args) throws IOException {
		
		
		
	}
	
	public static String[] sortTopK(String[] input, int k) {
		
		//most of the code is similar to Q2
		
		//time for selection sort, but start at the end of the array
		//and only check up to the k-th element from the end
		for (int i = input.length-1; i > input.length-1-k; i--) {
			String max = input[i];
			int index = i;

			//check rest of array for a larger value
			for (int j = i; j >= 0; j--) {

				if (input[j].compareTo(max) > 0) {

					max = input[j];
					index = j;

				}

			} //end for

			//make swaps if necessary
			if (!max.equals(input[i])) {
				String temp = input[i];
				input[i] = input[index];
				input[index] = temp;

			}

		}
		
		return input;
		
	}
	
	
	/*
	 * Template functions
	 */
	
	/**
	 * Gets user input from the console.
	 * @return The double that the user inputted. 
	 * @throws IOException
	 */
	static double nextDouble() throws IOException {
		
		return Double.parseDouble(nextInput());
	}
	
	/**
	 * Gets user input from the console.
	 * @return The int that the user inputted. 
	 * @throws IOException
	 */
	static int nextInt() throws IOException {
		
		return Integer.parseInt(nextInput());
	}
	
	/**
	 * Gets user input from the console.
	 * @return The string that the user inputted. 
	 * @throws IOException
	 */
	static String nextString() throws IOException {
		
		return (nextInput());
	}
	
	
	/**
	 * Gets user input from the console.
	 * @return The boolean that the user inputted. 
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
