package bintrees.classic;

/** A binary tree in its classic variant with nullable references. 
 * An empty tree or empty left or right child tree is represented by null. */
public class Tree<CONTENT> {
	
	private final Tree<CONTENT> left; //null means end.
	private final CONTENT content; //must not be null!
	private final Tree<CONTENT> right; //null means end.
	
	public Tree(final Tree<CONTENT> left, final CONTENT content, final Tree<CONTENT> right) {
		if(content==null) {
			throw new IllegalArgumentException("Illegal null CONTENT");
		}
		this.left = left;
		this.right = right;
		this.content = content;
	}
	
	public Tree<CONTENT> getLeft(){
		return left;
	}
	
	public CONTENT getContent() {
		return content;
	}
	
	public Tree<CONTENT> getRight(){
		return right;
	}
	
	/** Returns true if the given content is contained in this node or its successors. */
	public boolean contains(final CONTENT content) {
		if(this.content.equals(content)) {
			return true;
		}
		if(left!=null && left.contains(content)) {
			return true;
		}
		if(right!=null && right.contains(content)) {
			return true;
		}
		return false;
	}
	
	public void preorderPrint() {
		preorderPrint(0);
	}
	public void preorderPrint(final int level) {
		indent(level);
		System.out.println(content);
		if(left!=null) {
			left.preorderPrint(level+1);
		}
		if(right!=null) {
			right.preorderPrint(level+1);
		}
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
		final Tree<Integer> tree = new Tree<Integer>(
				new Tree<Integer>(
						new Tree<Integer>(null, 6, null), 
						9, 
						new Tree<Integer>(null, 15, null)
						),
				17,
				new Tree<Integer>(null, 25, null));
		tree.preorderPrint();		
	}

}
