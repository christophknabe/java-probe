package typeDependency.partialOrder;

/** This interface declares the methods {@link Entry} needs from {@link Directory},
 * but avoids a dependency on {@link Directory}. */
public interface HasPath {

	String getPath();
	
}