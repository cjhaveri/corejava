package test.cjhaveri.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {

	private int numberOfOperations = 0;

	public void printArray(Integer[] numbers) {
		System.out.println("Array size: " + numbers.length + ", Current Array: " + Arrays.toString(numbers));
	}

	public void printNumberOfOperations() {
		System.out.println("Number of operations: " + numberOfOperations);
	}

	private void printPivot(int pivotNumber, Integer[] numbers) {
		System.out.println("Picked pivot as: " + pivotNumber + ", in Array: " + Arrays.toString(numbers));
	}

	public Integer[] quickSort(Integer[] numbers) {

		// 0a. Handle empty or nulls
		if (numbers == null || numbers.length == 0) {
			return null;
		}

		// 1. pick an index in the array
		int pivotNumber = numbers[numbers.length - 1];
		//print the pivot in array
		printPivot(pivotNumber, numbers);
		//increment the number of operations
		numberOfOperations++;
		
		// 2. pivot around that into two groups
		// 2a. group before the pivot number
		//using list for the variable size of this operation
		List<Integer> prePivotNumber = new ArrayList<>(numbers.length - 1);
		// 2b. group after the pivot number
		List<Integer> postPivotNumber = new ArrayList<>(numbers.length - 1);
		// 2c. step through the array and fill the two buckets around pivot number
		for (int i = 0; i < numbers.length - 1; i++) {
			int currentNumber = numbers[i];
			if (pivotNumber >= currentNumber) {
				prePivotNumber.add(currentNumber);
			} else {
				postPivotNumber.add(currentNumber);
			}
		}

		// 3. recursively sort the array before and after
		Integer[] prePivotNumberArray = quickSort(prePivotNumber.toArray(new Integer[0]));
		Integer[] postPivotNumberArray = quickSort(postPivotNumber.toArray(new Integer[0]));

		// 4. combine
		Integer[] completelySortedArray = new Integer[numbers.length];
		//track how the array is being combined
		int i = 0;
		// 4a. combine for pre-array
		for (int j = 0; prePivotNumberArray != null && j < prePivotNumberArray.length; j++) {
			completelySortedArray[i] = prePivotNumberArray[j];
			i++;
		}
		// 4b. combine the pivot index
		completelySortedArray[i] = pivotNumber;
		i++;
		// 4c. combine for post-array
		for (int j = 0; postPivotNumberArray != null && j < postPivotNumberArray.length; j++) {
			completelySortedArray[i] = postPivotNumberArray[j];
			i++;
		}
		
		//combined array done
		return completelySortedArray;
	}
}
