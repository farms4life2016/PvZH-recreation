package sort;

/*
 * Programmer: Yucen X 
 * Course: ICS4U7
 * Description:
 * Sorts an array of planet names using insertion sort.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Question6 { 

	//getting input using buffered reader
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] fastInput = new String[1];
	static int pointer = 1;
	
	
	public static void main(String[] args) throws IOException {
		
		//array
		String planets[] = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
		
		//insertion sort time
		for (int i = 1; i < planets.length; i++) {
			
			//assume that the array up to and excluding arr[i] is sorted
			//insert arr[i] into the correct place in the sorted subarray
			for (int j = i; j > 0; j--) {
				
				//swap if in wrong location
				if (planets[j].compareTo(planets[j-1]) < 0) {
					String temp = planets[j];
					planets[j] = planets[j-1];
					planets[j-1] = temp;
					
				//end loop if in correct location
				} else {
					break;
				}
				
			}
			
			//print out every pass
			System.out.println(Arrays.toString(planets));
			
		}
		
		//final answer
		System.out.println("Done:\n"+Arrays.toString(planets));
		
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
