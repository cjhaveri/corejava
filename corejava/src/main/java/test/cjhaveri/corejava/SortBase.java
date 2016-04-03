package test.cjhaveri.corejava;

import java.util.Arrays;

public class SortBase {

	protected int numberOfOperations = 0;

	public SortBase() {
		super();
	}
	
	public void printArray(Integer[] numbers) {
		System.out.println("Array size: " + numbers.length + ", Current Array: " + Arrays.toString(numbers));
	}

	public void printNumberOfOperations() {
		System.out.println("Number of operations: " + numberOfOperations);
	}

	public void printPivot(int pivotNumber, Integer[] numbers) {
		System.out.println("Picked pivot as: " + pivotNumber + ", in Array: " + Arrays.toString(numbers));
	}

}