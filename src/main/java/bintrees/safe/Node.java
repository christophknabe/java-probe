package bintrees.safe;

import java.lang.Math;

public class Node<CONTENT> extends Tree<CONTENT> {
	
	private final Tree<CONTENT> left; //must not be null!
	private final CONTENT content; //must not be null!
	private final Tree<CONTENT> right; //must not be null!
	
	public Node(final Tree<CONTENT> left, final CONTENT content, final Tree<CONTENT> right) {
		if(left==null) {
			throw new IllegalArgumentException("Illegal null argument for left");
		}
		if(content==null) {
			throw new IllegalArgumentException("Illegal null argument for content");
		}
		if(right==null) {
			throw new IllegalArgumentException("Illegal null argument for right");
		}
		this.left = left;
		this.content = content;
		this.right = right;
	}

	@Override
	boolean isEmpty() {
		// A Node is never empty!
		return false;
	}

	@Override
	boolean isLeaf() {
		return left.isEmpty() && right.isEmpty();
	}

	@Override
	public int height() {
		return Math.max(left.height(), right.height()) + 1;
	}
	
	/** Returns true if the given content is contained in this node or its successors. */
	public boolean contains(final CONTENT content) {
		if(this.content.equals(content)) {
			return true;
		}
		if(left.contains(content)) {
			return true;
		}
		if(right.contains(content)) {
			return true;
		}
		return false;
	}
	
	public void preorderPrint(final int level) {
		indent(level);
		System.out.println(content);
		left.preorderPrint(level+1);
		right.preorderPrint(level+1);
	}

	private void indent(int level) {
		for(int i=1; i<level; i++) {
			System.out.print("|  ");
		}		
		if(level>0) {
		    System.out.print("+--");
		}
	}
	
	/** Tests the Node class by constructing and printing a little tree. */
	public static void main(final String... args) {		
		final Empty<Integer> EMPTY = new Empty<Integer>();
		final Node<Integer> tree = new Node<Integer>(
				new Node<Integer>(
						new Node<Integer>(EMPTY, 6, EMPTY), 
						9, 
						new Node<Integer>(EMPTY, 15, EMPTY)
						),
				17,
				new Node<Integer>(EMPTY, 25, EMPTY));
		tree.preorderPrint();		
	}

}
