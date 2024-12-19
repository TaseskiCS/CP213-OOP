package cp213;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Arrays Lab task methods.
 *
 * @author
 * @version 2022-01-25
 */
public class ArraysTest {

    /**
     * Tests arrays.
     *
     * @param args unused default parameter
     */
    public static void main(final String[] args) {
	System.out.println("Task 1");
	System.out.println(ArraysTest.task1());
	System.out.println("Task 2");
	System.out.println(ArraysTest.task2());
	System.out.println("Task 3");
	System.out.println(ArraysTest.task3());
	System.out.println("Task 4");
	System.out.println(ArraysTest.task4());
	System.out.println("Task 5");
	System.out.println(Arrays.toString(ArraysTest.task5()));
    }

    /**
     * Print the contents of the arrays first and second using a standard for loop.
     *
     * @return true if second contains the same values as first, false otherwise
     */
    public static boolean task1() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[] second = first;

	System.out.println("Values in first:");
	for (int i = 0; i < first.length; i++) {
	    System.out.println(first[i]);
	}
	System.out.println("Values in second:");
	for (int i = 0; i < second.length; i++) {
	    System.out.println(second[i]);
	}

	return true; // Since both arrays reference the same object.
    }

    /**
     * Double the contents of the array first with a standard for loop.
     *
     * @return true if second contains the same values as first, false otherwise
     */
    public static boolean task2() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[] second = first;

	// Double the contents of the first array
	for (int i = 0; i < first.length; i++) {
	    first[i] = first[i] * 2;
	}

	System.out.println("Values in first after doubling:");
	for (int i = 0; i < first.length; i++) {
	    System.out.println(first[i]);
	}

	System.out.println("Values in second after first is doubled:");
	for (int i = 0; i < second.length; i++) {
	    System.out.println(second[i]);
	}

	// Check if second has been updated (since second references the same array as
	// first)
	for (int i = 0; i < first.length; i++) {
	    if (first[i] != second[i]) {
		return false; // The contents differ
	    }
	}

	return true; // Both arrays should be the same since they reference the same memory location
    }

    /**
     * Double the contents of the array first with an enhanced for loop.
     *
     * @return true if the values in first are permanently changed, false otherwise
     */
    public static boolean task3() {
	final int[] first = { 1, 3, 5, 7, 9 };

	// Attempting to double the contents of the first array using an enhanced for
	// loop
	for (int value : first) {
	    value = value * 2; // This will not affect the original array
	}

	System.out.println("Values in first after attempting to double with enhanced for loop:");
	for (int i = 0; i < first.length; i++) {
	    System.out.println(first[i]);
	}

	// Check if the values of first were changed
	for (int i = 0; i < first.length; i++) {
	    if (first[i] != (i * 2) + 1) { // The original values are 1, 3, 5, 7, 9
		return true; // If any value was changed, return true
	    }
	}

	return false; // If all values are the same, return false (no change)
    }

    /**
     * Attempt to assign the array first to a row of the 2D array third.
     *
     * @return true if this is allowed, false otherwise
     */
    public static boolean task4() {
	final int[] first = { 1, 3, 5, 7, 9 };
	final int[][] third = new int[2][first.length]; // Create a 2D array with the same second dimension length as
							// 'first'

	// Assign the entire 'first' array to one of the rows of 'third'
	third[0] = first;

	System.out.println("Values in third[0]:");
	for (int i = 0; i < third[0].length; i++) {
	    System.out.println(third[0][i]);
	}

	// Since assigning an entire array is valid, return true
	return true;
    }

    /**
     * Assign the values 0 through 9 to an Integer ArrayList.
     *
     * @return the contents of the ArrayList as an Integer[] array.
     */
    public static Integer[] task5() {
	final ArrayList<Integer> values = new ArrayList<>();

	// Add values 0 through 9 to the ArrayList
	for (int i = 0; i < 10; i++) {
	    values.add(i);
	}

	// Convert the ArrayList to an array of Integer
	Integer[] valuesArray = values.toArray(new Integer[0]);

	// Return the array
	return valuesArray;
    }

}
