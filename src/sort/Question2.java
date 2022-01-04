package sort;

/*
 * Programmer: Yucen X 
 * Course: ICS4U7
 * Description:
 * Prompts the user for 10 strings and sorts them using selection sort.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Question2 { 

	//getting input using buffered reader
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] fastInput = new String[1];
	static int pointer = 1;
	
	
	public static void main(String[] args) throws IOException {
		
		//vars
		String[] input = new String[10];
		
		//get input
		System.out.println("Please enter ten strings, separated by newlines.");
		for (int i = 0; i < 10; i++) {
			input[i] = nextLine();
		}
		
		//time for selection sort 
		for (int i = 0; i < 10; i++) {
			String min = input[i];
			int index = i;
			
			//check rest of array for a larger value
			for (int j = i; j < 10; j++) {
				
				if (input[j].compareTo(min) < 0) {
					
					min = input[j];
					index = j;
					
				}
				
			} //end for
			
			//make swaps if necessary
			String temp = input[i];
			input[i] = input[index];
			input[index] = temp;
			
			System.out.println(Arrays.toString(input));
			
		}
		
		System.out.println("Done:");
		System.out.println(Arrays.toString(input));
		
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
