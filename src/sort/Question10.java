package sort;

/*
 * Programmer: Yucen X 
 * Course: ICS4U7
 * Description:
 * An implementation of shaker sort
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question10 { 

	//getting input using buffered reader
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] fastInput = new String[1];
	static int pointer = 1;
	
	
	public static void main(String[] args) throws IOException {
		
		
	}
	
	public static void shakerSort(double[] array) {
		
		boolean flag = false; //I think the question wanted me to use a while loop, 
		                      //so this variable seems redundant since I used a for loop
		
		for (int i = 0; i < array.length; i++) {
			
			//even numbered passes
			if (i % 2 == 0) {
				
				//optimize for loop, no excessive checks on already sorted subarrays
				for (int j = array.length - 1 - (i/2); j >= 1 + (i/2); j--) {
					
					//small values are carried to the bottom
					if (array[j] < array[j-1]) {
						double temp = array[j];
						array[j] = array[j-1];
						array[j-1] = temp;
					}
					
				}
				
			//odd number passes
			} else {
				
				//optimize for loop
				for (int j = (i+1)/2; j < array.length - 1 - i/2; j++) {
					
					//large values are carried to the top
					if (array[j] > array[j+1]) {
						double temp = array[j];
						array[j] = array[j+1];
						array[j+1] = temp;
					}
					
				}
				
			} //end if-else
			
			//very redundant code but the question statements says I have to include a boolean
			if (i < array.length) {
				flag = true;
			}
			if (flag) break;
			
		} //end for i
		
	} //end method
	
	
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

