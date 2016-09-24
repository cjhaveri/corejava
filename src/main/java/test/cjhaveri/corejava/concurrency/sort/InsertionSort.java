package test.cjhaveri.corejava.concurrency.sort;

import java.util.Arrays;

public class InsertionSort extends SortBase {

	public Integer[] insertionSort(Integer[] numbers) {
		
		// handle nulls
		if (numbers == null || numbers.length == 0) {
			return null;
		}

		printArray(numbers);
		
		// go through the list
		for (int i = 0; i < numbers.length; i++) {
			// for each element in the unsorted portion of the array
			int currentNumber = numbers[i];
			// numbers[0] -> numbers[i-1] is the sorted portion of the array
			for (int j = 0; j < i; j++) {
				// find the right place for it in the sorted portion of the
				// array
				if (numbers[j] > currentNumber) {
					// j is the spot where it needs to be inserted
					// slide everything from j to i one place over
					for (int k = i - 1; k >= j; k--) {
						numbers[k + 1] = numbers[k];
						numberOfOperations++;
					}//end k loop
					// insert it into the correct spot
					numbers[j] = currentNumber;
					//break out of the j loop
					break;
				}
			}//end j loop
		}//end i loop
		
		return Arrays.copyOf(numbers, numbers.length);
	}

	public static void main(String[] args) {
		InsertionSort is = new InsertionSort();
		Integer[] numbers = { 0, 4, 5, 1, -1, 3, 9, 0, 12, 2, 8, 4 };
		is.insertionSort(numbers);
		is.printArray(numbers);
		is.printNumberOfOperations();
	}

}
