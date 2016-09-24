package test.cjhaveri.corejava.sort;

import java.util.Arrays;

public class BubbleSort extends SortBase {
	
	public Integer [] bubbleSort(Integer [] numbers) {
		
		//handle null
		if (numbers == null) {
			return null;
		}
		
		//1. go through the list for each index at least once
		//2. take the current index and swap with next index if the next index is lower
		//3. move to the next index
		//indicator to track whether any swapping happened
		boolean swappedAtLeastOnce = false;
		do {
			
			//reset the indicator
			swappedAtLeastOnce = false;
			for (int i=0; i < numbers.length; i++) {
				int currentValue = numbers[i];
				//detect for the last one
				if (i + 1 != numbers.length) {
					int nextValue = numbers[i+1];
					//swap if next is higher
					if (currentValue > nextValue) {
						numbers[i] = nextValue;
						numbers[i+1] = currentValue;
						//set the indicator
						swappedAtLeastOnce = true;
						numberOfOperations++;
						//print the array
						printArray(numbers);
					}
					
				}
			}
		} while (swappedAtLeastOnce);
	
		return Arrays.copyOf(numbers, numbers.length);
		
		
		
		
		
	}
	
	public static void main(String [] args) {
		
		Integer [] numbers = {5, 9, 4, 2, 0, -1};
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(numbers);
		bs.printNumberOfOperations();
		
		
	}
	

}
