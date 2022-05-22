import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/**Get and print System Properties.
 * @author Christoph Knabe
 * @since 2000-01-31
 * @version 2017-12-09 with sorting before printing
 */
public class PropertiesPrint extends java.applet.Applet {

	/** Bei Benutzung als Applet: Ausgabe in der Java-Console des Browsers */
	public void init() {
		_listProperties();
	}

	/** Bei Benutzung als Application: Ausgabe im Konsolfenster */
	public static void main(final String[] i_args) {
		_listProperties();
	}

	/* Die System-Properties werden auf System.out ausgegeben. */
	private static void _listProperties() {
		System.out.println("Locale.getDefault()=" + java.util.Locale.getDefault());
		// Get and print one system property:
		final String userHome = System.getProperty("user.home");
		System.out.println("user.home = " + userHome);

		// Get, sort, and print all system properties:
		final java.util.Properties properties = System.getProperties();
		final Set<Entry<Object, Object>> entrySet = properties.entrySet();
		final List<String> lines = new ArrayList<String>();
		for (final Entry<Object, Object> entry : entrySet) {
			lines.add(entry.getKey().toString() + "=" + entry.getValue());
		}
		Collections.sort(lines);
		System.out.println("===== Java System Properties =====");
		for (final String line : lines) {
			System.out.println(line);
		}
	}

}// PropertiesTest