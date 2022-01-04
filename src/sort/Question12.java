package sort;

/*
 * Programmer: Yucen X 
 * Course: ICS4U7
 * Description:
 * A program that lets the user compare the time it takes for 3 different algorithms to sort an array of random ints.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Question12 { 

	//getting input using buffered reader
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[] fastInput = new String[1];
	static int pointer = 1;
	static long start = 0L, end = 0L;
	
	
	public static void main(String[] args) throws IOException {
		
		int[] arr = null;
		
		arr = randomArray();
		startTimer();
		selectionSort(arr);
		System.out.println("Time taken: " + endTimer() + " milliseconds.");
		System.out.println("(Press enter to start the next sort...)");
		nextLine();
		
		arr = randomArray();
		startTimer();
		bubbleSort(arr);
		System.out.println("Time taken: " + endTimer() + " milliseconds.");
		System.out.println("(Press enter to start the next sort...)");
		nextLine();
		
		arr = randomArray();
		startTimer();
		insertionSort(arr);
		System.out.println("Time taken: " + endTimer() + " milliseconds.");
		System.out.println("End of program.");
		
	}
	
	/**
	 * Generates an array of 1000 elements with random numbers
	 * from the interval [0, 500] and then prints out the first 100 
	 * elements to the console
	 * @return the array as specified above. 
	 */
	static int[] randomArray() {
		
		int[] arr = new Random().ints(1000, 0, 501).toArray();
		
		printFirst100(arr, "Unsorted Array:");
		
		return arr;
		
	}
	
	static void insertionSort(int[] arr) {
		
		//skip pass 1 cuz it does not modify the array
		for (int i = 1; i < arr.length - 1; i++) {
			
			//inserting arr[i] in the sorted subarray
			for (int j = i; j > 0; j--) {
				
				//break if already in correct place
				if (arr[j] >= arr[j-1]) break;
				else {
					
					//or else swap with adj element
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					
				}
				
			}
			
		} //end for
		
		printFirst100(arr, "Insertion Sorted Array:");
		
	}
	
	static void selectionSort(int[] arr) {
		
		//time for selection sort 
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int index = i;

			//check rest of array for a larger value
			for (int j = i; j < arr.length; j++) {

				if (arr[j] < min) {

					min = arr[j];
					index = j;

				}

			} //end for

			//make swaps if necessary
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;

		}

		printFirst100(arr, "Selection Sorted Array:");

	}
	
	static void bubbleSort(int[] arr) {
		
		boolean didSwap = true;
		
		//bubble sort time
		while (didSwap) {
			didSwap = false; //loop until array is sorted (no more swaps)
			
			for (int i = 0; i < arr.length-1; i++) {
				
				//check adjacent numbers
				if (arr[i] > arr[i+1]) {
					
					//make swap to bring larger numbers up
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					didSwap = true;
				}
			}
		} //end while
		
		printFirst100(arr, "Bubble Sorted Array:");
		
	}
	
	/**
	 * Starts the timer
	 */
	static void startTimer() {
		start = System.nanoTime();
	}
	
	/**
	 * Ends the timer
	 * @return the number of milliseconds between the call to {@code startTimer()} and this method.
	 */
	static double endTimer() {
		end = System.nanoTime();
		return (end - start)/1_000_000.0;
				
	}
	
	/**
	 * Prints the first 100 elements of an array,
	 * formatted in a nicely readable manner
	 * @param a the array to be printed
	 * @param text optional text that one can include before printing out the array
	 */
	static void printFirst100(int[] a, String text) {
		
		System.out.println(text);
		
		for (int i = 0; i < 100; i++) {
			System.out.printf("%4d", a[i]);
			if (i%10 == 9) System.out.println();
		}
		
		System.out.println();
		
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
