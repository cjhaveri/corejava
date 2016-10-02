package test.cjhaveri.corejava.concurrency;

import java.util.Iterator;
import java.util.List;

/**
 * Class with a custom iterator that can skip over several numbers
 * 
 * @author chetanjhaveri
 *
 */
public class States implements Iterable<String> {

	/**
	 * List of states
	 */
	private List<String> states;

	/**
	 * Number to skip when iterating over
	 */
	private int skipNumber;

	/**
	 * Constructor that initializes both states and skip number
	 * 
	 * @param states
	 *            list of states to traverse
	 * @param skipNumber
	 *            number of indexes to skip
	 */
	public States(List<String> states, int skipNumber) {
		// check arguments
		if (skipNumber <= 0) {
			throw new IllegalArgumentException("Skip number has to be greater than zero");
		}
		// initialize fields
		this.states = states;
		this.skipNumber = skipNumber;
	}

	/**
	 * Constructor that defaults the skip number to 1
	 * 
	 * @param states
	 *            list of states to traverse
	 */
	public States(List<String> states) {
		this.states = states;
		this.skipNumber = 1;
	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new SkipIterator();
	}

	/**
	 * Inner class with a skip iterator that can skip over several indexes
	 * 
	 * @author chetanjhaveri
	 */
	class SkipIterator implements Iterator<String> {

		/**
		 * track the current index
		 */
		private int current;

		/**
		 * Constructor to initialize the current to zero
		 */
		public SkipIterator() {
			current = 0;
		}

		@Override
		public boolean hasNext() {
			// handle null and empty
			if (states == null || states.isEmpty()) {
				return false;
			}

			// handle the first one
			if (current == 0) {
				return true;
			}

			// handle the number of states has exceeded the current
			if (current + skipNumber > states.size()) {
				return false;
			}
			// otherwise we hae ability to return
			return true;
		}

		@Override
		public String next() {
			// check if has next
			if (!hasNext()) {
				return null;
			}
			// save the current one
			int toReturn = current;
			// add the skip number
			current += skipNumber;
			// return the number
			return states.get(toReturn);
		}
	}
}
