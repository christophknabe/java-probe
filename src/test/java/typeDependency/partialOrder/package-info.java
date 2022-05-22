/** This package demonstrates how to remove even type dependency cycles.
 * Class {@link Directory} still contains references to class {@link Entry}.
 * But the type dependency cycle is avoided by introducing an interface {@link HasPath}
 * which declares only the methods needed by an {@link Entry} from its parent {@link Directory}.
 * 
 * In the partial order of type dependencies {@link HasPath} is now the lowest, 
 * known to all other types. The partial type dependency order now looks as follows:
 * File -> Directory -> Entry -> HasPath,
 * File      ->         Entry.
 * @since 2022-05-22
 * @author Christoph Knabe
 */
package typeDependency.partialOrder;