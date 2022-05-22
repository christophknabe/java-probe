package bintrees.safe;

public class Empty<CONTENT> extends Tree<CONTENT> {

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	boolean isLeaf() { //An Empty is not a Node, so cannot be a leaf.
		return false;
	}

	@Override
	public int height() { // Must be so that the height of a leaf node becomes 0.
		return -1;
	}

	@Override
	public boolean contains(CONTENT content) {
		return false;
	}

	@Override
	public void preorderPrint(int i) { //do nothing
	}

}
