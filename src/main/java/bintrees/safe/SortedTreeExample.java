package bintrees.safe;

/** Treats a graph of nodes, starting from a root node, as a tree. */
public class SortedTreeExample {
		
	public static void main(final String... args) {
		final Tree<Integer> sortedTree = exampleSortedBinaryTree();
		sortedTree.preorderPrint();
		for(int i=5; i<=21; i++) {
			final boolean isContained = sortedTree.contains(Integer.valueOf(i));
			System.out.printf("%2d %b\n", i, isContained);
		}
	}

	private static Tree<Integer> exampleSortedBinaryTree() {
		final Empty<Integer> EMPTY = new Empty<Integer>();
		final Tree<Integer> result = new Node<Integer>(
				new Node<Integer>(
						new Node<Integer>(EMPTY, 6, EMPTY), 
						9, 
						new Node<Integer>(EMPTY, 15, EMPTY)
						),
				17,
				new Node<Integer>(
						new Node<Integer>(EMPTY, 20, EMPTY), 
						25, 
						new Node<Integer>(EMPTY, 29, EMPTY)));
		return result;		
	}	
	

}
