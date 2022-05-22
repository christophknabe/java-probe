package typeDependency.partialOrder;

public class File extends Entry {

	private final String content;
	
	/** Users should not create a File object by this constructor,
	 * but by the factory method createFile in class Directory. 
	 */
	File(final Directory parent, final String name, final String content) {
		super(parent, name);
		this.content = content;
	}

	@Override
	public int size() {
		return content.length();
	}

}
