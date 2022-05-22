package typeDependency.cyclic;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {

	private final List<Entry> entries = new ArrayList<Entry>();
	
	/** Creates a root directory. */
	public Directory(final String name) {
		this(null, name);
	}
	
	/** Creates a directory in the given parent directory. */
	private Directory(final Directory parent, final String name) {
		super(parent, name);
	}

	/** Creates a file in this directory with the given name and content. */
	public Directory createDirectory(final String name) {
		final Directory result = new Directory(this, name);
		entries.add(result);
		return result;
	}
	
	/** Creates a file in this directory with the given name and content. */
	public File createFile(final String name, final String content) {
		final File result = new File(this, name, content);
		entries.add(result);
		return result;
	}
	
	public int size() {
		int result = 0;
		for(final Entry entry: entries) { result += entry.size(); }
		return result;
	}

}
