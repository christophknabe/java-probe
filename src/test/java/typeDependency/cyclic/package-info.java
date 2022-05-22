/** This package demonstrates how to cope with cyclic dependencies.
 * Class {@link typeDependency.cyclic.Directory} and {@link typeDependency.cyclic.Entry}
 * contain references to each other. So they constitute a type dependency cycle.
 * Directory needs references of the contained Entry objects in order to compute its total size.
 * Entry needs a reference to its parent Directory in order to compute the path the the Entry.
 * 
 * These cyclic references open up for a potentially infinite data structure.
 * By freezing all references immediately at construction time, 
 * we assure that only a finite tree can be constructed at run time.
 * @since 2022-05-22
 * @author Christoph Knabe
 * */
package typeDependency.cyclic;