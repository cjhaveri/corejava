package test.cjhaveri.corejava;

import java.util.Arrays;
import java.util.Random;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class QuickSortTest {
	
	@Test (invocationCount = 100)
	public void testQuickSort() {
		Integer[] numbers = createRandomNumberArrays();
		//the test
		QuickSort qs = new QuickSort();
		Integer[] sortedNumbers = qs.quickSort(numbers);
		Arrays.sort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}

	@Test
	public void testQuickSortWithNullNumbers() {
		Integer[] numbers = null;
		//the test
		QuickSort qs = new QuickSort();
		Integer[] sortedNumbers = qs.quickSort(numbers);
		Assert.assertEquals(Arrays.toString(sortedNumbers), Arrays.toString(numbers));
	}
	
	private Integer[] createRandomNumberArrays() {
		//create a random number of integers
		Random randomizer = new Random();
		
		//randomly generate total numbers
		Integer totalNumbers = randomizer.nextInt() % 100;
		while (totalNumbers < 1) {
			totalNumbers = randomizer.nextInt() % 100;
		}
		
		//populate into the array
		Integer[] numbers = new Integer[totalNumbers];
		for (int i=0; i < totalNumbers; i++) {
			numbers [i] = randomizer.nextInt() % 100;
		}
		return numbers;
	}

}
