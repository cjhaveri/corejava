package test.cjhaveri.corejava.sort;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Node implements Iterable<Node> {

	Node left;

	Node right;

	Node parent;

	int value;

	public Node(int value) {
		this.value = value;
	}

	public void setLeft(Node left) {
		this.left = left;
		left.parent = this;
	}

	public void setRight(Node right) {
		this.right = right;
		right.parent = this;
	}

	public int getValue() {
		return value;
	}

	@Override
	public Iterator<Node> iterator() {
		return new InOrderIterator(this);
	}

	/**
	 * This code not written by me. 
	 * Borrowed from: http://stackoverflow.com/questions/12850889/in-order-iterator-for-binary-tree
	 *
	 */
	class InOrderIterator implements Iterator<Node> {

		private Node next;

		public InOrderIterator(Node root) {
			next = root;
		     if(next == null)
		       return;
		     while (next.left != null)
		       next = next.left;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public Node next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Node r = next;
			// if you can walk right, walk right, then fully left.
			// otherwise, walk up until you come from left.
			if (next.right != null) {
				next = next.right;
				while (next.left != null)
					next = next.left;
				return r;
			} else
				while (true) {
					if (next.parent == null) {
						next = null;
						return r;
					}
					if (next.parent.left == next) {
						next = next.parent;
						return r;
					}
					next = next.parent;
				}
		}

	}

	public static void main(String[] args) {

		Node a = new Node(5);
		Node b = new Node(6);
		Node c = new Node(7);
		Node d = new Node(8);

		a.setLeft(b);
		d.setRight(c);

		b.setRight(d);
		Iterator<Node> it = a.iterator();
		while (it.hasNext()) {
			Node current = it.next();
			System.out.println(current.getValue());
		}

	}

}
