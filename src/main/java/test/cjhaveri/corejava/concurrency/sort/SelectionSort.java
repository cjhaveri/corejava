package test.cjhaveri.corejava.concurrency.sort;

import java.util.Arrays;

public class SelectionSort extends SortBase {

	public Integer [] selectionSort(Integer[] numbers) {
		
		//handle nulls
		if (numbers == null || numbers.length == 0) {
			return null;
		}

		int frontOfTheListIndex = 0;
		//// when the "front" of the list is the size of the list you are done
		for (int i = frontOfTheListIndex; i < numbers.length; i++) {
			int currentLowest = numbers[frontOfTheListIndex];
			int currentLowestIndex = frontOfTheListIndex;
			// go through the rest of the list
			for (int j = i; j < numbers.length; j++) {
				numberOfOperations++;
				if (j != numbers.length) {
					int nextNumber = numbers[j];
					// keep track of the lowest number at every pass
					if (currentLowest > nextNumber) {
						currentLowest = numbers[j];
						currentLowestIndex = j;
					}
				}
			} //end inner for loop

			// put it at the "front" of the list
			if (currentLowestIndex != frontOfTheListIndex) {
				// now swap the front of the index with lowest
				numbers[currentLowestIndex] = numbers[frontOfTheListIndex];
				numbers[frontOfTheListIndex] = currentLowest;
			}

			//the "front" of the list is always increasing
			frontOfTheListIndex++;

			printArray(numbers);
		}//end outer for loop
		
		return Arrays.copyOf(numbers, numbers.length);
	}

	public static void main(String[] args) {

		SelectionSort ss = new SelectionSort();
		Integer[] numbers = { 9, 4, 2, 0, -1, 8, 6, 2 };
		ss.selectionSort(numbers);
		ss.printNumberOfOperations();

	}

}
