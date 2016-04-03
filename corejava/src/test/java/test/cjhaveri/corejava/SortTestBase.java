package test.cjhaveri.corejava;

import java.util.Random;

public class SortTestBase {

	public SortTestBase() {
		super();
	}

	protected Integer[] createRandomNumberArrays() {
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