

/*
 * Yucen Xie
 * ICS4U7
 * Creates an array of length 20, filled with random numbers. 
 * Then, the user enters a number and the program searches for it. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Question1 { 

	//getting input using buffered reader
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] fastInput = new String[1];
	static int pointer = 1;
	
	
	public static void main(String[] args) throws IOException {
		
		//vars
		int[] rng = null;
		int search = 0, lower = 0, upper = 1;
		List<Integer> indices = new ArrayList<>();
		
		//the problem statement did not specify the range of the random numbers
		//so we will let user decide
		System.out.println("Please specify the range of random numbers to be generated.\n"
				+ "Enter two integers a, b (where a < b) and the array will be populated with \n"
				+ "random integers in the interval [a, b].");
		lower = nextInt();
		upper = nextInt();
		
		//handle bad input
		if (lower >= upper) {
			System.out.println("You entered values such that a > b. Try again after restarting the program.");
			System.exit(0);
		}
		
		//create random array
		rng = new Random().ints(20L, lower, upper+1).toArray();
		
		System.out.println("Please enter a number to search for within this array:");
		search = nextInt();
		
		//sequential search
		for (int i = 0; i < 20; i++) {
			if (search == rng[i]) {
				indices.add(i); //thank you autowrapper 
			}
		}
		
		//output
		if (indices.isEmpty()) System.out.println("Your number is not in the array.");
		else {
			System.out.println("Your number appeared at following index/indices:");
			for (int i : indices) {
				System.out.print(i + " ");
			}
		}
		
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

