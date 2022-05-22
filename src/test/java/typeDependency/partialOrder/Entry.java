package typeDependency.partialOrder;

/** An entry in a directory. */
public abstract class Entry implements HasPath {
	
	private final HasPath parent;
	private final String name;
	
	/** Creates a root entry. */
	protected Entry(final String name) {
		this(null, name);
	}
	
	/** Creates an entry in the given parent directory. */
	protected Entry(final HasPath parent, final String name) {
		this.parent = parent;
		this.name = name;
	}
	
	public String getPath() {
		final String parentPath = parent==null ? "" : parent.getPath();
		return parentPath + "/" + name;
	}
	
	/** Returns the total size of this entry. */
	public abstract int size();

}
