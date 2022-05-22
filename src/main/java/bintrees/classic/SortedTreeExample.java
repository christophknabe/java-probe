package bintrees.classic;

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
		final Tree<Integer> result = new Tree<Integer>(
				new Tree<Integer>(
						new Tree<Integer>(null, 6, null), 
						9, 
						new Tree<Integer>(null, 15, null)
						),
				17,
				new Tree<Integer>(
						new Tree<Integer>(null, 20, null), 
						25, 
						new Tree<Integer>(null, 29, null)));
		return result;		
	}
	
	

}
