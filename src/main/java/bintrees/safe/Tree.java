package bintrees.safe;

/** A binary tree in its safe variant with null objects instead of nullable references. 
 * See <a href="https://de.wikipedia.org/wiki/Nullobjekt_(Entwurfsmuster)">Nullobjekt (Entwurfsmuster)</a>.
 * An empty tree or empty left or right child tree is represented by Tree.NULL. */
public abstract class Tree<CONTENT> {
	
	/** Returns true if this tree is empty. */
	abstract boolean isEmpty();
	
	/** Returns true if this node does not have children. */
	abstract boolean isLeaf();
	
	/** Returns the number of edges on the longest path from this node to a leaf. */
	abstract public int height();
	
	/** Returns true if the given content is contained in this tree. */
	abstract public boolean contains(final CONTENT content);

	/** Prints the tree in a pre-order way. Each node on a line with indentation. */
	public void preorderPrint() {
		preorderPrint(0);
	}
	
	/** Prints the tree in a pre-order way. Each node on a line with indentation on the given level.
	 * @param level the indentation level. 0 means no indentation. */
	abstract void preorderPrint(int level);

}
